package com.enyata.framework.mvvm.ui.withdrawal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityDepositBinding;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.withdrawalpin.WithdrawalPinActivity;

import javax.inject.Inject;

public class WithdrawalActivity extends BaseActivity<ActivityWithdrawalBinding, WithdrawalViewModel> implements WithdrawalNavigator {
@Inject
    ViewModelProviderFactory factory;
private  WithdrawalViewModel withdrawalViewModel;
    TextView hint;
    TextView hintCoin;
    EditText phone;
    EditText coin;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_withdrawal;
    }

    @Override
    public WithdrawalViewModel getViewModel() {
        withdrawalViewModel = ViewModelProviders.of(this,factory).get(WithdrawalViewModel.class);
        return withdrawalViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withdrawalViewModel.setNavigator(this);

        hint = findViewById(R.id.hintPhone);
        phone = findViewById(R.id.phoneWithdrawal);

        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    hint.setVisibility(View.VISIBLE);
                } else {
                    hint.setVisibility(View.GONE);
                }
            }
        });

        hintCoin = findViewById(R.id.hintCoin);
        coin = findViewById(R.id.WithdrawalCoin);
        coin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    hintCoin.setVisibility(View.VISIBLE);
                } else {
                    hintCoin.setVisibility(View.GONE);
                }
            }
        });

        coin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s) && Integer.parseInt(s.toString()) > 5000) {
                    hintCoin.setBackgroundColor(Color.parseColor("#FF0000"));
                    hintCoin.setText("We dont process amount more than 5000");
                }else{
                    hintCoin.setBackgroundColor(Color.parseColor("#2553CF"));
                    hintCoin.setText("Receive this much in credit (same as amount of cash received");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void arrow() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void withdrawalpin() {
        Intent intent = new Intent(getApplicationContext(), WithdrawalPinActivity.class);
        startActivity(intent);
    }
}
