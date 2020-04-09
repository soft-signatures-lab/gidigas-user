package com.enyata.framework.mvvm.ui.addcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityAddCardBinding;
import com.enyata.framework.mvvm.ui.address.AddressActivity;
import com.enyata.framework.mvvm.ui.address.AddressNavigator;
import com.enyata.framework.mvvm.ui.address.AddressViewModel;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.payment.PaymentActivity;

import javax.inject.Inject;

public class AddCardActivity extends BaseActivity<ActivityAddCardBinding, AddcardViewModel> implements AddCardNavigator {
@Inject
    ViewModelProviderFactory factory;
ActivityAddCardBinding activityAddCardBinding;
AddcardViewModel addcardViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_card;
    }

    @Override
    public AddcardViewModel getViewModel() {
        addcardViewModel = ViewModelProviders.of(this,factory).get(AddcardViewModel.class);
        return addcardViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddCardBinding = getViewDataBinding();
        addcardViewModel.setNavigator(this);
    }


    @Override
    public void backCard() {
        Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
        startActivity(intent);
    }
}
