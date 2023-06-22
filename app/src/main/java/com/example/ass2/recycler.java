package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class recycler extends AppCompatActivity {
    ArrayList<Units> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView recyclerView = findViewById(R.id.m_recycler);
        setUpRe();
        RecyclerAdapter adapter =new RecyclerAdapter(this,views);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setUpRe (){
        String [] fullName = getResources().getStringArray(R.array.FullName);
        String [] units = getResources().getStringArray(R.array.Units);
        for(int i=0;i<fullName.length;i++){
            views.add(new Units(fullName[i],units[i]));
        }
    }
}