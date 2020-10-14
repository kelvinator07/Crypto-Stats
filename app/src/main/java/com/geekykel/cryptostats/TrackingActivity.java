package com.geekykel.cryptostats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geekykel.cryptostats.tracking.Tracker;

/**
 * Created by Geeky Kelvin on 6/22/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public class TrackingActivity extends AppCompatActivity {

    protected Tracker mTracker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTracker = new Tracker(this);
    }
}
