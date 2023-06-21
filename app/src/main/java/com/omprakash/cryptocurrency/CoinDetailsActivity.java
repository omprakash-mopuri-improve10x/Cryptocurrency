package com.omprakash.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.omprakash.cryptocurrency.databinding.ActivityCoinDetailsBinding;
import com.omprakash.cryptocurrency.model.CoinDetails;
import com.omprakash.cryptocurrency.network.CoinApi;
import com.omprakash.cryptocurrency.network.CoinApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinDetailsActivity extends AppCompatActivity {

    private ActivityCoinDetailsBinding binding;
    private String coinId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoinDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent().hasExtra(Constants.COIN_ID)) {
            coinId = getIntent().getStringExtra(Constants.COIN_ID);
        }
        getCoinDetails();
    }

    private void getCoinDetails() {
        CoinApiService coinApiService = new CoinApi().createCoinApiService();
        Call<CoinDetails> call = coinApiService.fetchCoinDetails(coinId);
        call.enqueue(new Callback<CoinDetails>() {
            @Override
            public void onResponse(Call<CoinDetails> call, Response<CoinDetails> response) {
                if (response.isSuccessful()) {
                    CoinDetails coinDetails = response.body();
                    binding.setCoinDetails(coinDetails);
                }
            }

            @Override
            public void onFailure(Call<CoinDetails> call, Throwable t) {

            }
        });
    }
}