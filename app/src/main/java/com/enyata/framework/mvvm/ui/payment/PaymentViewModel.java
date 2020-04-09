package com.enyata.framework.mvvm.ui.payment;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class PaymentViewModel extends BaseViewModel<PaymentNavigator> {
    public PaymentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void OnArrowPayment(){
        getNavigator().arrowPayment();
    }
    public void OnAddCard(){getNavigator().addCard();}
}
