package com.uc.thermally;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.uc.thermally.model.History;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView history_recyclerView;
    private static final String TAG = "HistoryActivity";
    public static ArrayList<History> listTemp = new ArrayList<>();
    private HistoryRVAdapter adapter = new HistoryRVAdapter(listTemp);
    private TextView history_noData;
    private Toolbar history_Toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "super on create saved instance state");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "setContentView activity history");
        setContentView(R.layout.activity_history);
        Log.d(TAG, "entering initview");
        initView();
        Log.d(TAG, "entering setuprecyclerview");
        setupRecyclerView();

        //addTemp(); //for debug purposes only

        Log.d(TAG, "listTemp size is: " + listTemp.size());
        if(listTemp.size() < 1){
            Log.d(TAG, "no data set visible");
            history_noData.setVisibility(View.VISIBLE);
        }else{
            Log.d(TAG, "nodata ser invinsible");
            history_noData.setVisibility(View.INVISIBLE);
            adapter.notifyDataSetChanged();
            Log.d(TAG, "adapter notifydatasetchanged");
        }

        history_Toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "clicked on back button");
                finish();
            }
        });

    }

    private void initView(){
        ConvertActivity ca = new ConvertActivity();
        Log.d(TAG, "convert ca new converactvitiy");
        listTemp = ca.getList();
        Log.d(TAG, "get list");
        history_recyclerView = findViewById(R.id.history_recyclerView);
        Log.d(TAG, "find view by id recyclerview");
        history_noData = findViewById(R.id.history_noData);
        Log.d(TAG, "findviewbyid nodata");
        history_Toolbar = findViewById(R.id.history_Toolbar);
        Log.d(TAG, "findviewbyid toolbar");
    }

    private void setupRecyclerView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        history_recyclerView.setLayoutManager(manager);
        history_recyclerView.setAdapter(adapter);
    }

    private void addTemp(){
        listTemp.add(new History(69.4, "C", "Hot"));
        listTemp.add(new History(42.0, "C", "Hot"));
        adapter.notifyDataSetChanged();
    }


}