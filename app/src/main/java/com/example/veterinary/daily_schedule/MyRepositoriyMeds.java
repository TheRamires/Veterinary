package com.example.veterinary.daily_schedule;

import androidx.lifecycle.MutableLiveData;

import com.example.veterinary.App;
import com.example.veterinary.data.Meds;
import com.example.veterinary.data.Pet;
import com.example.veterinary.room.AppDatabase;
import com.example.veterinary.room.DaoMeds;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyRepositoriyMeds {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoMeds daoMeds=db.daoMeds();

    public Maybe<List<Meds>> loadList(int petId){
        return daoMeds.load(petId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Maybe<Boolean> save(Meds meds){
        return Maybe.fromCallable(() -> daoMeds.save(meds))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map((longs)->{
                    if(longs.size()>=0){
                        return true;
                    } else {
                        return false;
                    }
                });
    }

    public void listTest(MutableLiveData<List<Meds>> medsLive){
        //test
        Meds meds=new Meds();
        meds.setId(1);
        meds.setMedication("Парацетамол");
        meds.setDosage("2 oz");

        Meds meds2=new Meds();
        meds2.setId(1);
        meds2.setMedication("Парацетамол");
        meds2.setDosage("2 oz");

        Meds meds3=new Meds();
        meds3.setId(1);
        meds3.setMedication("Парацетамол");
        meds3.setDosage("2 oz");

        List<Meds> list=new ArrayList<>();
        list.add(meds);
        list.add(meds2);
        list.add(meds3);

        medsLive.setValue(list);
    }
}
