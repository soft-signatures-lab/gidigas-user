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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enyata.framework.mvvm.R;


public class MainRegisterFragment extends Fragment {
    MainActivityViewModel mainActivityViewModel;
    Button button;
    Button navLogin;
    ViewPager viewPager;
    ImageView imageView;
    LinearLayout linearLayout;
    LinearLayout register;


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
        imageView = rootView.findViewById(R.id.backRegister1);
        linearLayout = rootView.findViewById(R.id.register2);
        register = rootView.findViewById(R.id.container);

        button.setOnClickListener(view -> {
            linearLayout.setVisibility(View.VISIBLE);
            register.setVisibility(View.GONE);

        });

        imageView.setOnClickListener(view -> {
            register.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
        });

        navLogin = rootView.findViewById(R.id.BtnLogin);
        navLogin.setOnClickListener(view -> {
            ViewPager pager = ((MainActivity) getContext()).getViewPager();
            pager.setCurrentItem(0, true);
        });

        return rootView;
    }

}

