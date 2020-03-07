package com.enyata.framework.mvvm.ui.deposit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.data.model.api.response.UsersResponse;
import com.enyata.framework.mvvm.databinding.ActivityDepositBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.depositpin.DepositPinActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.login.LoginViewModel;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;

import javax.inject.Inject;

public class DepositActivity extends BaseActivity<ActivityDepositBinding, DepositViewModel> implements DepositNavigator {
@Inject
    ViewModelProviderFactory factory;
private  DepositViewModel depositViewModel;
    TextView hint;
    TextView hintCoin;
    EditText phone;
    EditText coin;
    private  ActivityDepositBinding activityDepositBinding;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit;
    }

    @Override
    public DepositViewModel getViewModel() {
        depositViewModel = ViewModelProviders.of(this,factory).get(DepositViewModel.class);
        return depositViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDepositBinding = getViewDataBinding();
        depositViewModel.setNavigator(this);





        hint = findViewById(R.id.hint);
        phone = findViewById(R.id.phone);

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


        hintCoin = findViewById(R.id.hintPassword);
        coin = findViewById(R.id.DepositCoin);
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

//        coin.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (!TextUtils.isEmpty(s) && Integer.parseInt(s.toString()) > 5000) {
//                    hintCoin.setBackgroundColor(Color.parseColor("#FF0000"));
//                    hintCoin.setText("We dont process amount more than 5000");
//                }else{
//                    hintCoin.setBackgroundColor(Color.parseColor("#2553CF"));
//                    hintCoin.setText("Receive this much in credit (same as amount of cash received");
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }

    @Override
    public void backArrow() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void ondepositpin() {
        String name = activityDepositBinding.phone.getText().toString();
        String job = activityDepositBinding.DepositCoin.getText().toString();

            depositViewModel.user(name,job);

//           Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void Depositpin() {
        Intent intent = new Intent(getApplicationContext(), DepositPinActivity.class);
        startActivity(intent);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void getUser(UsersResponse resp) {

        Log.d("Response","Edited user" + resp.getName() + resp.getJob() + resp.getUpdate());
    }
}
