package com.enyata.framework.mvvm.ui.transactionhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityTransactionHistoryBinding;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;

import javax.inject.Inject;

public class TransactionHistoryActivity extends BaseActivity<ActivityTransactionHistoryBinding, TransactionHistoryViewModel> implements TransactionHistoryNavigator {
@Inject
    ViewModelProviderFactory factory;
private TransactionHistoryViewModel transactionHistoryViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_transaction_history;
    }

    @Override
    public TransactionHistoryViewModel getViewModel() {
        transactionHistoryViewModel = ViewModelProviders.of(this,factory).get(TransactionHistoryViewModel.class);
        return transactionHistoryViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transactionHistoryViewModel.setNavigator(this);
    }


}
