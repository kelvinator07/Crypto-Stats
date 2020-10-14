package com.geekykel.data.repository.datasource;

import android.arch.lifecycle.LiveData;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public interface DataSource<T> {
    LiveData<T> getDataStream();
    LiveData<String> getErrorStream();
}
