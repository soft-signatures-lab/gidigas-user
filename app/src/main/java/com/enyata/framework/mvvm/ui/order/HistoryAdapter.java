package com.enyata.framework.mvvm.ui.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.enyata.framework.mvvm.R;


import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<HistoryList> {

    private Context mContext;
    private List<HistoryList> historyList;
    LinearLayout linearLayout;

    public HistoryAdapter(@NonNull FragmentActivity context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<HistoryList> list) {
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


        ImageView image = listItem.findViewById(R.id.iconImage);
        image.setImageResource(history.getIconImage());

        TextView fullName = listItem.findViewById(R.id.fullName);
        fullName.setText(history.getFullName());

        TextView status = listItem.findViewById(R.id.status);
        status.setText(history.getStatus());

        TextView amount = listItem.findViewById(R.id.amount);
        amount.setText(history.getAmount());
        TextView kilogram = listItem.findViewById(R.id.kilogram);
        kilogram.setText(history.getKilogram());

        TextView codeno = listItem.findViewById(R.id.codeno);
        codeno.setText(history.getCodeno());
        TextView date = listItem.findViewById(R.id.dated);
        date.setText(history.getDate());



        return listItem;
    }

}