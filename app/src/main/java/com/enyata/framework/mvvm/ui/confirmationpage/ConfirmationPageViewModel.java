package com.enyata.framework.mvvm.ui.confirmationpage;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class ConfirmationPageViewModel extends BaseViewModel<ConfirmationPageNavigator> {
    public ConfirmationPageViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void  ConfirmSuccess(){
        getNavigator().confirmSuccess();
    }
    public void arrowConfirm(){
        getNavigator().arrowconfirm();
    }


}
