package com.eduardosantos.afinal;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoriteMessagesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FavoriteMessagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_messages);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> favoriteMessages = loadFavoriteMessages();

        adapter = new FavoriteMessagesAdapter(favoriteMessages, message -> {
            showFavoriteConfirmationDialog(message);
        });

        recyclerView.setAdapter(adapter);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());
    }

    private List<String> loadFavoriteMessages() {
        DBHelper dbHelper = new DBHelper(this);
        List<String> favoriteMessages = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = dbHelper.getAllFavoriteMessages();
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String message = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_MESSAGE));
                    favoriteMessages.add(message);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            dbHelper.close();
        }
        return favoriteMessages;
    }

    private void showFavoriteConfirmationDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Remover dos Favoritos")
                .setMessage("Deseja remover esta mensagem dos favoritos?")
                .setPositiveButton("Remover", (dialog, which) -> removeFromFavorites(message))
                .setNegativeButton("Cancelar", null)
                .show();
    }

    private void removeFromFavorites(String message) {
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.removeFavoriteMessage(message);
        List<String> updatedFavoriteMessages = loadFavoriteMessages();
        adapter.updateFavoriteMessages(updatedFavoriteMessages);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
