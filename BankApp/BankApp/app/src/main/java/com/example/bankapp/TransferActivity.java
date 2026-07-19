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

public class TransferActivity extends AppCompatActivity {

    EditText etReceiver, etAmount, etRemarks;
    Button btnTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        etReceiver = findViewById(R.id.etReceiver);
        etAmount = findViewById(R.id.etAmount);
        etRemarks = findViewById(R.id.etRemarks);
        btnTransfer = findViewById(R.id.btnTransfer);

        btnTransfer.setOnClickListener(v -> {

            String receiver = etReceiver.getText().toString().trim();
            String amount = etAmount.getText().toString().trim();
            String remarks = etRemarks.getText().toString().trim();

            if (receiver.isEmpty()) {
                etReceiver.setError("Enter Receiver Account");
                return;
            }

            if (amount.isEmpty()) {
                etAmount.setError("Enter Amount");
                return;
            }

            SharedPreferences sp = getSharedPreferences("bank", MODE_PRIVATE);

            int balance = sp.getInt("balance", 50000);

            int transferAmount = Integer.parseInt(amount);

            if (transferAmount > balance) {
                Toast.makeText(this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
                return;
            }

            balance = balance - transferAmount;

            String date = new SimpleDateFormat(
                    "dd/MM/yyyy HH:mm",
                    Locale.getDefault()
            ).format(new Date());

            String oldHistory = sp.getString("history", "");

            String newHistory =
                    "Transferred ₹" + transferAmount + " to " + receiver +
                            "\n" + date +
                            "\n\n" + oldHistory;

            sp.edit()
                    .putInt("balance", balance)
                    .putString("history", newHistory)
                    .apply();

            Toast.makeText(this, "Transfer Successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(TransferActivity.this, SuccessActivity.class);
            intent.putExtra("amount", amount);
            startActivity(intent);
            finish();

        });
    }
}