package com.enyata.framework.mvvm.ui.mainActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.androidnetworking.error.ANError;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;
import com.enyata.framework.mvvm.data.model.api.response.SignUpResponse;
import com.enyata.framework.mvvm.databinding.ActivityMainBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;


import java.security.AccessController;

import javax.inject.Inject;

import static java.security.AccessController.getContext;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements MainNavigator {

    private static final String TAG = "Tabs";
    MainViewPagerAdapter mainViewPagerAdapter;
    @Inject
    ViewModelProviderFactory factory;
    @Inject
    Gson gson;
    TabLayout tabLayout;
    ActivityMainBinding activityMainBinding;
    public static ViewPager viewPager;
    LinearLayout linearLayout;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    private MainActivityViewModel mainActivityViewModel;

    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityViewModel getViewModel() {
        mainActivityViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel.class);
        return mainActivityViewModel;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = getViewDataBinding();
        mainActivityViewModel.setNavigator(this);

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());

        Log.d(TAG, "onCreate: Starting.");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        mainViewPagerAdapter.addFragment(new MainLoginFragment(), "Log In");
        mainViewPagerAdapter.addFragment(new MainRegisterFragment(), "Register");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {

            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {

                TextView tabTextView = new TextView(this);
                tab.setCustomView(tabTextView);

                tabTextView.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
                tabTextView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;

                tabTextView.setText(tab.getText());
                tabTextView.setTextColor(Color.parseColor("#FFFFFF"));

                if (i == 0) {
                    tabTextView.setTextSize(22);


                }

            }

        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTextSize(22);

                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(tab.getPosition());
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTextSize(14);

                    }
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public ViewPager getViewPager() {
        return viewPager;
    }

    @Override
    public void onSignUp(SignUpResponse response) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), response.getResponseMsg(), Toast.LENGTH_SHORT).show();
        Log.i("successful", "SUCCESSFUL");

    }


    @Override
    public void handleError(Throwable throwable) {
        if (throwable != null) {
            ANError error = (ANError) throwable;


            SignUpResponse response = gson.fromJson(error.getErrorBody(), SignUpResponse.class);
            LoginResponse response1 = gson.fromJson(error.getErrorBody(), LoginResponse.class);
            if (error.getErrorBody() != null) {
                Toast.makeText(getApplicationContext(), response1.getReponseMsg(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Unable to connect to the Internet" , Toast.LENGTH_SHORT).show();

            }
            Log.d("Error failed", "FAILED");


        }


    }

    @Override
    public void onLogin(LoginResponse response) {

        String firstName = response.getLoginData().getFirstname();
        String surName = response.getLoginData().getSurname();

        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_SHORT).show();
        Log.i("Login successful","Successful");
    }


}
