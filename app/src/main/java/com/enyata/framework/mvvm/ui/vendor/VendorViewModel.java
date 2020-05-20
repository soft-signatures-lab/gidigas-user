package com.enyata.framework.mvvm.ui.vendor;

import android.util.Log;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class VendorViewModel extends BaseViewModel<VendorNavigator> {
    public VendorViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getVendor(){
        setIsLoading(true);
        getCompositeDisposable().add((getDataManager()
        .vendor()
                .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(response -> {
            setIsLoading(false);
            Log.d("Sugar crush","rush");
            getNavigator().getVendor(response);
        },throwable -> {
            Log.d("ERROR ", String.valueOf(throwable.getMessage()));
            setIsLoading(false);
            getNavigator().handleError(throwable);
        })));
    }


}
