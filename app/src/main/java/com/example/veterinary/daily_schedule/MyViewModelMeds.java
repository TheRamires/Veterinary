package com.example.veterinary.daily_schedule;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.veterinary.data.Meds;

import java.util.List;

import io.reactivex.functions.Consumer;

public class MyViewModelMeds extends AndroidViewModel {
    MutableLiveData<List<Meds>> medsLive=new MutableLiveData<>();
    MyRepositoriyMeds repo=new MyRepositoriyMeds();
    public MyViewModelMeds(@NonNull Application application) {
        super(application);
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
