package com.enyata.framework.mvvm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.confirmationpage.ConfirmationPageViewModel;
import com.enyata.framework.mvvm.ui.confirmationsuccess.ConfirmSuccessViewModel;
import com.enyata.framework.mvvm.ui.deposit.DepositViewModel;
import com.enyata.framework.mvvm.ui.depositpin.DepositPinViewModel;
import com.enyata.framework.mvvm.ui.depositsucess.DepositSuccessViewModel;
import com.enyata.framework.mvvm.ui.home.HomeViewModel;
import com.enyata.framework.mvvm.ui.login.LoginViewModel;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivityViewModel;
import com.enyata.framework.mvvm.ui.setPin.SetPinViewModel;
import com.enyata.framework.mvvm.ui.splash.SplashViewModel;
import com.enyata.framework.mvvm.ui.transactionhistory.TransactionHistoryViewModel;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalViewModel;
import com.enyata.framework.mvvm.ui.withdrawalpin.WithdrawalPinViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            //noinspection unchecked
            return (T) new MainActivityViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(ConfirmationPageViewModel.class)) {
            //noinspection unchecked
            return (T) new ConfirmationPageViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(ConfirmSuccessViewModel.class)) {
            //noinspection unchecked
            return (T) new ConfirmSuccessViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(SetPinViewModel.class)) {
            //noinspection unchecked
            return (T) new SetPinViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            //noinspection unchecked
            return (T) new HomeViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(DepositViewModel.class)) {
            //noinspection unchecked
            return (T) new DepositViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(DepositPinViewModel.class)) {
            //noinspection unchecked
            return (T) new DepositPinViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(DepositSuccessViewModel.class)) {
            //noinspection unchecked
            return (T) new DepositSuccessViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(WithdrawalViewModel.class)) {
            //noinspection unchecked
            return (T) new WithdrawalViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(WithdrawalPinViewModel.class)) {
            //noinspection unchecked
            return (T) new WithdrawalPinViewModel(dataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(TransactionHistoryViewModel.class)) {
            //noinspection unchecked
            return (T) new TransactionHistoryViewModel(dataManager, schedulerProvider);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}