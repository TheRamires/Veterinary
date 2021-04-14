package com.example.veterinary;

import android.app.Application;

import com.example.veterinary.dagger.DaggerMyComponent;
import com.example.veterinary.dagger.MyComponent;
import com.example.veterinary.dagger.MyDatabaseModule;


public class App extends Application {
    public static App instance;
    private MyComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        myComponent= DaggerMyComponent.builder()
                .myDatabaseModule(new MyDatabaseModule(getApplicationContext()))
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public MyComponent getComponent(){
        return myComponent;
    }

}
