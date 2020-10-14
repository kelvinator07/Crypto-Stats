package com.geekykel.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Geeky Kelvin on 6/22/2019.
 * Email: Kelvinator4leo@gmail.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(tableName = "coins",
        indices = {@Index("symbol"),
                @Index("total_supply"),
                @Index({"id","symbol"})})
public class CryptoCoinEntity {
    //We are going to get a list of these entities from our api call - this entity is immutable
    @JsonProperty("id")
    @ColumnInfo(name = "id")
    private String id;

    @JsonProperty("name")
    @ColumnInfo(name="n")
    private String name;

    @JsonProperty("symbol")
    @ColumnInfo(name = "symbol")
    @PrimaryKey
    @NonNull
    private String symbol;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("max_supply")
    private String maxSupply;

    @JsonProperty("total_supply")
    @ColumnInfo(name = "total_supply")
    private String totalSupply;

    @JsonProperty("cmc_rank")
    private String rank;

    @JsonProperty("quote")
    @Embedded
    private Quote quote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(@NonNull String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "CryptoCoinEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", slug='" + slug + '\'' +
                ", maxSupply='" + maxSupply + '\'' +
                ", totalSupply='" + totalSupply + '\'' +
                ", rank='" + rank + '\'' +
                ", quote=" + quote +
                '}';
    }
}
