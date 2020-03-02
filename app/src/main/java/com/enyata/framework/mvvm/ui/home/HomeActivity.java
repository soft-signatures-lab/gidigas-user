package com.enyata.framework.mvvm.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityHomeBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.deposit.DepositActivity;
import com.enyata.framework.mvvm.ui.login.LoginActivity;
import com.enyata.framework.mvvm.ui.setPin.SetPinActivity;
import com.enyata.framework.mvvm.ui.transactionhistory.TransactionHistoryActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalNavigator;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements HomeNavigator {
 @Inject
 ViewModelProviderFactory factory;
    private  HomeViewModel homeViewModel;
    private Button btnLogOut;
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

        btnLogOut = findViewById(R.id.BtnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(HomeActivity.this);
                dialog.setContentView(R.layout.logout);
                TextView alertBack = dialog.findViewById(R.id.AlertBack);
                alertBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                TextView alertLogOut = dialog.findViewById(R.id.AlertLogOut);
                alertLogOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        });
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
