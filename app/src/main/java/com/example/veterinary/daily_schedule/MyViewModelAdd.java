package com.example.veterinary.daily_schedule;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.veterinary.data.Meds;

import java.util.List;

public class MyViewModelAdd extends AndroidViewModel {
    MutableLiveData<List<Meds>> medsLive=new MutableLiveData<>();
    MyRepositoriyAdd repo=new MyRepositoriyAdd();
    public MyViewModelAdd(@NonNull Application application) {
        super(application);
    }

    public void getData(int idOfPet){
        repo.loadList(idOfPet,medsLive);
    }
    public void saveMeds(int idOfPet,String date,String time,String nameOfMeds,String dosage ){
        Meds meds=new Meds();
        meds.setIdOfPet(idOfPet);
        meds.setDate(date);
        meds.setTime(time);
        meds.setMedication(nameOfMeds);
        meds.setDosage(dosage);
        repo.save(meds);
    }
}
