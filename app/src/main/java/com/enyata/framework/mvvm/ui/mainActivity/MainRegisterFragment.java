package com.enyata.framework.mvvm.ui.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.enyata.framework.mvvm.R;


public class MainRegisterFragment extends Fragment{
    MainActivityViewModel mainActivityViewModel;
    Button button;
    ViewPager viewPager;


    public MainRegisterFragment() {
        // Required empty public constructor
    }

    public static MainRegisterFragment newInstance() {
       return new MainRegisterFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewModel = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main_register, container, false);
        button = rootView.findViewById(R.id.BtnNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                 fragmentTransaction.replace(R.id.viewPager, new MainLoginFragment());
                 fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}
