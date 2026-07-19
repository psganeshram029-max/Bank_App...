package com.example.bankapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {

    private TextView tvAccountNumber, tvBalance;
    private RecyclerView recyclerView;

    private ArrayList<TransactionModel> transactionList;
    private TransactionAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        tvAccountNumber = view.findViewById(R.id.tvAccountNumber);
        tvBalance = view.findViewById(R.id.tvBalance);
        recyclerView = view.findViewById(R.id.recyclerView);

        SharedPreferences sp = requireActivity().getSharedPreferences(
                "bank",
                Context.MODE_PRIVATE);

        int balance = sp.getInt("balance", 50000);

        tvAccountNumber.setText("Account No : 7894561234");
        tvBalance.setText("Balance : ₹" + balance);

        transactionList = new ArrayList<>();

        String history = sp.getString("history", "");

        if (!history.isEmpty()) {

            String[] lines = history.split("\n\n");

            for (String item : lines) {

                String[] parts = item.split("\n");

                if (parts.length >= 2) {

                    transactionList.add(new TransactionModel(
                            parts[0],
                            parts[1]
                    ));
                }
            }
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new TransactionAdapter(transactionList);

        recyclerView.setAdapter(adapter);

        return view;
    }
}