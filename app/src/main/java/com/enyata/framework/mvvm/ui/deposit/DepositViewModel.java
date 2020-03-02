package com.enyata.framework.mvvm.ui.deposit;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class DepositViewModel extends BaseViewModel<DepositNavigator> {
    public DepositViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void  arrowDeposit(){
        getNavigator().backArrow();
    }
    public void onDepositPin(){
        getNavigator().ondepositpin();
    }

}
