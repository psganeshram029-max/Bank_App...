package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_home,
                container,
                false);

        ImageButton btnScan = view.findViewById(R.id.btnScan);
        ImageButton btnPay = view.findViewById(R.id.btnPay);
        ImageButton btnTransfer = view.findViewById(R.id.btnTransfer);
        ImageButton btnRecharge = view.findViewById(R.id.btnRecharge);

        // Scan QR
        btnScan.setOnClickListener(v -> {

            IntentIntegrator integrator =
                    IntentIntegrator.forSupportFragment(HomeFragment.this);

            integrator.setPrompt("Scan QR Code");
            integrator.setBeepEnabled(true);
            integrator.setOrientationLocked(false);
            integrator.initiateScan();

        });

        // Pay
        btnPay.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), PaymentActivity.class);
            startActivity(intent);

        });

        // Transfer
        btnTransfer.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), TransferActivity.class);
            startActivity(intent);

        });

        // Recharge
        btnRecharge.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), RechargeActivity.class);
            startActivity(intent);

        });

        return view;
    }
}