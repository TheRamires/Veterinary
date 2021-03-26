package com.example.veterinary.profile;

import android.os.Bundle;

import androidx.appcompat.widget.ActionMenuView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.veterinary.R;
import com.example.veterinary.data.Pet;
import com.example.veterinary.databinding.FragmentProfileBinding;

import java.util.List;

public class FragmentProfile extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentProfileBinding binding=FragmentProfileBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        MyViewModel viewModel=new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        viewModel.getList();

        ActionMenuView actionMenuView = binding.actionMenu;
        Menu bottomMenu = actionMenuView.getMenu();
        requireActivity().getMenuInflater().inflate(R.menu.toolbar_menu, bottomMenu);
        for (int i = 0; i < bottomMenu.size(); i++) {
            bottomMenu.getItem(i).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.item){
                        clickAdd(view);
                    }
                    return onOptionsItemSelected(item);
                }
            });
        }

        RecyclerView recyclerView=binding.recycler;

        viewModel.listLive.observe(getViewLifecycleOwner(), new Observer<List<Pet>>() {
            @Override
            public void onChanged(List<Pet> entities) {
                RecyclerView.Adapter adapter=new RecyclerViewAdapter(entities);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }
    public void clickAdd(View view){
        Navigation.findNavController(view).navigate(R.id.fragmentAdding);
    }
}