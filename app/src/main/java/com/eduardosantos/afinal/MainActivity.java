package com.eduardosantos.afinal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout messagesContainer;
    private EditText inputMessage;
    private ImageButton sendButton, voiceButton, clearButton;
    private static final int TEXT_VOICE = 100;
    private TextToSpeech messagesSpeaker;
    private String speechPrompt, speechNotSupported;
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
        initializeTextToSpeech();
        initializeSpeechStrings();
    }

    private void initializeViews() {
        messagesContainer = findViewById(R.id.messagesContainer);
        inputMessage = findViewById(R.id.inputMessage);
        sendButton = findViewById(R.id.sendButton);
        voiceButton = findViewById(R.id.voiceButton);
        clearButton = findViewById(R.id.clearButton);
    }

    private void initializeListeners() {
        sendButton.setOnClickListener(this);
        voiceButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
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
        }
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
        String recipe = Prompts.getRecipe(userMessage);
        addMessage(recipe, true);  // Adiciona a mensagem da receita ao histórico de mensagens
        speakMessage(recipe);      // Opcional: Lê em voz alta a receita
    }


    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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