package com.enyata.framework.mvvm.ui.imageslide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivity;

public class ImageAdapter extends FragmentPagerAdapter{

    public ImageAdapter(ImageSlideActivity imageSlideActivity, FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return ImageStressFragment.newInstance();
        }else if (position == 1){
            return  ImageFastFragment.newInstance();
        }else if (position ==2){
            return  ImageAffordableFragment.newInstance();
        }else{
            return ImageCustomerFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


}

