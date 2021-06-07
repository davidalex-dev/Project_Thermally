package com.uc.thermally;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.thermally.model.History;


import java.util.ArrayList;

public class HistoryRVAdapter extends RecyclerView.Adapter<HistoryRVAdapter.TempViewHolder>{

    private ArrayList<History> listTemp;

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
        holder.history_Info.setText(listTemp.get(position).getType());
        holder.history_Degrees.setText((int) listTemp.get(position).getTemp());

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
