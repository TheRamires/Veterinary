package com.example.veterinary.adding_meds;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ViewModelMeds extends AndroidViewModel {
    RepositoriyModelMeds repo=new RepositoriyModelMeds();
    public ViewModelMeds(@NonNull Application application) {
        super(application);
    }
    public long getCurrencyTime(){
        return System.currentTimeMillis();
    }
}
