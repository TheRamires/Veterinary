package com.example.veterinary;

import com.example.veterinary.data.Pet;

import java.util.List;

import io.reactivex.Maybe;

public interface Repositoriy {
    public Maybe<List<Pet>> loadList();
    public <T> Maybe<Boolean> save(T entity);
}
