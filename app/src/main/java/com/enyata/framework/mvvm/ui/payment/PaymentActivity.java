package com.enyata.framework.mvvm.ui.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityPaymentBinding;
import com.enyata.framework.mvvm.ui.addcard.AddCardActivity;
import com.enyata.framework.mvvm.ui.address.AddressActivity;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;

import javax.inject.Inject;

public class PaymentActivity extends BaseActivity<ActivityPaymentBinding,PaymentViewModel> implements PaymentNavigator {
@Inject
    ViewModelProviderFactory factory;
ActivityPaymentBinding activityPaymentBinding;
PaymentViewModel paymentViewModel;

    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_payment;
    }

    @Override
    public PaymentViewModel getViewModel() {
        paymentViewModel = ViewModelProviders.of(this,factory).get(PaymentViewModel.class);
        return paymentViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPaymentBinding =getViewDataBinding();
        paymentViewModel.setNavigator(this);
    }

    @Override
    public void arrowPayment() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void addCard() {
        Intent intent = new Intent(getApplicationContext(), AddCardActivity.class);
        startActivity(intent);
    }
}
