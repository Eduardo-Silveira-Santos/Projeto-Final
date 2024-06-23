package com.eduardosantos.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHelperMessages extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "chat_db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USER_MESSAGES = "user_messages";
    private static final String TABLE_BOT_MESSAGES = "bot_messages";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MESSAGE = "message";

    public DBHelperMessages(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabela para mensagens do usuário
        String createUserMessagesTable = "CREATE TABLE " + TABLE_USER_MESSAGES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_MESSAGE + " TEXT)";
        db.execSQL(createUserMessagesTable);

        // Tabela para mensagens do bot
        String createBotMessagesTable = "CREATE TABLE " + TABLE_BOT_MESSAGES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_MESSAGE + " TEXT)";
        db.execSQL(createBotMessagesTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aqui você pode implementar a lógica de upgrade do banco de dados se necessário
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_MESSAGES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOT_MESSAGES);
        onCreate(db);
    }

    // Método para inserir mensagem do usuário
    public long insertUserMessage(String message) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MESSAGE, message);
        long id = db.insert(TABLE_USER_MESSAGES, null, values);
        db.close();
        return id;
    }

    // Método para inserir mensagem do bot
    public long insertBotMessage(String message) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MESSAGE, message);
        long id = db.insert(TABLE_BOT_MESSAGES, null, values);
        db.close();
        return id;
    }

    // Método para recuperar as últimas mensagens do usuário em ordem crescente de ID
    public List<String> getLastUserMessages(int limit) {
        List<String> messages = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER_MESSAGES, new String[]{COLUMN_MESSAGE}, null,
                null, null, null, COLUMN_ID + " ASC", String.valueOf(limit));

        while (cursor.moveToNext()) {
            String message = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MESSAGE));
            messages.add(message);
        }
        cursor.close();
        db.close();

        return messages;
    }

    // Método para recuperar as últimas mensagens do bot em ordem crescente de ID
    public List<String> getLastBotMessages(int limit) {
        List<String> messages = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BOT_MESSAGES, new String[]{COLUMN_MESSAGE}, null,
                null, null, null, COLUMN_ID + " ASC", String.valueOf(limit));

        while (cursor.moveToNext()) {
            String message = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MESSAGE));
            messages.add(message);
        }
        cursor.close();
        db.close();

        return messages;
    }

    public void clearAllMessages() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER_MESSAGES, null, null);
        db.delete(TABLE_BOT_MESSAGES, null, null);
        db.close();
    }
}

