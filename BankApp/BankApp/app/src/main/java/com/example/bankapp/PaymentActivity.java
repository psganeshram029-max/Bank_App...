package com.example.bankapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PaymentActivity extends AppCompatActivity {

    private EditText etPayTo, etAmount;
    private Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        etPayTo = findViewById(R.id.etPayTo);
        etAmount = findViewById(R.id.etAmount);
        btnPay = findViewById(R.id.btnPay);

        btnPay.setOnClickListener(v -> {

            String payTo = etPayTo.getText().toString().trim();
            String amount = etAmount.getText().toString().trim();

            if (payTo.isEmpty()) {
                etPayTo.setError("Enter Receiver Name / UPI ID");
                return;
            }

            if (amount.isEmpty()) {
                etAmount.setError("Enter Amount");
                return;
            }

            SharedPreferences sp = getSharedPreferences("bank", MODE_PRIVATE);

            int balance = sp.getInt("balance", 50000);
            int payAmount = Integer.parseInt(amount);

            if (payAmount > balance) {
                Toast.makeText(this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
                return;
            }

            balance -= payAmount;

            String date = new SimpleDateFormat(
                "dd/MM/yyyy HH:mm",
                    Locale.getDefault()
            ).format(new Date());

            String oldHistory = sp.getString("history", "");

            String newHistory =
                    "Paid ₹" + payAmount + " to " + payTo +
                            "\n" + date +
                            "\n\n" + oldHistory;

            sp.edit()
                    .putInt("balance", balance)
                    .putString("history", newHistory)
                    .apply();

            Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(PaymentActivity.this, SuccessActivity.class);
            intent.putExtra("amount", amount);
            startActivity(intent);
            finish();
        });
    }
}