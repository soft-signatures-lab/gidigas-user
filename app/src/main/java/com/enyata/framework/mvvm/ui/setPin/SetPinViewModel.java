package com.enyata.framework.mvvm.ui.setPin;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class SetPinViewModel extends BaseViewModel<SetPinNavigator> {
    public SetPinViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onSetPin(){
        getNavigator().setpin();
    }
}
