package com.enyata.framework.mvvm.ui.transactionhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.adapters.HistoryAdapter;
import com.enyata.framework.mvvm.adapters.HistoryList;
import com.enyata.framework.mvvm.databinding.ActivityTransactionHistoryBinding;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class TransactionHistoryActivity extends BaseActivity<ActivityTransactionHistoryBinding, TransactionHistoryViewModel> implements TransactionHistoryNavigator {
    @Inject
    ViewModelProviderFactory factory;
    private TransactionHistoryViewModel transactionHistoryViewModel;

    ListView listView;

    TextView textView;

    private HistoryAdapter historyAdapter;

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

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        ArrayList<HistoryList> historyList = new ArrayList<>();

        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5,455,000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));
        historyList.add(new HistoryList("Withdraw - 05712342323", "11:32, 10/10/2017", "5000.00", "Completed"));

        historyAdapter = new HistoryAdapter(this, historyList);
        listView.setAdapter(historyAdapter);
    }


    @Override
    public void transactionArrow() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
