package com.omprakash.cryptocurrency;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omprakash.cryptocurrency.databinding.CoinItemBinding;
import com.omprakash.cryptocurrency.model.Coin;

import java.util.List;

public class CoinsAdapter extends RecyclerView.Adapter<CoinViewHolder> {

    private List<Coin> cryptoCurrencies;

    void setCryptoCurrencies(List<Coin> cryptoCurrencies) {
        this.cryptoCurrencies = cryptoCurrencies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CoinItemBinding binding = CoinItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CoinViewHolder coinViewHolder = new CoinViewHolder(binding);
        return coinViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        Coin coin = cryptoCurrencies.get(position);
        holder.binding.setCoin(coin);
    }

    @Override
    public int getItemCount() {
        return cryptoCurrencies.size();
    }
}
