package com.enyata.framework.mvvm.ui.imageslide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enyata.framework.mvvm.R;


public class ImageAffordableFragment extends Fragment {


    public ImageAffordableFragment() {
        // Required empty public constructor
    }


    public static ImageAffordableFragment newInstance() {
        return new ImageAffordableFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_affordable, container, false);
        return  view;
    }

}
