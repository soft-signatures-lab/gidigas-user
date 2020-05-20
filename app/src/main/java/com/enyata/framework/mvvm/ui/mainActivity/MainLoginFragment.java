package com.enyata.framework.mvvm.ui.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.utils.InternetConnection;

import java.util.UUID;

import static com.enyata.framework.mvvm.utils.NetworkUtils.isNetworkConnected;

public class MainLoginFragment extends Fragment {


    private MainActivityViewModel mainActivityViewModel;
    Button button;
    EditText email, password;
    String emailText, passwordText;
    String randomUUIDString;
    ProgressBar progressBar;
    FrameLayout layout;


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
        View rootView = inflater.inflate(R.layout.fragment_main_login, container, false);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        UUID uuid = UUID.randomUUID();

        email = view.findViewById(R.id.loginEmail);
        password = view.findViewById(R.id.loginPassword);


        button = view.findViewById(R.id.BtnLogin);
        button.setOnClickListener(view1 -> {


            if (InternetConnection.getInstance(getActivity()).isOnline()) {

                emailText = email.getText().toString();
                passwordText = password.getText().toString();
                randomUUIDString = uuid.toString();

                if (mainActivityViewModel.isEmailAndPasswordValid(emailText, passwordText)) {
                    if (isNetworkConnected()) {
                        return;
                    }
                    mainActivityViewModel.login(emailText, passwordText, randomUUIDString);

                } else {
                    Toast.makeText(getContext(), getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getContext(),"Please check your internet connection and try again",Toast.LENGTH_SHORT).show();
            }

        });



        }

    private boolean isNetworkConnected() {
        //Toast.makeText(getContext(), "No internet connection, please check internet settings and try again", Toast.LENGTH_SHORT).show();
        return false;
    }


}