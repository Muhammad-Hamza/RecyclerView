package com.example.ero_sol_pc_04.recyclerview;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ERO-SOL-PC-04 on 2/13/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
{

    ArrayList<ItemText> arrayList = new ArrayList<>();

    RecyclerAdapter(ArrayList<ItemText> arraylist)
    {
        this.arrayList = arraylist;

    }

    public void setArrayList(ArrayList<ItemText> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ItemText item = arrayList.get(position);
        holder.text.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView text;

        public MyViewHolder(View ItemView)
        {
           super(ItemView);
            text = (TextView) ItemView.findViewById(R.id.header);

        }


    }

    public void setFilter(ArrayList<ItemText> newList)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }

}
