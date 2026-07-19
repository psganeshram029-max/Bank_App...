package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_profile,
                container,
                false);

        Button btnLogout =
                view.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(v -> {

            Intent intent =
                    new Intent(getActivity(),
                            MainActivity.class);

            startActivity(intent);

            requireActivity().finish();
        });

        return view;
    }
}