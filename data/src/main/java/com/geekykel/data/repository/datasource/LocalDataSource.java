package com.geekykel.data.repository.datasource;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.geekykel.data.db.RoomDb;
import com.geekykel.data.entities.CryptoCoinEntity;

import java.util.List;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public class LocalDataSource implements DataSource<List<CryptoCoinEntity>> {

    private final RoomDb mDb;
    private final MutableLiveData<String> mError = new MutableLiveData<>();

    public LocalDataSource(Context mAppContext) {
        mDb = RoomDb.getDatabase(mAppContext);
    }

    @Override
    public LiveData<List<CryptoCoinEntity>> getDataStream() {
        return mDb.coinDao().getAllCoinsLive();
    }

    @Override
    public LiveData<String> getErrorStream() {
        return mError;
    }

    public void writeData(List<CryptoCoinEntity> coins) {
        try {
            mDb.coinDao().insertCoins(coins);
        } catch (Exception e) {
            e.printStackTrace();
            mError.postValue(e.getMessage());
        }
    }

    public List<CryptoCoinEntity> getALlCoins() {
        return mDb.coinDao().getAllCoins();
    }

    @VisibleForTesting
    public void deleteAllCoins() {
        mDb.coinDao().deleteAllCoins();
    }
}
