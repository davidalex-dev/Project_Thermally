package com.uc.thermally;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.uc.thermally.model.History;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView history_recyclerView;
    private static final String TAG = "ConvertInfoActivity";
    public static ArrayList<History> listTemp = new ArrayList<>();
    private HistoryRVAdapter adapter = new HistoryRVAdapter(listTemp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ConvertActivity ca = new ConvertActivity();
        listTemp = ca.getList();

        initView();
        setupRecyclerView();
        //addTemp(); //for debug purposes only



        Log.d(TAG, "listTemp size is (from HistoryActivity): " + String.valueOf(listTemp.size()));
    }

    private void initView(){
        history_recyclerView = findViewById(R.id.history_recyclerView);
    }

    private void setupRecyclerView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        history_recyclerView.setLayoutManager(manager);
        history_recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void addTemp(){
        listTemp.add(new History(69.4, "C", "Hot"));
        listTemp.add(new History(42.0, "C", "Hot"));
        adapter.notifyDataSetChanged();
    }


}