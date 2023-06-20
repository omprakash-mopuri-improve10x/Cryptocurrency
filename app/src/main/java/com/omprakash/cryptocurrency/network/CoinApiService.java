package com.omprakash.cryptocurrency.network;

import com.omprakash.cryptocurrency.model.CryptoCurrency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinApiService {

    @GET("coins")
    Call<List<CryptoCurrency>> fetchCryptocurrencies();
}
