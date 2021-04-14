package com.example.veterinary.daily_schedule;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.veterinary.data.Meds;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;

public class MyViewModelMeds extends ViewModel {
    private MyRepositoriyMeds repo;
    public MutableLiveData<List<Meds>> medsLive=new MutableLiveData<>();

    @Inject
    public MyViewModelMeds(MyRepositoriyMeds repo) {
        this.repo=repo;
    }

    public void getData(int idOfPet){
        repo.loadList(idOfPet)
                .subscribe(new DisposableSingleObserver<List<Meds>>() {
                    @Override
                    public void onSuccess(List<Meds> list) {
                        medsLive.setValue(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void saveMeds(int idOfPet, String date, String time, String nameOfMeds, String dosage ){
        Meds meds=new Meds();
        meds.setIdOfPet(idOfPet);
        meds.setDate(date);
        meds.setTime(time);
        meds.setMedication(nameOfMeds);
        meds.setDosage(dosage);

        repo.save(meds, idOfPet)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Meds>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Meds> list) {
                        medsLive.setValue(list);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
