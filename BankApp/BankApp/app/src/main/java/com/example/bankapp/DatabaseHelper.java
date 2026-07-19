package com.example.bankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BankApp.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE transactions(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "receiver TEXT," +
                "amount TEXT," +
                "remarks TEXT," +
                "date TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS transactions");
        onCreate(db);

    }

    public boolean insertTransaction(String receiver,
                                     String amount,
                                     String remarks,
                                     String date) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("receiver", receiver);
        values.put("amount", amount);
        values.put("remarks", remarks);
        values.put("date", date);

        long result = db.insert("transactions", null, values);

        return result != -1;
    }

    public ArrayList<Transaction> getTransactions() {

        ArrayList<Transaction> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM transactions ORDER BY id DESC",
                null
        );

        while (cursor.moveToNext()) {

            list.add(new Transaction(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            ));

        }

        cursor.close();

        return list;
    }
}