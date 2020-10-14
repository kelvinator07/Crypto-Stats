package com.geekykel.data.mappers;

import android.support.annotation.NonNull;

import com.android.volley.toolbox.JsonObjectRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekykel.data.entities.CryptoCoinEntity;
import com.geekykel.data.models.CoinModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public class CryptoMapper extends ObjectMapper {

    private final String CRYPTO_URL_PATH =
            "https://files.coinmarketcap.com/static/img/coins/128x128/%s.png";
    public ArrayList<CryptoCoinEntity> mapJSONToEntity(JSONArray jsonStr) {
        ArrayList<CryptoCoinEntity> data = null;
        try {
            data = readValue(jsonStr.toString(), new TypeReference<ArrayList<CryptoCoinEntity>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    @NonNull
    public List<CoinModel> mapEntityToModel(List<CryptoCoinEntity> data) {
        final ArrayList<CoinModel> listData = new ArrayList<>();
        CryptoCoinEntity entity;
        for (int i = 0; i < data.size(); i++) {
            entity = data.get(i);
            listData.add(new CoinModel(entity.getName(), entity.getSymbol(),
                    String.format(CRYPTO_URL_PATH, entity.getId()),entity.getQuote().getUSD().getPrice(),
                    entity.getQuote().getUSD().getVolume24h(), Double.parseDouble(entity.getQuote().getUSD().getMarketCap())));
        }

        return listData;
    }

    public String mapEntitiesToString(List<CryptoCoinEntity> data) throws JsonProcessingException {
        return writeValueAsString(data);

    }

}
