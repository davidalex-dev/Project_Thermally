package com.uc.thermally;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConvertActivity extends AppCompatActivity {

    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8,
    button_9, button_0, button_category, button_clear, button_equal, button_convert_from,
    button_convert_to, info_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
    }

    private void InitView(){
        Button button_1 = findViewById(R.id.button_1);
    }

}
