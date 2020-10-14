package com.geekykel.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.geekykel.data.entities.CryptoCoinEntity;

/**
 * Created by Geeky Kelvin on 6/23/2019.
 * Email: Kelvinator4leo@gmail.com
 */
@Database(entities = {CryptoCoinEntity.class}, version = 1)
public abstract class RoomDb extends RoomDatabase {

    static final String DATABASE_NAME = "market_data";
    private static RoomDb INSTANCE;
    public abstract CoinDao coinDao();
    public static RoomDb getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    RoomDb.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }

}
