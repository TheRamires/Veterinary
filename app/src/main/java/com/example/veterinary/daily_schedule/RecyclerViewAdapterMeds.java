package com.example.veterinary.daily_schedule;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.veterinary.data.Meds;
import com.example.veterinary.databinding.ItemViewMedsBinding;

import java.util.List;

public class RecyclerViewAdapterMeds extends RecyclerView.Adapter<RecyclerViewAdapterMeds.ItemList> {
    private List<Meds> list;

    public RecyclerViewAdapterMeds(List<Meds> list){
        this.list=list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterMeds.ItemList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemViewMedsBinding binding=ItemViewMedsBinding.inflate(inflater,parent,false);
        return new RecyclerViewAdapterMeds.ItemList(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterMeds.ItemList holder, int position) {
        holder.binding.setEntity(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemList extends RecyclerView.ViewHolder {
        ItemViewMedsBinding binding;

        public ItemList(@NonNull View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }
    }
}