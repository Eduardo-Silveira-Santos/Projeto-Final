package com.eduardosantos.afinal;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout messagesContainer;
    private EditText inputMessage;
    private ImageButton sendButton, voiceButton, clearButton, favoriteButton;
    private static final int TEXT_VOICE = 100;
    private TextToSpeech messagesSpeaker;
    private String speechPrompt, speechNotSupported;
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
        initializeTextToSpeech();
        initializeSpeechStrings();
        dbHelper = new DBHelper(this);
    }

    private void initializeViews() {
        messagesContainer = findViewById(R.id.messagesContainer);
        inputMessage = findViewById(R.id.inputMessage);
        sendButton = findViewById(R.id.sendButton);
        voiceButton = findViewById(R.id.voiceButton);
        clearButton = findViewById(R.id.clearButton);
        favoriteButton = findViewById(R.id.favoriteButton);
    }

    private void initializeListeners() {
        sendButton.setOnClickListener(this);
        voiceButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        favoriteButton.setOnClickListener(this);
    }

    private void initializeTextToSpeech() {
        messagesSpeaker = new TextToSpeech(this, status -> {
            if (status != TextToSpeech.ERROR) {
                messagesSpeaker.setLanguage(Locale.getDefault());
            }
        });
    }

    private void initializeSpeechStrings() {
        speechPrompt = getString(R.string.speech_prompt);
        speechNotSupported = getString(R.string.speech_not_supported);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sendButton) {
            sendMessage();
        } else if (id == R.id.voiceButton) {
            startSpeechToText();
        } else if (id == R.id.clearButton) {
            clearChat();
        } else if (id == R.id.favoriteButton) {
            navigateToFavoriteMessages();
        }
    }

    private void navigateToFavoriteMessages() {
        Intent intent = new Intent(MainActivity.this, FavoriteMessagesActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_VOICE) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                if (result != null && !result.isEmpty()) {
                    processSpokenText(result.get(0));
                } else {
                    showToast("No speech result");
                }
            } else {
                showToast("Speech recognition failed");
            }
        }
    }

    private void processSpokenText(String spokenText) {
        addMessage(spokenText, false);
        getBotResponse(spokenText);
    }

    private void sendMessage() {
        String message = inputMessage.getText().toString();
        if (!message.isEmpty()) {
            addMessage(message, false);
            inputMessage.getText().clear();
            getBotResponse(message);
        }
    }

    private void startSpeechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, speechPrompt);
        try {
            startActivityForResult(intent, TEXT_VOICE);
        } catch (ActivityNotFoundException e) {
            showToast(speechNotSupported);
        }
    }

    private void addMessage(String message, boolean isBot) {
        View messageView = LayoutInflater.from(this).inflate(R.layout.chat_item, messagesContainer, false);
        configureMessageView(messageView, message, isBot);
        messagesContainer.addView(messageView);
        scrollToBottom();
    }

    private void configureMessageView(View messageView, String message, boolean isBot) {
        TextView textView = messageView.findViewById(isBot ? R.id.left_chat_text_view : R.id.right_chat_text_view);
        textView.setText(message);
        View leftView = messageView.findViewById(R.id.left_chat_view);
        View rightView = messageView.findViewById(R.id.right_chat_view);
        leftView.setVisibility(isBot ? View.VISIBLE : View.GONE);
        rightView.setVisibility(isBot ? View.GONE : View.VISIBLE);
    }

    private void scrollToBottom() {
        ScrollView scrollView = (ScrollView) messagesContainer.getParent();
        scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
    }

    private void speakMessage(String message) {
        AsyncTask.execute(() -> messagesSpeaker.speak(message, TextToSpeech.QUEUE_FLUSH, null, null));
    }

    private void getBotResponse(String userMessage) {
        GeminiService gms = new GeminiService();
        Log.d("TAG", "This is a debug message");
        ListenableFuture<GenerateContentResponse> response = gms.getResponse(userMessage);
        Executor executor = Executors.newSingleThreadExecutor();
        Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
            @Override
            public void onSuccess(GenerateContentResponse result) {
                runOnUiThread(() -> {
                    String resultText = result.getText();
                    if (resultText != null) {
                        String recipe = Prompts.getRecipe(resultText);
                        if (recipe != null) {
                            addMessage(resultText, true);
                            speakMessage(resultText);
                        } else {
                            showToast("Failed to generate recipe");
                        }
                    } else {
                        showToast("Failed to get response text");
                    }
                });
            }
            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                runOnUiThread(() -> showToast("Failed to get bot response"));
            }
        }, executor);
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onMessageClicked(View view) {
        String message = extractMessageFromView(view);
        showFavoriteConfirmationDialog(message);
    }

    private void showFavoriteConfirmationDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Favoritar Resposta")
                .setMessage("Deseja favoritar esta resposta?")
                .setPositiveButton("Favoritar", (dialog, which) -> addToFavorites(message))
                .setNegativeButton("Cancelar", null)
                .show();
    }

    private void addToFavorites(String message) {
        // Adiciona a mensagem favorita ao banco de dados
        long id = dbHelper.insertFavoriteMessage(message);

        if (id != -1) {
            Toast.makeText(this, "Resposta favoritada!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha ao favoritar resposta", Toast.LENGTH_SHORT).show();
        }
    }


    private String extractMessageFromView(View view) {
        TextView textView = view.findViewById(R.id.left_chat_text_view);
        return textView.getText().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (messagesSpeaker == null) {
            initializeTextToSpeech();
        }
    }

    @Override
    protected void onPause() {
        if (messagesSpeaker != null) {
            messagesSpeaker.stop();
            messagesSpeaker.shutdown();
            messagesSpeaker = null;
        }
        super.onPause();
    }

    public void clearChat() {
        messagesContainer.removeAllViews();
    }
}
