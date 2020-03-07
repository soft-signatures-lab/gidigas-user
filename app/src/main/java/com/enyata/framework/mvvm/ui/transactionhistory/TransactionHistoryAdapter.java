package com.enyata.framework.mvvm.ui.transactionhistory;

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

public class TransactionHistoryAdapter extends ArrayAdapter<TransactionHistoryList> {


    private Context mContext;
    private List<TransactionHistoryList> historyList;

    public TransactionHistoryAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<TransactionHistoryList> list) {
        super(context, 0, list);
        mContext = context;
        historyList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.history_layout, parent, false);

        TransactionHistoryList history = historyList.get(position);

        TextView Name = listItem.findViewById(R.id.networkPlan);
        Name.setText(history.getName());

        TextView parton = listItem.findViewById(R.id.dated);
        parton.setText(history.getPartoneValue());

        TextView year = listItem.findViewById(R.id.amount);
        year.setText(history.getYear());

        TextView color = listItem.findViewById(R.id.complete);
        color.setText(history.getColor());

        return listItem;
    }

}
