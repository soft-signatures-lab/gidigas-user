package com.enyata.framework.mvvm.ui.addaddress;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class AddAddressViewModel extends BaseViewModel<AddAddressNavigator> {
    public AddAddressViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void OnBackAddress(){
        getNavigator().backArrrow();
    }
}
