package com.example.veterinary.profile;

import androidx.lifecycle.MutableLiveData;

import com.example.veterinary.App;
import com.example.veterinary.data.Pet;
import com.example.veterinary.room.AppDatabase;
import com.example.veterinary.room.DaoPets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyRepositoriy {
    private AppDatabase db= App.getInstance().getDatabase();
    public DaoPets daoPets=db.daoPets();

    public void loadList(MutableLiveData<List<Pet>> listLive ){
        daoPets.load()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(petList -> {listLive.setValue(petList);},
                        throwable -> {return;});
    }

    public void save(Pet pet){

        Date date = new Date();
        new Thread(() ->{
                daoPets.save(pet);
        }).start();
    }

    public void listTest(MutableLiveData<List<Pet>> listLive){
        //test
        Pet entity=new Pet();
        entity.setPetId(1);
        entity.setPostname("Michael Pit");
        entity.setName("Tom");
        entity.setAge("3 года");

        List<Pet> list=new ArrayList<>();
        list.add(entity);

        listLive.setValue(list);
    }
}
