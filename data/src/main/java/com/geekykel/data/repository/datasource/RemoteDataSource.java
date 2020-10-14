package com.geekykel.data.repository.datasource;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.geekykel.data.entities.CryptoCoinEntity;
import com.geekykel.data.mappers.CryptoMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public class RemoteDataSource implements DataSource<List<CryptoCoinEntity>> {

    private static final String TAG = RemoteDataSource.class.getSimpleName();
    public final String ENDPOINT_FETCH_CRYPTO_DATA = "https://api.coinmarketcap.com/v1/ticker/?limit=100";
    public final String ENDPOINT_FETCH_CRYPTO_DATA_NEW = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?start=1&limit=10";
    public final String API_KEY = "d6eb303d-81c9-4421-829d-e2263247b56f";
    private final RequestQueue mQueue;
    private final CryptoMapper mObjMapper;
    private final MutableLiveData<String> mError=new MutableLiveData<>();
    private final MutableLiveData<List<CryptoCoinEntity>> mDataApi=new MutableLiveData<>();

    public RemoteDataSource(Context appContext, CryptoMapper objMapper) {
        mQueue = Volley.newRequestQueue(appContext);
        mObjMapper=objMapper;
    }

    @Override
    public LiveData<List<CryptoCoinEntity>> getDataStream() {
        return mDataApi;
    }

    @Override
    public LiveData<String> getErrorStream() {
        return mError;
    }

//    public void fetchOld() {
//        VolleyLog.DEBUG = true;
//        final JsonObjectRequest jsonObjReq =
//                new JsonObjectRequest(ENDPOINT_FETCH_CRYPTO_DATA_NEW,
//                        response -> {
//                            Log.d(TAG, "Thread->" +
//                                    Thread.currentThread().getName()+"\tGot some network response");
//                            final ArrayList<CryptoCoinEntity> data = mObjMapper.mapJSONToEntity(null);
//                            Log.d(TAG, "KELVIN " +  data.toString());
//                            mDataApi.setValue(data);
//                        },
//                        error -> {
//                            Log.d(TAG, "Thread->" +
//                                    Thread.currentThread().getName()+"\tGot network error");
//                            //mError.setValue(error.toString());
//                            Log.d(TAG, "KELVIN " + error.toString());
//                        }) {
//                    //this is the part, that adds the header to the request
//                    @Override
//                    public Map<String, String> getHeaders() {
//                        Map<String, String> params = new HashMap<String, String>();
//                        params.put("X-CMC_PRO_API_KEY", API_KEY);
//                        return params;
//                    }
//                };
//        mQueue.add(jsonObjReq);
//    }

    public void fetch() {
        VolleyLog.DEBUG = true;
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, ENDPOINT_FETCH_CRYPTO_DATA_NEW, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "Thread->" + Thread.currentThread().getName()+"\tGot some network response");
                try {
                    JSONArray array = response.getJSONArray("data");
                    final ArrayList<CryptoCoinEntity> data = mObjMapper.mapJSONToEntity(array);
                    Log.d(TAG, "KELVIN SUCC" +  data.toString());
                    mDataApi.setValue(data);
                } catch (JSONException e)  {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                // Do something when error occurred
                Log.d(TAG, "Thread->" + Thread.currentThread().getName()+"\tGot network error");
                mError.setValue(error.toString());
                Log.d(TAG, "KELVIN ERR" + error.toString());
            }
        }) {
            //this is the part, that adds the header to the request
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-CMC_PRO_API_KEY", API_KEY);
                return params;
            }
        };
        mQueue.add(jsonObjReq);
    }
}
