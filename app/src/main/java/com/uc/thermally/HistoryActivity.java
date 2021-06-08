package com.uc.thermally;

import androidx.appcompat.app.AppCompatActivity;
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
    private static final String TAG = "ConvertInfoActivity";
    public static ArrayList<History> listTemp = new ArrayList<>();
    private HistoryRVAdapter adapter = new HistoryRVAdapter(listTemp);
    private TextView history_noData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        setupRecyclerView();
        //addTemp(); //for debug purposes only

        if(listTemp.size() < 1){
            history_noData.setVisibility(View.VISIBLE);
        }else{
            history_noData.setVisibility(View.INVISIBLE);
        }

    }

    private void initView(){
        ConvertActivity ca = new ConvertActivity();
        listTemp = ca.getList();
        history_recyclerView = findViewById(R.id.history_recyclerView);
        history_noData = findViewById(R.id.history_noData);
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