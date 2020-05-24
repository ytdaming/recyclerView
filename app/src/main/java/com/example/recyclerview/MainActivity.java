package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Fruitadapter fruitadapter=new Fruitadapter(fruitList);
        recyclerView.setAdapter(fruitadapter);
    }
    private void initFruit(){
        for (int i=0;i<10;i++){
            Fruit apple=new Fruit("Apple",R.drawable.computer);
            fruitList.add(apple);
            Fruit banana=new Fruit("Banana",R.drawable.brightness);
            fruitList.add(banana);
        }
    }
}
