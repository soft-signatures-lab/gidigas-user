package com.enyata.framework.mvvm.ui.mainActivity;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;


import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityMainBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.google.android.material.tabs.TabLayout;


import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements MainNavigator {

    private static final String TAG = "Tabs";
    MainViewPagerAdapter mainViewPagerAdapter;
    @Inject
    ViewModelProviderFactory factory;
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


    }


    @Override
    public void onlogin() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public ViewPager getViewPager() {
        return viewPager;
    }



}
