package com.enyata.framework.mvvm.ui.withdrawal;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class WithdrawalViewModel extends BaseViewModel<WithdrawalNavigator> {
    public WithdrawalViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void onWithdrawalPin(){
        getNavigator().withdrawalpin();
    }
    public void onarrowPin(){
        getNavigator().arrow();
    }
}
