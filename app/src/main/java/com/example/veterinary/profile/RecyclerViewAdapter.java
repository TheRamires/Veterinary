package com.example.veterinary.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.veterinary.R;
import com.example.veterinary.data.Pet;
import com.example.veterinary.databinding.ItemViewBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemList> {
    private List<Pet> list;

    public RecyclerViewAdapter(List<Pet> list){
        this.list=list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ItemList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemViewBinding binding=ItemViewBinding.inflate(inflater,parent,false);
        return new ItemList(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ItemList holder, int position) {
        holder.binding.setEntity(list.get(position));
        Bundle bundle=new Bundle();
        bundle.putInt("idOfPet",list.get(position).getPetId());
        bundle.putString("name", list.get(position).getName());

        holder.itemView.setOnClickListener((View v)-> {
            Navigation.findNavController(v).navigate(R.id.fragmentDailySchedule, bundle);
        });
        holder.binding.imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragmentDailySchedule, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemList extends RecyclerView.ViewHolder {
        ItemViewBinding binding;

        public ItemList(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}