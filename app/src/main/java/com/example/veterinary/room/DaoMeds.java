package com.example.veterinary.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.veterinary.data.Meds;
import com.example.veterinary.data.Pet;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface DaoMeds {
    @Query("SELECT * FROM meds where idOfPet=:idOfPet")
    Single<List<Meds>> load(int idOfPet);

    @Insert
    List<Long> save(Meds...meds);
}
