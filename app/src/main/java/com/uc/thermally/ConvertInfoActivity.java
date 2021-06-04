package com.uc.thermally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ConvertInfoActivity extends AppCompatActivity {
    private Button button_rc, button_rf, button_cr, button_cf, button_fr, button_fc;
    private ImageButton convert_info_back;

    private static final String TAG = "ConvertInfoActivity"; //log.d

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
                Change("RC");
            }
        });

        button_rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change("RF");
            }
        });

        button_cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change("CR");
            }
        });

        button_cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change("CF");
            }
        });

        button_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change("FR");
            }
        });

        button_fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change("FC");
            }
        });

    }

    private void Change(String s){
        String temp = s;
        String temp2 = null;
        ConvertActivity ca = new ConvertActivity();
        ca.convertType = temp;

        if(temp == "RC"){
            temp2 = "Reamur -> Celcius";
        }else if(temp == "RF"){
            temp2 = "Reamur -> Fahrenheit";
        }else if(temp == "CR"){
            temp2 = "Celcius -> Reamur";
        }else if(temp == "CF"){
            temp2 = "Celcius -> Fahrenheit";
        }else if(temp == "FR"){
            temp2 = "Fahrenheit -> Reamur";
        }else if(temp == "FC"){
            temp2 = "Fahrenheit -> Celcius";
        }

        ca.tempConv = temp2;

        Log.d(TAG, "temp is: " + temp);
        Log.d(TAG, "temp2 is: " + temp2);

        Toast.makeText(getApplicationContext(), "Selected conversion: " + temp2, Toast.LENGTH_SHORT).show();

        finish();
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