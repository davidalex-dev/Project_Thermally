package com.uc.thermally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ConvertInfoActivity extends AppCompatActivity {
    private Button button_rc, button_rf, button_cr, button_cf, button_fr, button_fc;
    private ImageButton convert_info_back;
    private String temp, temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_info);
        InitView();

        convert_info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("temp","RC");
                setResult(200, intent);
                finish();
                //set convert type rc
                //float rc
                //finish();
            }
        });

        button_rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set convert type rf
                //float rf
                //finish();
            }
        });

        button_cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set convert type cr
                //float cr
                //finish();
            }
        });

        button_cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set convert type cf
                //float cf
                //finish();
            }
        });

        button_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set convert type fr
                //float fr
                //finish();
            }
        });

        button_fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set convert type fc
                //float fc
                //finish();
            }
        });

    }

    private void InitView(){
        button_rc = findViewById(R.id.button_rc);
        button_rf = findViewById(R.id.button_rf);
        button_cr = findViewById(R.id.button_cr);
        button_cf = findViewById(R.id.button_cf);
        button_fr = findViewById(R.id.button_fr);
        button_fc = findViewById(R.id.button_fc);
        convert_info_back = findViewById(R.id.convert_info_back);
    }
}