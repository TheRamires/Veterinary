package com.example.veterinary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.veterinary.adding_meds.ViewModelMeds;
import com.example.veterinary.daily_schedule.MyViewModelAdd;
import com.example.veterinary.databinding.ActivityMainBinding;
import com.example.veterinary.profile.MyViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        MyViewModel viewModel=new ViewModelProvider(this).get(MyViewModel.class);
        MyViewModelAdd viewModelAdd=new ViewModelProvider(this).get(MyViewModelAdd.class);
        ViewModelMeds viewModelMeds=new ViewModelProvider(this).get(ViewModelMeds.class);
    }

    @Override
    public boolean dispatchTouchEvent(@NonNull MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                v.clearFocus();
                InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
        return super.dispatchTouchEvent(event);
    }
}