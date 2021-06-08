package com.uc.thermally;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.thermally.model.History;


import java.util.ArrayList;

public class HistoryRVAdapter extends RecyclerView.Adapter<HistoryRVAdapter.TempViewHolder>{

    private ArrayList<History> listTemp;
    private static final String TAG = "HistoryRVAdapter";

    public HistoryRVAdapter(ArrayList<History> listTemp){
        this.listTemp = listTemp;
    }

    @NonNull
    @Override
    public TempViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_history, parent, false);
        return new TempViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull TempViewHolder holder, int position) {
        holder.history_Name.setText(listTemp.get(position).getCondition());

        String temp = null;
        if(listTemp.get(position).getCondition() == "Hot"){

            if(listTemp.get(position).getType() == "R"){
                temp = "More than 18.8°";
            }else if(listTemp.get(position).getType() == "C"){
                temp = "More than 23.5°";
            }else if(listTemp.get(position).getType() == "F"){
                temp = "More than 74°";
            }

        }else if(listTemp.get(position).getCondition() == "Warm"){

            if(listTemp.get(position).getType() == "R"){
                temp = "About 16 to 18.8°";
            }else if(listTemp.get(position).getType() == "C"){
                temp = "About 20 to 23.5°";
            }else if(listTemp.get(position).getType() == "F"){
                temp = "About 68 to 74°";
            }

        }else if(listTemp.get(position).getCondition() == "Cold"){

            if(listTemp.get(position).getType() == "R"){
                temp = "Less than 16°";
            }else if(listTemp.get(position).getType() == "C"){
                temp = "Less than 20°";
            }else if(listTemp.get(position).getType() == "F"){
                temp = "Less than 68°";
            }

        }

        holder.history_Info.setText(temp + listTemp.get(position).getType());
        holder.history_Degrees.setText("Temperature: " + Double.toString(listTemp.get(position).getTemp()) + "°" + listTemp.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return listTemp.size();
    }

    public class TempViewHolder extends RecyclerView.ViewHolder{
        private TextView history_Name, history_Info, history_Degrees;

        public TempViewHolder(@NonNull View itemView){
            super(itemView);
            history_Name = itemView.findViewById(R.id.history_Name);
            history_Info = itemView.findViewById(R.id.history_Info);
            history_Degrees = itemView.findViewById(R.id.history_Degrees);
        }
    }

}
