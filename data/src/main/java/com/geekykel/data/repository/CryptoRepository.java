package com.geekykel.data.repository;

import android.arch.lifecycle.LiveData;

import com.geekykel.data.models.CoinModel;

import java.util.List;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public interface CryptoRepository {

    LiveData<List<CoinModel>> getCryptoCoinsData();
    LiveData<String> getErrorStream();
    LiveData<Double> getTotalMarketCapStream();
    void fetchData();
}
