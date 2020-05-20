package com.enyata.framework.mvvm.ui.home;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {
    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void OnHelp(){
        getNavigator().onhelp();
    }

    public void onCreateOrder(){
        getNavigator().onCreateorder();
    }

    public  void OnOrder(){getNavigator().onorder();}

    public  void  OnVendor(){getNavigator().onvendor();}

    public void  OnPayment(){getNavigator().onpayment();}


    public void setFirstName(String firstName){
        getDataManager().setCurrentUserName(firstName);

    }

    public  String getFirstName(){
        return getDataManager().getCurrentUserName();
    }

    public void  setSurName(String surName){
        getDataManager().setCurrentUserSurname(surName);
    }

    public String getSurName(){
        return getDataManager().getCurrentUserSurname();
    }
}
