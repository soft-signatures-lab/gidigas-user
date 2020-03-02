package com.enyata.framework.mvvm.ui.transactionhistory;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class TransactionHistoryViewModel extends BaseViewModel<TransactionHistoryNavigator> {

    public TransactionHistoryViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void onTransactionArrow(){
        getNavigator().transactionArrow();
    }
}
