package com.example.veterinary.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.veterinary.data.Pet;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface DaoPets {
    @Query("SELECT * FROM Pet")
    Maybe<List<Pet>> load();

    @Insert
    void save(Pet...pets);
}
