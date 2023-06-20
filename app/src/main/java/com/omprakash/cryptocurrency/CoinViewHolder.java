package com.omprakash.cryptocurrency;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.cryptocurrency.databinding.CoinItemBinding;

public class CoinViewHolder extends RecyclerView.ViewHolder {

    CoinItemBinding binding;

    public CoinViewHolder(CoinItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
