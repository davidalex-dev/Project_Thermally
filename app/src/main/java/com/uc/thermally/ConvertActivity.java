package com.uc.thermally;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
//import androidx.appcompat.app.AppCompatActivity;

public class ConvertActivity extends AppCompatActivity {

    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8,
    button_9, button_0, button_clear, button_dot, button_convert_from,
    button_convert_to, info_button, button_history;
    private EditText text_Calc;
    private TextView text_Selected;
    private String input = "";
    public static String convertType = null;
    public static String tempConv = null;
    private Intent intent;
    private Boolean converted = false;

    private static final String TAG = "ConvertActivity";

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
                if(converted!=true){
                    input = addNumber(1);
                }
            }
        });

        button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(2);
                }
            }
        });

        button_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(3);
                }
            }
        });

        button_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(4);
                }
            }
        });

        button_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(5);
                }
            }
        });

        button_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(6);
                }
            }
        });

        button_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(7);
                }
            }
        });

        button_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(8);
                }
            }
        });

        button_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(9);
                }
            }
        });

        button_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(converted!=true){
                    input = addNumber(0);
                }
            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(converted!=true){
                    input += ".";
                }
            }
        });


        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = "";
                convertType = null;
                converted = false;
                text_Calc.setText("Enter a temperature number.");
                text_Selected.setText("Conversion type not yet selected.");
            }
        });

        button_convert_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(input == ""){
                    Toast.makeText(getApplicationContext(), "Temperature not yet input!", Toast.LENGTH_SHORT).show();
                }else if(convertType == null){
                    Toast.makeText(getApplicationContext(), "Convert Type not yet set!", Toast.LENGTH_SHORT).show();
                }else if(input == "" && convertType==null){
                    Toast.makeText(getApplicationContext(), "Temperature and convert not yet set!", Toast.LENGTH_SHORT).show();
                }else{
                    if(converted == true){
                        Toast.makeText(getApplicationContext(), "You have converted, please clear", Toast.LENGTH_SHORT).show();
                    }else{
                        Convert(Double.parseDouble(input));
                    }

                }

            }
        });

        button_convert_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(converted!=true){
                    intent = new Intent(getBaseContext(), ConvertInfoActivity.class);
                    startActivityForResult(intent, 2);
                }
            }
        });

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if converted !=true
                //kembali ke menu
                //finish();
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
            if(convertType!=null && tempConv!=null) {
                text_Selected.setText(tempConv);
            }
        }

    }

    public String addNumber(double x){
        DecimalFormat df = new DecimalFormat("###.#");
        text_Calc.setText(input + df.format(x));
        return input + df.format(x);
    }

    private void Convert(double x){
        double temp = x; //memasukkan input ke temp
        double temp2 = 0; //hasil akhir
        String finale = ""; // R, C, F (Reamur or Celcius or Fahrenheit)

        if(convertType == "RC"){ //Reamur -> Celcius
            //°C = °Ré / 0,8
            temp2 = temp / 0.8;
            finale = "C";
        }else if(convertType == "RF"){ //Reamur -> Fahrenheit
            //°F = °Ré × 2,25 + 32
            temp2 = (temp * 2.25)+32;
            finale = "F";
        }else if(convertType == "CR"){ //Celcius -> Reamur
            //°Ré = °C × 0,8
            temp2 = temp*0.8;
            finale = "R";
        }else if(convertType == "CF"){ //Celcius -> Fahrenheit
            //°F = °C × 1,8 + 32
            temp2 = (temp*1.8)+32;
            finale = "F";
        }else if(convertType == "FR"){ //Fahrenheit -> Reamur
            //°Ré = (°F − 32) / 2,25
            temp2 = (temp-32)/2.25;
            finale = "R";
        }else if(convertType == "FC"){ //Fahrenheit -> Celcius
            //°C = (°F − 32) / 1,8
            temp2 = (temp-32)/1.8;
            finale = "C";
        }

        converted = true;

        //put in history

        Log.d(TAG, "ConvertType: " + convertType);
        Log.d(TAG, "temp2 is: " + temp2);

        //teks show hot, warm, or cold
        textChange(finale, temp2);

    }

    private void textChange(String s, double d){
        String tempString = s;
        double tempDouble = d;
        String textChange = "";

        Log.d(TAG, "Entering textChange");
        Log.d(TAG, "tempString: " + tempString);
        Log.d(TAG, "tempDouble: " + tempDouble);

        if(tempString == "R"){ //reamur
            if(tempDouble > 18.8){
                //hot
                textChange = "Hot";
            }else if(tempDouble > 16 && tempDouble <18.8){
                //warm
                textChange = "Warm";
            }else if(tempDouble <16){
                //cold
                textChange = "Cold";
            }
        }else if(tempString == "C"){ //celcius
            if(tempDouble > 23.5){
                textChange = "Hot";
            }else if(tempDouble > 20 && tempDouble < 23.5){
                textChange = "Warm";
            }else if(tempDouble < 20){
                textChange = "Cold";
            }
        }else if(tempString == "F"){ //fahrenheit
            if(tempDouble > 74){
                textChange = "Hot";
            }else if(tempDouble > 68 && tempDouble < 74){
                textChange = "Warm";
            }else if(tempDouble < 68){
                textChange = "Cold";
            }
        }

        Log.d(TAG, "textChange: " + textChange);
        text_Calc.setText(textChange);

    }

    private void InitView(){
        text_Selected = findViewById(R.id.text_Selected);
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
        text_Selected = findViewById(R.id.text_Selected);
    }

}
