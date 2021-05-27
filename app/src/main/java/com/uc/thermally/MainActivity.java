package com.uc.thermally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private Button button_convert, button_info, button_about, button_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_convert = findViewById(R.id.button_convert);
        button_info = findViewById(R.id.button_info);
        button_about = findViewById(R.id.button_about);
        button_exit = findViewById(R.id.button_exit);

        button_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), ConvertActivity.class);
                startActivity(intent);
            }
        });

        button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), InfoActivity.class);
                startActivity(intent);
            }
        });

        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}