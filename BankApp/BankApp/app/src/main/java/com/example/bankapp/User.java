package com.example.bankapp;

public class User {

    private String name;
    private String mobile;
    private String email;
    private String password;

    public User(String name, String mobile,
                String email, String password) {

        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }
}