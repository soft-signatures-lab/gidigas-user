package com.enyata.framework.mvvm.ui.setPin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivitySetPinBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.splash.SplashViewModel;

import javax.inject.Inject;

public class SetPinActivity extends BaseActivity<ActivitySetPinBinding, SetPinViewModel>implements SetPinNavigator {

    @Inject
    ViewModelProviderFactory factory;
    SetPinViewModel setPinViewModel;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_pin;
    }

    @Override
    public SetPinViewModel getViewModel() {
        setPinViewModel = ViewModelProviders.of(this, factory).get(SetPinViewModel.class);

        return setPinViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPinViewModel.setNavigator(this);
    }

    @Override
    public void setpin() {
    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
    startActivity(intent);

    }
}
