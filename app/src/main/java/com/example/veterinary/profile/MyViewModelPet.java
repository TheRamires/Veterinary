package com.example.veterinary.profile;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.veterinary.data.Pet;
import java.util.List;

public class MyViewModelPet extends AndroidViewModel {
    private MyRepositoriyPet repo=new MyRepositoriyPet();
    public MutableLiveData<List<Pet>> listLive=new MutableLiveData<>();

    public MyViewModelPet(@NonNull Application application) {
        super(application);
    }

    public void getList(){
        repo.loadList()
                .subscribe(petList -> {listLive.setValue(petList);},
                throwable -> {return;});
        //repo.listTest(listLive);
    }
    public void savePet(String postName,String nameOfPet, String age){
        Pet pet=new Pet();
        pet.setPostname(postName);
        pet.setName(nameOfPet);
        pet.setAge(age);

        repo.save(pet)
                .subscribe((isSaved)->{
                    if (isSaved){
                        getList(); //refresh
                        Log.d("myLog", "Position is saved: "+pet.getName()+" "+pet.getAge());
                    }
                });
    }
}
