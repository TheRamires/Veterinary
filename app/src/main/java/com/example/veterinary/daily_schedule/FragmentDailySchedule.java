package com.example.veterinary.daily_schedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.veterinary.R;
import com.example.veterinary.data.Meds;
import com.example.veterinary.data.Pet;
import com.example.veterinary.databinding.FragmentDailyScheduleBinding;

import java.util.List;

public class FragmentDailySchedule extends Fragment {
    private Pet pet;
    private FragmentDailyScheduleBinding binding;
    private int idOfPet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentDailyScheduleBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        RecyclerView recyclerView=binding.recycler;
        MyViewModelAdd viewModelAdd=new ViewModelProvider(this).get(MyViewModelAdd.class);
        idOfPet=getArguments().getInt("idOfPet");

        Log.d("myLog","Pet`s id = "+idOfPet);
        String name=getArguments().getString("name");
        binding.name.setText(name);

        viewModelAdd.getData(idOfPet);

        viewModelAdd.medsLive.observe(getViewLifecycleOwner(), new Observer<List<Meds>>() {
            @Override
            public void onChanged(List<Meds> meds) {
                RecyclerView.Adapter adapter=new RecyclerViewAdapterMeds(meds);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }
    public void clickAdd(View view){
        Bundle petId=new Bundle();
        petId.putInt("idOfPet",idOfPet );
        Navigation.findNavController(view).navigate(R.id.fragmentAddingMeds,petId);
    }
    public void clickBack(View view){
        Navigation.findNavController(view).popBackStack();
    }
}