package com.eduardosantos.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FavoriteMessages.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_FAVORITE_MESSAGES = "favorite_messages";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MESSAGE = "message";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_FAVORITE_MESSAGES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_MESSAGE + " TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insertFavoriteMessage(String message) {
        SQLiteDatabase db = getWritableDatabase();
        long id = -1;
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_MESSAGE, message);
            id = db.insert(TABLE_FAVORITE_MESSAGES, null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return id;
    }

    public Cursor getAllFavoriteMessages() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(TABLE_FAVORITE_MESSAGES, null, null, null, null, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursor;
    }

    public void removeFavoriteMessage(String message) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String selection = COLUMN_MESSAGE + "=?";
            String[] selectionArgs = {message};
            db.delete(TABLE_FAVORITE_MESSAGES, selection, selectionArgs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
