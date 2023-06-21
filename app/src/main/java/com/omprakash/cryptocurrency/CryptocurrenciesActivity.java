package com.omprakash.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.omprakash.cryptocurrency.databinding.ActivityCryptocurrenciesBinding;
import com.omprakash.cryptocurrency.model.Coin;
import com.omprakash.cryptocurrency.network.CoinApi;
import com.omprakash.cryptocurrency.network.CoinApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptocurrenciesActivity extends AppCompatActivity {

    private ArrayList<Coin> cryptoCurrencies = new ArrayList<>();
    private CoinsAdapter coinsAdapter;
    private ActivityCryptocurrenciesBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCryptocurrenciesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getCryptoCurrencies();
        setupAdapter();
        setupRv();
    }

    private void getCryptoCurrencies() {
        CoinApiService coinApiService = new CoinApi().createCoinApiService();
        Call<List<Coin>> call = coinApiService.fetchCoins();
        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                if (response.isSuccessful()) {
                    List<Coin> cryptoCurrencies = response.body();
                    coinsAdapter.setCryptoCurrencies(cryptoCurrencies);
                }
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                Toast.makeText(CryptocurrenciesActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupAdapter() {
        coinsAdapter = new CoinsAdapter();
        coinsAdapter.setCryptoCurrencies(cryptoCurrencies);
    }

    private void setupRv() {
        binding.cryptocurrenciesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cryptocurrenciesRv.setAdapter(coinsAdapter);
    }
}