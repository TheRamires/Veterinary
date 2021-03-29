package com.example.veterinary.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.veterinary.data.Meds;
import com.example.veterinary.data.Pet;

@Database(entities = {Pet.class, Meds.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoPets daoPets();
    public abstract DaoMeds daoMeds();
}
