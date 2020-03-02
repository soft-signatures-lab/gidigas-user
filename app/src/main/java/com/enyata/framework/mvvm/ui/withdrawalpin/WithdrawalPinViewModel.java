package com.enyata.framework.mvvm.ui.withdrawalpin;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class WithdrawalPinViewModel extends BaseViewModel<WithdrawalPinNavigator> {
    public WithdrawalPinViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public  void  arrow1(){
        getNavigator().arrow1();
    }
    public  void onConfirmPage(){
        getNavigator().onconfirmpage();
    }
}
