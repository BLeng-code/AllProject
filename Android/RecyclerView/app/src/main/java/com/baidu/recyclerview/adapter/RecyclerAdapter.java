package com.baidu.recyclerview.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.recyclerview.holder.RecyclerHolder;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
