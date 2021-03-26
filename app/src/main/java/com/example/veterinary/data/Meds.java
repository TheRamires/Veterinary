package com.example.veterinary.data;

import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity
public class Meds {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private int idOfPet;
    private String medication;
    private String dosage;
    private String date;
    private String time;

    public void setId(int id){this.id=id;}
    public int getId (){return id;}
    public void setIdOfPet(int id){
        this.idOfPet=id;
    }
    public int getIdOfPet(){
        return idOfPet;
    }
    public void setMedication(String medication){
        this.medication=medication;
    }
    public String getMedication(){
        return medication;
    }
    public void setDosage(String dosage){
        this.dosage=dosage;
    }
    public String getDosage(){
        return dosage;
    }
    public void setDate (String date){
        this.date=date;
    }
    public String getDate (){
        return date;
    }
    public void setTime(String time){
        this.time=time;
    }
    public String getTime(){
        return time;
    }
}
