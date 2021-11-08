package com.heao.dialogdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> mData = new ArrayList<>();

    public MyAdapter() {
        mData.add("item 0");
        mData.add("item 1");
        mData.add("item 2");
        mData.add("item 3");
        mData.add("item 4");
        mData.add("item 5");
        mData.add("item 6");
        mData.add("item 7");
        mData.add("item 8");
        mData.add("item 9");
        mData.add("item 10");
        mData.add("item 11");
        mData.add("item 12");
        mData.add("item 13");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 确定要新建哪个View
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 对应位置的View绑定对应的数据
        holder.mItemTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mItemTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemTv = itemView.findViewById(R.id.item_text);
        }
    }

    public void setData(List<String> data) {
//        mData.clear();
//        mData.addAll(data);
    }
}
