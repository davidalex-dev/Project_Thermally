package com.uc.thermally;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class InfoActivity extends AppCompatActivity {
    private Intent intent;
    private CardView cardView_hot, cardView_warm, cardView_cold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        InitView();

        cardView_hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), HotActivity.class);
                startActivity(intent);
            }
        });

        cardView_warm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), WarmActivity.class);
                startActivity(intent);
            }
        });

        cardView_cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), ColdActivity.class);
                startActivity(intent);
            }
        });

    }

    private void InitView(){
        cardView_hot = findViewById(R.id.cardView_hot);
        cardView_warm = findViewById(R.id.cardView_warm);
        cardView_cold = findViewById(R.id.cardView_cold);
    }

}
