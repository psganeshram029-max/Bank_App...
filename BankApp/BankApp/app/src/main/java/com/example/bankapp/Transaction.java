package com.example.bankapp;

public class Transaction {

    private int id;
    private String receiver;
    private String amount;
    private String remarks;
    private String date;

    public Transaction() {
    }

    public Transaction(int id, String receiver, String amount, String remarks, String date) {
        this.id = id;
        this.receiver = receiver;
        this.amount = amount;
        this.remarks = remarks;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getAmount() {
        return amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getDate() {
        return date;
    }
}