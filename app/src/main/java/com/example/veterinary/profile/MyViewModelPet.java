package com.example.veterinary.profile;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.veterinary.data.Pet;
import java.util.List;

public class MyViewModelPet extends ViewModel {
    private MyRepositoriyPet repo;
    public MutableLiveData<List<Pet>> listLive=new MutableLiveData<>();

    public MyViewModelPet(MyRepositoriyPet repo) {
        this.repo=repo;
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
