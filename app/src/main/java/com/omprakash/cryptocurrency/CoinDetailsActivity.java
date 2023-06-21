package com.omprakash.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.omprakash.cryptocurrency.databinding.ActivityCoinDetailsBinding;
import com.omprakash.cryptocurrency.model.CoinDetails;
import com.omprakash.cryptocurrency.model.Tag;
import com.omprakash.cryptocurrency.network.CoinApi;
import com.omprakash.cryptocurrency.network.CoinApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinDetailsActivity extends AppCompatActivity {

    private ActivityCoinDetailsBinding binding;
    private String coinId;
    private TagsAdapter tagsAdapter;
    private ArrayList<Tag> tags = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoinDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getIntent().hasExtra(Constants.COIN_ID)) {
            coinId = getIntent().getStringExtra(Constants.COIN_ID);
        }
        getCoinDetails();
        setupTagsAdapter();
        setupTagsRv();
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
                    tagsAdapter.setTags(coinDetails.getTags());
                }
            }

            @Override
            public void onFailure(Call<CoinDetails> call, Throwable t) {
                Toast.makeText(CoinDetailsActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupTagsAdapter() {
        tagsAdapter = new TagsAdapter();
        tagsAdapter.setTags(tags);
    }

    private void setupTagsRv() {
        binding.tagsRv.setLayoutManager(new GridLayoutManager(this, 3));
        binding.tagsRv.setAdapter(tagsAdapter);
    }
}