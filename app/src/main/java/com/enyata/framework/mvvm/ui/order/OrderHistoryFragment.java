package com.enyata.framework.mvvm.ui.order;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.enyata.framework.mvvm.R;

import java.util.ArrayList;


public class OrderHistoryFragment extends Fragment {

    private ListView listView;
    private TextView textView;
    private HistoryAdapter historyAdapter;


   private OrderViewModel orderViewModel;

    public OrderHistoryFragment() {
        // Required empty public constructor
    }


    public static OrderHistoryFragment newInstance() {
        return new OrderHistoryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderViewModel = ViewModelProviders.of(requireActivity()).get(OrderViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_history, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        textView = view.findViewById(R.id.textView);
        ArrayList<HistoryList> historyList = new ArrayList<>();
        historyList.add(new HistoryList(R.drawable.ic_history,"Ogechi Chiama","Successful","3000","5kg","CE45666","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Tomiwa Sanni","Successful","3000","5kg","We56788","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Andrea Mena","Failed","6000","5kg","AT67895","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Ogechi Chiama","Successful","3000","5kg","CE45666","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Tomiwa Sanni","Successful","3000","5kg","We56788","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Andrea Mena","Failed","6000","5kg","AT67895","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Ogechi Chiama","Successful","3000","5kg","CE45666","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Tomiwa Sanni","Successful","3000","5kg","We56788","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Andrea Mena","Failed","6000","5kg","AT67895","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Ogechi Chiama","Successful","3000","5kg","CE45666","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Tomiwa Sanni","Successful","3000","5kg","We56788","12/10/2019"));
        historyList.add(new HistoryList(R.drawable.ic_history,"Andrea Mena","Failed","6000","5kg","AT67895","12/10/2019"));



        historyAdapter = new HistoryAdapter(getActivity(),historyList);
        listView.setAdapter(historyAdapter);

        return view;
    }




}
