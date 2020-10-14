package com.geekykel.data.converters;

import android.arch.persistence.room.TypeConverter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekykel.data.entities.Quote;

public class QuoteConverter extends ObjectMapper {

    @TypeConverter
    public Quote storedStringToQuote(String value) {
        if (value == null || value.isEmpty()) {
            return new Quote();
        }
        try {
            return readValue(value, new TypeReference<Quote>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Quote();
    }

    @TypeConverter
    public String quoteToStoredString(Quote quote) {
        try {
            return writeValueAsString(quote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
