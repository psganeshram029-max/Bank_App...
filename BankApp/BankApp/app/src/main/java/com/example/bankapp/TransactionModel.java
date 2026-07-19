package com.example.bankapp;

public class TransactionModel {

    String title;
    String date;

    public TransactionModel(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}