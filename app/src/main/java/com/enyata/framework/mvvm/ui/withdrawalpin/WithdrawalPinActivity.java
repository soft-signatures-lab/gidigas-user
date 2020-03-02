package com.enyata.framework.mvvm.ui.withdrawalpin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalBinding;
import com.enyata.framework.mvvm.databinding.ActivityWithdrawalPinBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.confirmationpage.ConfirmationPageActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalViewModel;

import javax.inject.Inject;

public class WithdrawalPinActivity extends BaseActivity<ActivityWithdrawalPinBinding, WithdrawalPinViewModel> implements WithdrawalPinNavigator {
@Inject
    ViewModelProviderFactory factory;
WithdrawalPinViewModel withdrawalPinViewModel;
    TextView hintPin;
    EditText pin;
    Button btnCancel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_withdrawal_pin;
    }

    @Override
    public WithdrawalPinViewModel getViewModel() {
        withdrawalPinViewModel= ViewModelProviders.of(this, factory).get(WithdrawalPinViewModel.class);
        return withdrawalPinViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withdrawalPinViewModel.setNavigator(this);

        hintPin = findViewById(R.id.hintPin1);
        pin = findViewById(R.id.pinWithdraw);
        pin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s) && Integer.parseInt(s.toString()) == 1234) {
                    hintPin.setBackgroundColor(Color.parseColor("#2553CF"));
                    hintPin.setText("correct pin");
                }else{
                    hintPin.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        btnCancel = findViewById(R.id.BtnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(WithdrawalPinActivity.this);
                dialog.setContentView(R.layout.withdrawal);
                TextView alertBack = dialog.findViewById(R.id.AlertBack1);
                alertBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                TextView alertLogOut = dialog.findViewById(R.id.AlertWithdraw);
                alertLogOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), WithdrawalActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        });

    }

    @Override
    public void onconfirmpage() {
        Intent intent = new Intent(getApplicationContext(), ConfirmationPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void arrow1() {
        Intent intent = new Intent(getApplicationContext(), WithdrawalActivity.class);
        startActivity(intent);
    }
}
