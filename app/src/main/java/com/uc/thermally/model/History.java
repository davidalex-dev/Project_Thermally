package com.uc.thermally.model;

import android.os.Parcel;
import android.os.Parcelable;

public class History implements Parcelable {

    private String condition, type;
    //condition = hot/warm/cold
    //type = C (celcius) / R (reamur) / F (fahrenheit)

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

    protected History(Parcel in) {
        condition = in.readString();
        type = in.readString();
        temp = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(condition);
        dest.writeString(type);
        dest.writeDouble(temp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public String getCondition(){
        return condition;
    }

    public String getType(){
        return type;
    }

    public double getTemp(){
        return temp;
    }

}
