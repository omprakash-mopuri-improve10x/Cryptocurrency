package com.omprakash.cryptocurrency;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.omprakash.cryptocurrency.model.Coin;
import com.omprakash.cryptocurrency.model.CoinDetails;
import com.omprakash.cryptocurrency.network.CoinApi;
import com.omprakash.cryptocurrency.network.CoinApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCoins() throws IOException {
        CoinApiService coinApiService = new CoinApi().createCoinApiService();
        Call<List<Coin>> call = coinApiService.fetchCoins();
        List<Coin> coins = call.execute().body();
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
        System.out.println(new Gson().toJson(coins));
    }

    @Test
    public void getCoinDetails() throws IOException {
        CoinApiService coinApiService = new CoinApi().createCoinApiService();
        Call<CoinDetails> call = coinApiService.fetchCoinDetails("busd-binance-usd");
        CoinDetails coinDetails = call.execute().body();
        assertNotNull(coinDetails);
        System.out.println(new Gson().toJson(coinDetails));
    }
}