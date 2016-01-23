package com.example.assignmentsectionlist1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SectionAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         recyclerView = (RecyclerView)findViewById(R.id.recycler);
        mAdapter = new SectionAdapter();
        recyclerView.setAdapter(mAdapter);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        initData();
    }

    private void initData(){

        Random r = new Random();
        for (int i =0; i <20; i++){
            int childCount = 2 +r.nextInt(5);
            for( int j = 0 ; j< childCount; j++){
                mAdapter.put("group : " + i , "group : " + i+  ", child : " + j);
            }
        }
    }

}
