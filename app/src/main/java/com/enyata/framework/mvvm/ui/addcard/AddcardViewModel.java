package com.enyata.framework.mvvm.ui.addcard;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class AddcardViewModel extends BaseViewModel<AddCardNavigator>{
    public AddcardViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void OnBackPayment(){
        getNavigator().backCard();
    }
}
