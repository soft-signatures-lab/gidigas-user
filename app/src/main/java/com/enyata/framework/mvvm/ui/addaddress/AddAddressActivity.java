package com.enyata.framework.mvvm.ui.addaddress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityAddAddressBinding;
import com.enyata.framework.mvvm.ui.address.AddressActivity;
import com.enyata.framework.mvvm.ui.base.BaseActivity;

import javax.inject.Inject;

public class AddAddressActivity extends BaseActivity<ActivityAddAddressBinding , AddAddressViewModel> implements AddAddressNavigator {

    @Inject
    ViewModelProviderFactory factory;
    AddAddressViewModel addAddressViewModel;
    ActivityAddAddressBinding activityAddAddressBinding;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_address;
    }

    @Override
    public AddAddressViewModel getViewModel() {
        addAddressViewModel = ViewModelProviders.of(this,factory).get(AddAddressViewModel.class);
        return addAddressViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddAddressBinding = getViewDataBinding();
        addAddressViewModel.setNavigator(this);

        Spinner spinner = (Spinner) findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    public void backArrrow() {
        Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
        startActivity(intent);
    }
}
