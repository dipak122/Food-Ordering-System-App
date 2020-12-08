package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingapp.Adapters.MainAdapter;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();

        list.add(new MainModel(R.drawable.fries,"fries","5","This is a good fries"));
        list.add(new MainModel(R.drawable.doan,"doan","15","This is a good doan"));
        list.add(new MainModel(R.drawable.burger,"burger","50","This is a good Burger"));
        list.add(new MainModel(R.drawable.burst,"burst","55","This is a good burst"));
        list.add(new MainModel(R.drawable.fotios,"fotios","85","This is a good fotios"));
        list.add(new MainModel(R.drawable.olsson,"olsson","60","This is a good olsson"));
        list.add(new MainModel(R.drawable.scampa,"scampa","60","This is a good scampa"));
        list.add(new MainModel(R.drawable.walrus,"Walrus","60","This is a good walrus"));
        list.add(new MainModel(R.drawable.shevtsova,"shevtsova","60","This is a good shevtsova"));

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recylerview.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}