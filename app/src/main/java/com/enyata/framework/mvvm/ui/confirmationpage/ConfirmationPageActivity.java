package com.enyata.framework.mvvm.ui.confirmationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityConfirmationPageBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.confirmationsuccess.ConfirmSuccessActivity;
import com.enyata.framework.mvvm.ui.setPin.SetPinActivity;
import com.enyata.framework.mvvm.ui.withdrawalpin.WithdrawalPinActivity;

import javax.inject.Inject;

public class ConfirmationPageActivity extends BaseActivity<ActivityConfirmationPageBinding, ConfirmationPageViewModel> implements ConfirmationPageNavigator {
@Inject
    ViewModelProviderFactory factory;
private ConfirmationPageViewModel confirmationPageViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_confirmation_page;
    }

    @Override
    public ConfirmationPageViewModel getViewModel() {
        confirmationPageViewModel = ViewModelProviders.of(this,factory).get(ConfirmationPageViewModel.class);
        return confirmationPageViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        confirmationPageViewModel.setNavigator(this);
    }

    @Override
    public void confirmSuccess() {
        Intent intent = new Intent(getApplicationContext(), ConfirmSuccessActivity.class);
        startActivity(intent);
    }

    @Override
    public void arrowconfirm() {
        Intent intent = new Intent(getApplicationContext(), WithdrawalPinActivity.class);
        startActivity(intent);
    }
}
