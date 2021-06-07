package com.uc.thermally;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.uc.thermally.model.History;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView history_recyclerView;
    private HistoryRVAdapter adapter;
    private static final String TAG = "ConvertInfoActivity";
    private ArrayList<History> dataTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        setupRecyclerView();
        //addTemp(); //for debug purposes only
        detect();
    }

    private void detect(){
        if(dataTemp.isEmpty()){
            //text_noData.setVisibility(View.VISIBLE);
            Log.d(TAG, "No data detected");
        }else{
            Log.d(TAG, "Data is detected!");
            //dataHistory.add(newHistory);
            adapter.notifyDataSetChanged();
//              text_noData.setVisibility(View.INVISIBLE);
        }
    }

    private void initView(){
        dataTemp = new ArrayList<History>();
        history_recyclerView = findViewById(R.id.history_recyclerView);
    }

    private void setupRecyclerView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        history_recyclerView.setLayoutManager(manager);
        history_recyclerView.setAdapter(adapter);
    }

    private void addTemp(){
        //adapter.notifyDataSetChanged();
    }

}