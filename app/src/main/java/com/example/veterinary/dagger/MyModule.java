package com.example.veterinary.dagger;

import com.example.veterinary.daily_schedule.MyRepositoriyMeds;
import com.example.veterinary.daily_schedule.MyViewModelMeds;
import com.example.veterinary.profile.MyRepositoriyPet;
import com.example.veterinary.profile.MyViewModelPet;
import com.example.veterinary.room.DaoMeds;
import com.example.veterinary.room.DaoPets;

import dagger.Module;
import dagger.Provides;

@Module(includes = MyDatabaseModule.class)
public class MyModule {

    @Provides
    MyViewModelPet provideViewModelPets(MyRepositoriyPet repositoriyPet){
        return new MyViewModelPet(repositoriyPet);
    }

    @Provides
    MyRepositoriyPet provideRepositoriyPet(DaoPets daoPets){
        return new MyRepositoriyPet(daoPets);
    }

    @Provides
    MyViewModelMeds provideViewModelMeds(MyRepositoriyMeds repositoriyMeds){
        return new MyViewModelMeds(repositoriyMeds);
    }

    @Provides
    MyRepositoriyMeds provideRepositoriyMeds(DaoMeds daoMeds){
        return new MyRepositoriyMeds(daoMeds);
    }

}
