package com.example.veterinary.profile;

import androidx.lifecycle.MutableLiveData;

import com.example.veterinary.data.Pet;
import com.example.veterinary.room.DaoPets;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyRepositoriyPet  {
    public DaoPets daoPets;

    public MyRepositoriyPet(DaoPets daoPets){
        this.daoPets=daoPets;
    }

    public Single<List<Pet>> loadList(){
        return daoPets.load()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Boolean> save(Pet pet){
        return Single.fromCallable(() -> daoPets.save(pet))
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
