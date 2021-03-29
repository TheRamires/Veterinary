package com.example.veterinary.daily_schedule;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.veterinary.data.Meds;

import java.util.List;


public class MyViewModelMeds extends ViewModel {
    private MyRepositoriyMeds repo;
    public MutableLiveData<List<Meds>> medsLive=new MutableLiveData<>();

    public MyViewModelMeds(MyRepositoriyMeds repo) {
        this.repo=repo;
    }

    public void getData(int idOfPet){
        repo.loadList(idOfPet)
                .subscribe((meds) -> {
                medsLive.setValue(meds);
        });
    }

    public void saveMeds(int idOfPet,String date,String time,String nameOfMeds,String dosage ){
        Meds meds=new Meds();
        meds.setIdOfPet(idOfPet);
        meds.setDate(date);
        meds.setTime(time);
        meds.setMedication(nameOfMeds);
        meds.setDosage(dosage);

        repo.save(meds)
                .subscribe((isSaved)->{
                    if (isSaved){
                        getData(idOfPet); //refresh
                    }
                });
    }
}
