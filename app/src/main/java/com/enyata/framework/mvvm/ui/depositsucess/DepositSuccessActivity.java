package com.enyata.framework.mvvm.ui.depositsucess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityDepositSuccessBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.depositpin.DepositPinActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.transactionhistory.TransactionHistoryActivity;

import javax.inject.Inject;

public class DepositSuccessActivity extends BaseActivity<ActivityDepositSuccessBinding, DepositSuccessViewModel> implements DepositSuccessNavigator {
@Inject
    ViewModelProviderFactory factory;
DepositSuccessViewModel depositSuccessViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit_success;
    }

    @Override
    public DepositSuccessViewModel getViewModel() {
        depositSuccessViewModel = ViewModelProviders.of(this,factory).get(DepositSuccessViewModel.class);
        return depositSuccessViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       depositSuccessViewModel.setNavigator(this);
    }

    @Override
    public void arrowhome() {
        Intent intent = new Intent(getApplicationContext(), DepositPinActivity.class);
        startActivity(intent);
    }

    @Override
    public void onhome() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
