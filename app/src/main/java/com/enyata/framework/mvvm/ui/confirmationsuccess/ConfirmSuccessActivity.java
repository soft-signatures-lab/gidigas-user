package com.enyata.framework.mvvm.ui.confirmationsuccess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityConfirmationSuccessBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.confirmationpage.ConfirmationPageActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.setPin.SetPinActivity;

import javax.inject.Inject;

public class ConfirmSuccessActivity extends BaseActivity<ActivityConfirmationSuccessBinding, ConfirmSuccessViewModel> implements ConfirmSuccessNavigator {
@Inject
    ViewModelProviderFactory factory;
private ConfirmSuccessViewModel confirmSuccessViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_confirmation_success;
    }

    @Override
    public ConfirmSuccessViewModel getViewModel() {
        confirmSuccessViewModel = ViewModelProviders.of(this,factory).get(ConfirmSuccessViewModel.class);
        return confirmSuccessViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        confirmSuccessViewModel.setNavigator(this);
    }

    @Override
    public void Confirmhome() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void arrow2() {
        Intent intent = new Intent(getApplicationContext(), ConfirmationPageActivity.class);
        startActivity(intent);
    }
}
