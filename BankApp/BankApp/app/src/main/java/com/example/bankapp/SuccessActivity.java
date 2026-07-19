package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    TextView tvTitle, tvAmount;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        tvTitle = findViewById(R.id.tvTitle);
        tvAmount = findViewById(R.id.tvAmount);
        btnHome = findViewById(R.id.btnHome);

        String title = getIntent().getStringExtra("title");
        String amount = getIntent().getStringExtra("amount");

        tvTitle.setText(title + " Successful");
        tvAmount.setText("₹ " + amount);

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(SuccessActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}