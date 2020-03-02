package com.enyata.framework.mvvm.ui.withdrawalpin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalBinding;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalPinBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.confirmationpage.ConfirmationPageActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalViewModel;

import javax.inject.Inject;

public class WithdrawalPinActivity extends BaseActivity<ActivityWithdrawalPinBinding, WithdrawalPinViewModel> implements WithdrawalPinNavigator {
@Inject
    ViewModelProviderFactory factory;
WithdrawalPinViewModel withdrawalPinViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_withdrawal_pin;
    }

    @Override
    public WithdrawalPinViewModel getViewModel() {
        withdrawalPinViewModel= ViewModelProviders.of(this, factory).get(WithdrawalPinViewModel.class);
        return withdrawalPinViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withdrawalPinViewModel.setNavigator(this);

    }

    @Override
    public void onconfirmpage() {
        Intent intent = new Intent(getApplicationContext(), ConfirmationPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void arrow1() {
        Intent intent = new Intent(getApplicationContext(), WithdrawalActivity.class);
        startActivity(intent);
    }
}
