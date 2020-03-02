package com.enyata.framework.mvvm.ui.depositpin;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityDepositPinBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.deposit.DepositActivity;
import com.enyata.framework.mvvm.ui.depositsucess.DepositSuccessActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;

import javax.inject.Inject;

public class DepositPinActivity extends BaseActivity<ActivityDepositPinBinding, DepositPinViewModel> implements DepositPinNavigator {
@Inject
    ViewModelProviderFactory factory;
DepositPinViewModel depositPinViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit_pin;
    }

    @Override
    public DepositPinViewModel getViewModel() {
        depositPinViewModel = ViewModelProviders.of(this,factory).get(DepositPinViewModel.class);
        return depositPinViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        depositPinViewModel.setNavigator(this);
    }

    @Override
    public void arrowdepositsuccess() {
        Intent intent = new Intent(getApplicationContext(), DepositActivity.class);
        startActivity(intent);
    }

    @Override
    public void ondepositsuccess() {
        Intent intent = new Intent(getApplicationContext(), DepositSuccessActivity.class);
        startActivity(intent);
    }
}
