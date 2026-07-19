package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class RechargeActivity extends AppCompatActivity {

    Button btnShowPlans;
    RadioGroup radioGroup;
    LinearLayout plansContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        btnShowPlans = findViewById(R.id.btnShowPlans);
        radioGroup = findViewById(R.id.radioGroup);
        plansContainer = findViewById(R.id.plansContainer);

        btnShowPlans.setOnClickListener(v -> {

            plansContainer.removeAllViews();

            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == R.id.rbJio) {

                addPlanCard("₹299", "1.5GB/day + Unlimited Calls");
                addPlanCard("₹399", "2GB/day + Unlimited Calls");
                addPlanCard("₹666", "84 Days Validity");

            } else if (selectedId == R.id.rbAirtel) {

                addPlanCard("₹299", "1GB/day + Unlimited Calls");
                addPlanCard("₹479", "1.5GB/day + Unlimited Calls");
                addPlanCard("₹719", "84 Days Validity");

            } else if (selectedId == R.id.rbVi) {

                addPlanCard("₹299", "1GB/day + Unlimited Calls");
                addPlanCard("₹359", "2GB/day + Unlimited Calls");
                addPlanCard("₹539", "Unlimited Night Data");

            } else if (selectedId == R.id.rbBsnl) {

                addPlanCard("₹187", "2GB/day");
                addPlanCard("₹397", "150 Days Validity");
                addPlanCard("₹797", "365 Days Validity");

            } else {

                Toast.makeText(
                        RechargeActivity.this,
                        "Please Select Operator",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    private void addPlanCard(String price, String details) {

        CardView card = new CardView(this);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(0, 20, 0, 0);

        card.setLayoutParams(params);
        card.setRadius(20);
        card.setCardElevation(8);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 30, 30, 30);

        TextView tvPrice = new TextView(this);
        tvPrice.setText(price);
        tvPrice.setTextSize(24);

        TextView tvDetails = new TextView(this);
        tvDetails.setText(details);
        tvDetails.setTextSize(16);

        Button btnRecharge = new Button(this);
        btnRecharge.setText("Recharge Now");

        btnRecharge.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            RechargeActivity.this,
                            PaymentActivity.class);

            intent.putExtra("plan", price);

            startActivity(intent);

        });

        layout.addView(tvPrice);
        layout.addView(tvDetails);
        layout.addView(btnRecharge);

        card.addView(layout);

        plansContainer.addView(card);
    }
}