package com.example.veterinary.profile;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.veterinary.data.Pet;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private MyRepositoriy repo=new MyRepositoriy();
    public MutableLiveData<List<Pet>> listLive=new MutableLiveData<>();

    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    public void getList(){
        repo.loadList(listLive);
        //repo.listTest(listLive);
    }
    public void savePet(String postName,String nameOfPet, String age){
        Pet pet=new Pet();
        pet.setPostname(postName);
        pet.setName(nameOfPet);
        pet.setAge(age);
        Log.d("myLog", pet.getName()+" "+pet.getAge());
        repo.save(pet);
    }
}
