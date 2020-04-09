package com.enyata.framework.mvvm.ui.address;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityAddressBinding;
import com.enyata.framework.mvvm.ui.addaddress.AddAddressActivity;
import com.enyata.framework.mvvm.ui.addcard.AddCardActivity;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.map.MapsActivity;

import javax.inject.Inject;

public class AddressActivity extends BaseActivity<ActivityAddressBinding,AddressViewModel> implements AddressNavigator{
@Inject
    ViewModelProviderFactory factory;
ActivityAddressBinding activityAddressBinding;
AddressViewModel addressViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_address;
    }

    @Override
    public AddressViewModel getViewModel() {
        addressViewModel = ViewModelProviders.of(this,factory).get(AddressViewModel.class);
        return addressViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityAddressBinding = getViewDataBinding();
       addressViewModel.setNavigator(this);
    }

    @Override
    public void addressArrow() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void addAddress() {
        Intent intent = new Intent(getApplicationContext(), AddAddressActivity.class);
        startActivity(intent);
    }
}
