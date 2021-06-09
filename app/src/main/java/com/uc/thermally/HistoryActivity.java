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
    private static final String TAG = "ConvertInfoActivity";
    private ArrayList<History> listTemp = new ArrayList<History>();
    private ArrayList<History> listHistory = new ArrayList<History>();
    private HistoryRVAdapter adapter = new HistoryRVAdapter(listHistory);
    private TextView history_noData;
    private Toolbar history_Toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        setupRecyclerView();
        //addTemp(); //for debug purposes only

        ConvertActivity ca = new ConvertActivity();
        listTemp = ca.getList();
        Log.d(TAG, "Listtemp size: " + String.valueOf(listTemp.size()));

        if(listTemp.size()>0){
            history_noData.setVisibility(View.INVISIBLE);
            for(int i=0; i < listTemp.size(); i++){
                listHistory.add(new History(listTemp.get(i).getTemp(), listTemp.get(i).getType(), listTemp.get(i).getCondition()));
            }
            adapter.notifyDataSetChanged();
        }else{
            history_noData.setVisibility(View.VISIBLE);
        }

        history_Toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView(){
        history_noData = findViewById(R.id.history_noData);
        history_Toolbar = findViewById(R.id.history_Toolbar);
        history_recyclerView = findViewById(R.id.history_recyclerView);
    }

    private void setupRecyclerView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        history_recyclerView.setLayoutManager(manager);
        history_recyclerView.setAdapter(adapter);
    }

    private void addTemp(){
        listHistory.add(new History(20.0, "a", "b"));
        adapter.notifyDataSetChanged();
    }

}