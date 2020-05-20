package com.enyata.framework.mvvm.ui.order;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enyata.framework.mvvm.R;



public class OrderActiveFragment extends Fragment {

   private OrderViewModel orderViewModel;
    public OrderActiveFragment() {
        // Required empty public constructor
    }


    public static OrderActiveFragment newInstance() {
        return new OrderActiveFragment();
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
        View view = inflater.inflate(R.layout.fragment_order_active, container, false);
        return view;
    }


}
