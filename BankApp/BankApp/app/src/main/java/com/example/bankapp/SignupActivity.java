package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText etName, etMobile, etEmail,
            etPassword, etConfirmPassword;

    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String mobile = etMobile.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (name.isEmpty() || mobile.isEmpty() || email.isEmpty()
                    || password.isEmpty() || confirmPassword.isEmpty()) {

                Toast.makeText(this,
                        "Fill all fields",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {

                Toast.makeText(this,
                        "Passwords do not match",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this,
                    "Account Created Successfully",
                    Toast.LENGTH_SHORT).show();

            startActivity(new Intent(SignupActivity.this,
                    MainActivity.class));

            finish();

        });

    }
}