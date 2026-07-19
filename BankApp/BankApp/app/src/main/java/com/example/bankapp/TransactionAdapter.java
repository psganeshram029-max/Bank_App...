package com.example.bankapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter
        extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    List<TransactionModel> list;

    public TransactionAdapter(List<TransactionModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(
                        parent.getContext())
                .inflate(
                        R.layout.item_transaction,
                        parent,
                        false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        TransactionModel model =
                list.get(position);

        holder.tvTitle.setText(
                model.getTitle());

        holder.tvDate.setText(
                model.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle =
                    itemView.findViewById(R.id.tvTitle);

            tvDate =
                    itemView.findViewById(R.id.tvDate);
        }
    }
}