package com.example.veterinary.dagger;

import androidx.fragment.app.Fragment;

import com.example.veterinary.MainActivity;
import com.example.veterinary.daily_schedule.MyViewModelMeds;
import com.example.veterinary.profile.FragmentAddingPet;
import com.example.veterinary.profile.MyViewModelPet;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MyModule.class, MyDatabaseModule.class})
public interface MyComponent {
    MyViewModelPet getViewModelPet();
    MyViewModelMeds getViewModelMeds();
}
