package com.example.veterinary.daily_schedule;

import androidx.lifecycle.MutableLiveData;

import com.example.veterinary.data.Meds;
import com.example.veterinary.room.DaoMeds;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyRepositoriyMeds {
    public DaoMeds daoMeds;

    @Inject
    public MyRepositoriyMeds(DaoMeds daoMeds){
        this.daoMeds=daoMeds;
    }

    public Single<List<Meds>> loadList(int petId){
        return daoMeds.load(petId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<Meds>> save(Meds meds, int idOfPet){
        return Observable.fromCallable(()->daoMeds.save(meds))
                .subscribeOn(Schedulers.io())
                .flatMap((isSaved -> {
                    return daoMeds.load(idOfPet).toObservable();
                }));

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
