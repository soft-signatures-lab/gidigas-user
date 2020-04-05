package com.enyata.framework.mvvm.ui.imageslide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivity;


public class ImageCustomerFragment extends Fragment {
LinearLayout linearLayout;
    public ImageCustomerFragment() {
        // Required empty public constructor
    }


    public static ImageCustomerFragment newInstance() {

        return new ImageCustomerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_customer, container, false);
//
//        linearLayout getStarted = view.findViewById(R.id.getStarted);
//                getStarted.setOnClickListener(view1 -> {
//                    Intent intent = new Intent(context, MainActivity.class);
//                    context.startActivity(intent);
//                });

        Intent intent = new Intent(getActivity(), MainActivity.class);
        linearLayout = view.findViewById(R.id.getStarted);
        linearLayout.setOnClickListener(v -> startActivity(intent));


        return view;
    }

}
