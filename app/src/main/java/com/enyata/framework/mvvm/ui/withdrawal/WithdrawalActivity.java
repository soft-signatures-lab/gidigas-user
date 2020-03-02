package com.enyata.framework.mvvm.ui.withdrawal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityDepositBinding;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.withdrawalpin.WithdrawalPinActivity;

import javax.inject.Inject;

public class WithdrawalActivity extends BaseActivity<ActivityWithdrawalBinding, WithdrawalViewModel> implements WithdrawalNavigator {
@Inject
    ViewModelProviderFactory factory;
private  WithdrawalViewModel withdrawalViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_withdrawal;
    }

    @Override
    public WithdrawalViewModel getViewModel() {
        withdrawalViewModel = ViewModelProviders.of(this,factory).get(WithdrawalViewModel.class);
        return withdrawalViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withdrawalViewModel.setNavigator(this);
    }

    @Override
    public void arrow() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void withdrawalpin() {
        Intent intent = new Intent(getApplicationContext(), WithdrawalPinActivity.class);
        startActivity(intent);
    }
}
