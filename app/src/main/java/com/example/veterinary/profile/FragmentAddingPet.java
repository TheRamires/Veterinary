package com.example.veterinary.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.veterinary.App;
import com.example.veterinary.databinding.FragmentAddingBinding;

import javax.inject.Inject;

public class FragmentAddingPet extends Fragment {
    MyViewModelPet viewModel;
    private FragmentAddingBinding binding;
    private String postName="";
    private String nameOfPet="";
    private String age="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel=App.getInstance().getComponent().getViewModelPets();
        binding=FragmentAddingBinding.inflate(inflater);
        binding.setFragment(this);
        viewModel.getList();
        View view=binding.getRoot();

        return view;
    }
    public void clickBack(View view){
        Navigation.findNavController(view).popBackStack();
    }
    public void clickSave(View view){
        viewModel.savePet(postName,nameOfPet,age);
        Navigation.findNavController(view).popBackStack();
    }
    public void getPostName(CharSequence s,int start, int count, int after){
        postName=s.toString();
    }
    public void getNamePet(CharSequence s,int start, int count, int after){
        nameOfPet=s.toString();
    }
    public void getAge(CharSequence s,int start, int count, int after){
        age=s.toString();
    }
}