package com.example.ass2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    Context context;
    ArrayList<Units> arr;
    public RecyclerAdapter (Context context,ArrayList<Units> arr){
        this.context=context;
        this.arr=arr;
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rows,parent,false);
        return new RecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.fullName.setText(arr.get(position).getFullName());
        holder.unit.setText(arr.get(position).getUnit());

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullName;
        TextView unit ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName=itemView.findViewById(R.id.textView3);
            unit=itemView.findViewById(R.id.textView4);

        }
    }
}
