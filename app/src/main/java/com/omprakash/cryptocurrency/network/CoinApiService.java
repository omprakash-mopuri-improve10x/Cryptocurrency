package com.omprakash.cryptocurrency.network;

import com.omprakash.cryptocurrency.model.Coin;
import com.omprakash.cryptocurrency.model.CoinDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoinApiService {

    @GET("coins")
    Call<List<Coin>> fetchCryptocurrencies();

    @GET("coins/@{id}")
    Call<CoinDetails> fetchCoinDetails(@Path("id") String id);
}
