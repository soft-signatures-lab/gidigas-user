package com.enyata.framework.mvvm.ui.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ui.home.HomeActivity;

public class MainLoginFragment extends Fragment {


    private MainActivityViewModel mainActivityViewModel;
    Button button;

    public MainLoginFragment() {
        // Required empty public constructor
    }

    public static MainLoginFragment newInstance() {
        return new MainLoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewModel = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_main_login, container, false);
    Intent intent = new Intent(getActivity(),HomeActivity.class);
    button = rootView.findViewById(R.id.BtnLogin);
        button.setOnClickListener(v -> startActivity(intent));


        return rootView;
    }

}
