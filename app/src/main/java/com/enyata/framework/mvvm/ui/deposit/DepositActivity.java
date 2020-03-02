package com.enyata.framework.mvvm.ui.deposit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityDepositBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.depositpin.DepositPinActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;

import javax.inject.Inject;

public class DepositActivity extends BaseActivity<ActivityDepositBinding, DepositViewModel> implements DepositNavigator {
@Inject
    ViewModelProviderFactory factory;
private  DepositViewModel depositViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit;
    }

    @Override
    public DepositViewModel getViewModel() {
        depositViewModel = ViewModelProviders.of(this,factory).get(DepositViewModel.class);
        return depositViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        depositViewModel.setNavigator(this);
    }

    @Override
    public void backArrow() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void ondepositpin() {
        Intent intent = new Intent(getApplicationContext(), DepositPinActivity.class);
        startActivity(intent);
    }
}
