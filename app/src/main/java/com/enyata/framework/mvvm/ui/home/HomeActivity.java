package com.enyata.framework.mvvm.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityHomeBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.deposit.DepositActivity;
import com.enyata.framework.mvvm.ui.setPin.SetPinActivity;
import com.enyata.framework.mvvm.ui.transactionhistory.TransactionHistoryActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalNavigator;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements HomeNavigator {
 @Inject
 ViewModelProviderFactory factory;
    private  HomeViewModel homeViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeViewModel getViewModel() {
       homeViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel.class);
       return homeViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel.setNavigator(this);
    }

    @Override
    public void Ondeposit() {
        Intent intent = new Intent(getApplicationContext(), DepositActivity.class);
        startActivity(intent);
    }

    @Override
    public void Onwithdrawal() {
        Intent intent = new Intent(getApplicationContext(), WithdrawalActivity.class);
        startActivity(intent);
    }

    @Override
    public void ontransaction() {
        Intent intent = new Intent(getApplicationContext(), TransactionHistoryActivity.class);
        startActivity(intent);
    }
}
