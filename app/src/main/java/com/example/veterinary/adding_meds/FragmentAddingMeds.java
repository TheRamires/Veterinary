package com.example.veterinary.adding_meds;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.veterinary.App;
import com.example.veterinary.daily_schedule.MyViewModelMeds;
import com.example.veterinary.databinding.FragmentAddingMedsBinding;

public class FragmentAddingMeds extends Fragment {
    private FragmentAddingMedsBinding binding;
    private int idOfPet;
    private String date;
    private String time;
    private String nameOfMeds;
    private String dosage;
    private MyViewModelMeds viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel=App.getInstance().getComponent().getViewModelMeds();
        binding = FragmentAddingMedsBinding.inflate(inflater);
        binding.setFragment(this);
        idOfPet=getArguments().getInt("idOfPet");
        View view = binding.getRoot();

        return view;
    }

    public void clickDate(View view){
        DialogFragment dialogfragment = new DatePickerDialogTheme();
        dialogfragment.show(requireActivity().getSupportFragmentManager(), "theme");
    }

    public void clickTime(View view){
        DialogFragment dialogfragment = new TimePickerDialogTheme();
        dialogfragment.show(requireActivity().getSupportFragmentManager(), "theme2");
    }

    public void clickBack(View view){
        Navigation.findNavController(view).popBackStack();
    }

    public void clickSave(View view){
        date=binding.date.getText().toString();
        time=binding.time.getText().toString();
        viewModel.saveMeds(idOfPet,date,time,nameOfMeds,dosage);
        Navigation.findNavController(view).popBackStack();
    }

    public void getNameOfMeds(CharSequence s,int start, int count, int after){
        nameOfMeds=s.toString();
    }

    public void getDosage(CharSequence s,int start, int count, int after){
        dosage=s.toString();
    }
}