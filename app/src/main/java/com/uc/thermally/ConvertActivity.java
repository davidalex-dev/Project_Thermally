package com.uc.thermally;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatActivity;

public class ConvertActivity extends AppCompatActivity {

    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8,
    button_9, button_0, button_clear, button_dot, button_convert_from,
    button_convert_to, info_button, button_history;
    private EditText text_Calc;
    private String input = "";
    private String convertType = "";
    private Intent intent;
    private Boolean converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        InitView();

        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(1);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(2);
            }
        });

        button_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(3);
            }
        });

        button_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(4);
            }
        });

        button_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(5);
            }
        });

        button_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(6);
            }
        });

        button_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(7);
            }
        });

        button_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(8);
            }
        });

        button_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(9);
            }
        });

        button_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = addNumber(0);
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = "";
                convertType = "";
                text_Calc.setText("");
                converted = false;
            }
        });

        button_convert_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if teks blm diisi
                //muncul float error "temperature not yet input"
                //else if teks dan convert from blm diset
                //muncul float error "temperature and convert not yet set"
                //else if convert from blm diset
                //muncul float error "convert not yet set"
                //else
                //conversi
                //converted = true;
                //put in history
                //teks show hot, warm, or cold
            }
        });

        button_convert_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), ConvertInfoActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add "."
            }
        });

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if converted !=true
                //muncul float error "temperature not yet converted!"
                //else
                    //if temp = hot
                    //intent hot
                    //else if temp warm
                    //intent warm
                    //else if temp cold
                    //intent cold
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2){
            if(resultCode == 200){
                convertType = intent.getStringExtra("temp");
                Toast.makeText(ConvertActivity.this, convertType, Toast.LENGTH_SHORT).show();
            }
        }

    }

    public String addNumber(int x){
        text_Calc.setText(input + x);
        return input + x;
    }

    private void InitView(){
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_0 = findViewById(R.id.button_0);
        button_clear = findViewById(R.id.button_clear);
        button_dot = findViewById(R.id.button_dot);
        button_convert_from = findViewById(R.id.button_convert_from);
        button_convert_to = findViewById(R.id.button_convert_to);
        info_button = findViewById(R.id.info_button);
        text_Calc = findViewById(R.id.text_Calc);
        button_history = findViewById(R.id.button_history);
    }

}
