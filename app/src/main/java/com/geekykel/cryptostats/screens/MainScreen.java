package com.geekykel.cryptostats.screens;

import com.geekykel.data.models.CoinModel;

import java.util.List;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public interface MainScreen {

    void updateData(List<CoinModel> data);
    void setError(String message);
}
