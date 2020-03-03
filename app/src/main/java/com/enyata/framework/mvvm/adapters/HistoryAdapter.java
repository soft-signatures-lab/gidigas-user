package com.enyata.framework.mvvm.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.enyata.framework.mvvm.R;


import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<HistoryList> {

    private Context mContext;
    private List<HistoryList> historyList;

    public HistoryAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<HistoryList> list) {
        super(context, 0 , list);
        mContext = context;
        historyList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.history_layout,parent,false);

        HistoryList history = historyList.get(position);


        TextView networkName = listItem.findViewById(R.id.networkPlan);
        networkName.setText(history.getNetworkName());

        TextView date = listItem.findViewById(R.id.dated);
        date.setText(history.getDate());

        TextView amount = listItem.findViewById(R.id.amount);
        amount.setText(history.getAmount());
        TextView complete = listItem.findViewById(R.id.complete);
        complete.setText(history.getComplete());

        return listItem;
    }
}