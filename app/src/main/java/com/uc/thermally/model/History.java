package com.uc.thermally.model;

public class History {

    private String condition, type; //condition = hot/warm/cold, type = celcius / reamur / fahrenheit
    private double temp; //temp = temperature

    public History(){
        this.temp = 0;
        this.type = "";
        this.condition = "";
    }

    public History(double temp, String type, String condition){
        this.temp = temp;
        this.type = type;
        this.condition = condition;
    }

}
