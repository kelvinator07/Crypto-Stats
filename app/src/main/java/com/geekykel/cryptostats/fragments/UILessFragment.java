package com.geekykel.cryptostats.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.geekykel.cryptostats.viewmodel.CryptoViewModel;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public class UILessFragment extends Fragment {
    private static final String TAG = UILessFragment.class.getSimpleName();
    private CryptoViewModel mViewModel;
    private final Observer<Double> mObserver = totalMarketCap ->
            Log.d(TAG, "onChanged() called with: aDouble = [" + totalMarketCap + "]");

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(CryptoViewModel.class);

        //mViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CryptoViewModel.class);

        mViewModel.getTotalMarketCap().observe(this, mObserver);

    }
}