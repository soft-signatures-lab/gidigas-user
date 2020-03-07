package com.enyata.framework.mvvm.ui.transactionhistory;

import android.util.Log;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class TransactionHistoryViewModel extends BaseViewModel<TransactionHistoryNavigator> {

    public TransactionHistoryViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getUserColor(){
        setIsLoading(true);
        getCompositeDisposable().add((getDataManager()
                .colors()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().getUserColor(response);
                    System.out.println("RESPONSE ");
                }, throwable -> {
                    Log.d("ERROR ", String.valueOf(throwable.getMessage()));
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                })));
    }

    public void onTransactionArrow(){
        getNavigator().transactionArrow();
    }
}
