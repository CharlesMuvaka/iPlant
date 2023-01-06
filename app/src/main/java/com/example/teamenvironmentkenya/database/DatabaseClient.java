package com.example.teamenvironmentkenya.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.teamenvironmentkenya.dao.*;
import com.example.teamenvironmentkenya.models.*;

@Database(entities = {Tree.class, User.class, Vendor.class},version = 4)
public abstract class DatabaseClient extends RoomDatabase {
    public abstract TreeDao TreeDao();
    public abstract UserDao UserDao();
    public abstract VendorDao VendorDao();

    public static DatabaseClient instance;

    public static DatabaseClient getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), DatabaseClient.class, "tek_database")
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }

        return instance;
    }

}
