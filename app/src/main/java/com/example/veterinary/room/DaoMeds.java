package com.example.veterinary.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.veterinary.data.Meds;
import com.example.veterinary.data.Pet;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface DaoMeds {
    @Query("SELECT * FROM meds where idOfPet=:idOfPet")
    Maybe<List<Meds>> load(int idOfPet);

    @Insert
    void save(Meds...meds);
}
