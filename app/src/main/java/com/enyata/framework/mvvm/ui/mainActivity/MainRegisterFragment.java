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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.data.model.api.response.SignUpResponse;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.utils.Alert;


public class MainRegisterFragment extends Fragment {
    MainActivityViewModel mainActivityViewModel;
    Button button;
    Button navLogin;
    ViewPager viewPager;
    ImageView imageView;
    LinearLayout linearLayout;
    LinearLayout register;
    EditText firstName, surName, phoneNumber, passWord, eMail, fcToken;
    String firstText, surText, phoneText, passwordText, emailtext, fcTokenText;
    ProgressBar progressBar;


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

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.BtnNext);
        imageView = view.findViewById(R.id.backRegister1);
        linearLayout = view.findViewById(R.id.register2);
        register = view.findViewById(R.id.container);

        firstName = view.findViewById(R.id.firstName);
        surName = view.findViewById(R.id.surname);
        phoneNumber = view.findViewById(R.id.phone);
        eMail = view.findViewById(R.id.emailReg);
        passWord = view.findViewById(R.id.passwordReg);
        fcToken = view.findViewById(R.id.referral);

        button.setOnClickListener(view1 -> {
            linearLayout.setVisibility(View.VISIBLE);
            register.setVisibility(View.GONE);
        });
        imageView.setOnClickListener(view12 -> {
            register.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
        });


        navLogin = view.findViewById(R.id.BtnSignUp);
        navLogin.setOnClickListener(view13 -> {
            firstText = firstName.getText().toString();
            surText = surName.getText().toString();
            emailtext = eMail.getText().toString();
            fcTokenText = fcToken.getText().toString();
            passwordText = passWord.getText().toString();
            phoneText = phoneNumber.getText().toString();
            if (mainActivityViewModel.checkIfFieldAreNotEmpty(surText, phoneText, emailtext, passwordText, firstText)) {
                if (mainActivityViewModel.isLengthEqualsToSeven(passwordText)) {
//                    if (isNetworkConnected()) {
//                        Toast.makeText(getContext(), "No internet connection, please check internet settings and try again", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
                    isHidden();
                    mainActivityViewModel.signUp(surText, phoneText, emailtext, passwordText, firstText, fcTokenText);
                } else {
                    Toast.makeText(getContext(), "Password length must be five or more", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), R.string.fill_all_field, Toast.LENGTH_SHORT).show();
            }


        });


    }

//    private boolean isNetworkConnected() {
//        return true;
//    }


}

