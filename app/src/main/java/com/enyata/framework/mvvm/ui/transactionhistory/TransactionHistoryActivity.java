package com.enyata.framework.mvvm.ui.transactionhistory;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.data.model.api.response.UserColorResponse;
import com.enyata.framework.mvvm.data.model.api.response.UserResponse;
import com.enyata.framework.mvvm.databinding.ActivityTransactionHistoryBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TransactionHistoryActivity extends BaseActivity<ActivityTransactionHistoryBinding, TransactionHistoryViewModel> implements TransactionHistoryNavigator {
    @Inject
    ViewModelProviderFactory factory;
    private TransactionHistoryViewModel transactionHistoryViewModel;

    ListView listView;

    TextView textView;

    ArrayList<TransactionHistoryList> historyLists = new ArrayList<>();

    ActivityTransactionHistoryBinding activityTransactionHistoryBinding;

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
        transactionHistoryViewModel = ViewModelProviders.of(this, factory).get(TransactionHistoryViewModel.class);
        return transactionHistoryViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transactionHistoryViewModel.setNavigator(this);
        activityTransactionHistoryBinding = getViewDataBinding();
        listView = activityTransactionHistoryBinding.listView;
        textView = activityTransactionHistoryBinding.text;

        transactionHistoryViewModel.getUserColor();
    }


    @Override
    public void transactionArrow() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }


    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void getUserColor(UserColorResponse userColorResponse) {
        List<UserResponse> historyList = userColorResponse.getData();
        for (int i = 0; i < historyList.size(); i++) {
            UserResponse data = historyList.get(i);
            String color = data.getColor();
            String name = data.getName();
            String pantonValue = data.getPantoneValue();
            int year = data.getYear();
            historyLists.add(new TransactionHistoryList(name, pantonValue, String.valueOf(year), color));
            TransactionHistoryAdapter adapter = new TransactionHistoryAdapter(TransactionHistoryActivity.this, historyLists);
            listView.setAdapter(adapter);
        }
    }
}
