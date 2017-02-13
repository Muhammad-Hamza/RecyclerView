package com.example.ero_sol_pc_04.recyclerview;

import android.content.ClipData;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    Toolbar toolbar;
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ItemText> arrayList = new ArrayList<>();


    String[] text = {"One","Two","Three","Four","five","America","Iceland","Pakistan","Italy","Anus","uzair","hello","bangladesh","islamabad","lahore","karachi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
       //recyclerView.setItemAnimator(new DefaultItemAnimator());
        for(int i = 0 ;i<=text.length-1;i++)
        {
            String txt = text[i];

            arrayList.add(new ItemText(txt));

            recyclerAdapter = new RecyclerAdapter(arrayList);
            recyclerView.setAdapter(recyclerAdapter);
        }


        //recyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView =(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
       return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<ItemText> newList = new ArrayList<ItemText>();
        for(ItemText itemText : arrayList)
        {
            String name = itemText.getText().toLowerCase();
            if(name.contains(newText))
            {
                newList.add(itemText);
            }

        }
        recyclerAdapter.setFilter(newList);
        return true;
    }
}
