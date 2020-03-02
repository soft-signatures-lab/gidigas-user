package com.enyata.framework.mvvm.ui.depositpin;

import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityDepositPinBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.deposit.DepositActivity;
import com.enyata.framework.mvvm.ui.depositsucess.DepositSuccessActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;
import com.enyata.framework.mvvm.ui.withdrawalpin.WithdrawalPinActivity;

import javax.inject.Inject;

public class DepositPinActivity extends BaseActivity<ActivityDepositPinBinding, DepositPinViewModel> implements DepositPinNavigator {
@Inject
    ViewModelProviderFactory factory;
DepositPinViewModel depositPinViewModel;
    TextView hintPin;
    EditText pin;

    Button btnCancel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit_pin;
    }

    @Override
    public DepositPinViewModel getViewModel() {
        depositPinViewModel = ViewModelProviders.of(this,factory).get(DepositPinViewModel.class);
        return depositPinViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        depositPinViewModel.setNavigator(this);

        hintPin = findViewById(R.id.hintPin);
        pin = findViewById(R.id.pinNumber);
        pin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    hintPin.setVisibility(View.VISIBLE);
                } else {
                    hintPin.setVisibility(View.GONE);
                }
            }
        });

        btnCancel = findViewById(R.id.BtnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(DepositPinActivity.this);
                dialog.setContentView(R.layout.deposit);
                TextView alertBack = dialog.findViewById(R.id.AlertBack2);
                alertBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                TextView alertLogOut = dialog.findViewById(R.id.AlertDeposit);
                alertLogOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), DepositActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        });
        }


    @Override
    public void arrowdepositsuccess() {
        Intent intent = new Intent(getApplicationContext(), DepositActivity.class);
        startActivity(intent);
    }

    @Override
    public void ondepositsuccess() {
        Intent intent = new Intent(getApplicationContext(), DepositSuccessActivity.class);
        startActivity(intent);
    }
}
