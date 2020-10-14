package com.geekykel.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class USD implements Serializable {

    @JsonProperty("price")
    private String price;

    @JsonProperty("volume_24h")
    private String volume24h;

    @JsonProperty("percent_change_1h")
    private String percentChange1h;

    @JsonProperty("percent_change_24h")
    private String percentChange24h;

    @JsonProperty("percent_change_7d")
    private String percentChange7d;

    @JsonProperty("market_cap")
    private String marketCap;

    @JsonProperty("last_updated")
    private String lastUpdated;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(String volume24h) {
        this.volume24h = volume24h;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "USD{" +
                "price='" + price + '\'' +
                ", volume24h='" + volume24h + '\'' +
                ", percentChange1h='" + percentChange1h + '\'' +
                ", percentChange24h='" + percentChange24h + '\'' +
                ", percentChange7d='" + percentChange7d + '\'' +
                ", marketCap='" + marketCap + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
