package com.geekykel.data.entities;

import android.arch.persistence.room.Embedded;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Quote implements Serializable {

    @JsonProperty("USD")
    @Embedded
    private USD USD;

    public com.geekykel.data.entities.USD getUSD() {
        return USD;
    }

    public void setUSD(com.geekykel.data.entities.USD USD) {
        this.USD = USD;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "USD=" + USD +
                '}';
    }
}
