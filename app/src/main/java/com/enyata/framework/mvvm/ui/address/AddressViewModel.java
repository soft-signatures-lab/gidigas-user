package com.enyata.framework.mvvm.ui.address;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class AddressViewModel extends BaseViewModel<AddressNavigator> {
    public AddressViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void OnArrowAddress() {
        getNavigator().addressArrow();
    }

    public void OnAddAddress() {
        getNavigator().addAddress();
    }
}