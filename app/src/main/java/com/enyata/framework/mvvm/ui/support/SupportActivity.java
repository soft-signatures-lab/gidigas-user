package com.enyata.framework.mvvm.ui.support;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivitySupportBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;

import javax.inject.Inject;

public class SupportActivity extends BaseActivity<ActivitySupportBinding, SupportViewModel> implements SupportNavigator {
@Inject
    ViewModelProviderFactory factory;
ActivitySupportBinding activitySupportBinding;
SupportViewModel supportViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_support;
    }

    @Override
    public SupportViewModel getViewModel() {
        supportViewModel = ViewModelProviders.of(this,factory).get(SupportViewModel.class);
        return supportViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySupportBinding = getViewDataBinding();

    }
}
