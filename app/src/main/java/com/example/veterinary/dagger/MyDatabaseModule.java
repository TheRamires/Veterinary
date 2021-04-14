package com.example.veterinary.dagger;

import android.content.Context;

import androidx.room.Room;

import com.example.veterinary.room.AppDatabase;
import com.example.veterinary.room.DaoMeds;
import com.example.veterinary.room.DaoPets;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyDatabaseModule {
    private Context mcontext;

    public MyDatabaseModule(Context context){
        this.mcontext=context;
    }
    @Inject
    @Singleton
    @Provides
    DaoPets provideDaoPets(AppDatabase appDatabase){
        return appDatabase.daoPets();
    }

    @Inject
    @Singleton
    @Provides
    DaoMeds provideDaoMeds(AppDatabase appDatabase){
        return appDatabase.daoMeds();
    }

    @Singleton
    @Provides
    AppDatabase provideAppDatabase(){
        return Room.databaseBuilder(mcontext, AppDatabase.class, "database")
                .fallbackToDestructiveMigration()
                .build();
    }

}
