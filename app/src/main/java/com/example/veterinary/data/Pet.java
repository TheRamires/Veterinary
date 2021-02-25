package com.example.veterinary.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pet {
    @PrimaryKey (autoGenerate = true)
    private int petId;
    private String postname;
    private String name;
    private String age;

    public void setPetId(int id){
        this.petId=id;
    }
    public int getPetId(){
        return petId;
    }
    public void setPostname(String owner){
        this.postname=owner;
    }
    public String getPostname(){
        return postname;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getAge (){
        return age;
    }
}
