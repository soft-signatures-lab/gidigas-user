package com.enyata.framework.mvvm.ui.order;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.enyata.framework.mvvm.ui.mainActivity.MainLoginFragment;
import com.enyata.framework.mvvm.ui.mainActivity.MainRegisterFragment;

import java.util.ArrayList;
import java.util.List;


public class OrderAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public OrderAdapter(@NonNull FragmentManager fm) {

        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return OrderActiveFragment.newInstance();
        } else  {
            return OrderHistoryFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
