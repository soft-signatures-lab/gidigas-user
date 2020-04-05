package com.enyata.framework.mvvm.ui.imageslide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enyata.framework.mvvm.R;

public class ImageStressFragment extends Fragment {


    public ImageStressFragment() {

    }



    public static ImageStressFragment newInstance() {
        return new ImageStressFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_stress, container, false);

        return view;
    }

}
