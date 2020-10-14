package com.geekykel.cryptostats.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.geekykel.data.models.CoinModel;
import com.geekykel.data.repository.CryptoRepository;
import com.geekykel.data.repository.CryptoRepositoryImpl;

import java.util.List;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public class CryptoViewModel extends AndroidViewModel {

    private static final String TAG = CryptoViewModel.class.getSimpleName();
    private CryptoRepository mCryptoRepository;

    public LiveData<List<CoinModel>> getCoinsMarketData() {
        return mCryptoRepository.getCryptoCoinsData();
    }

    public LiveData<String> getErrorUpdates() {
        return mCryptoRepository.getErrorStream();
    }

    public CryptoViewModel(@NonNull Application application) {
        super(application);
        mCryptoRepository = CryptoRepositoryImpl.create(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void fetchData() {
        mCryptoRepository.fetchData();
    }

    public LiveData<Double> getTotalMarketCap() {
        return mCryptoRepository.getTotalMarketCapStream();
    }

    @VisibleForTesting
    public CryptoViewModel(@NonNull Application application, CryptoRepositoryImpl repo) {
        super(application);
        this.mCryptoRepository = repo;
    }

}
