package com.enyata.framework.mvvm.ui.vendor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.enyata.framework.mvvm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VendorAdapter extends ArrayAdapter<VendorList> {

    private Context mContext;
    private List<VendorList> vendorLists;

    public VendorAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<VendorList> list) {
        super(context, 0, list);
        mContext = context;
        vendorLists = list;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        ViewHolder holder;

        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.vendor_list, parent, false);
            holder = new ViewHolder();
            holder.logoView = listItem.findViewById(R.id.vendorLogo);
            holder.nameView = listItem.findViewById(R.id.vendorName);
            holder.kgView = listItem.findViewById(R.id.perkg);
            holder.locationView = listItem.findViewById(R.id.location);
            holder.ratingView = listItem.findViewById(R.id.rating);

            listItem.setTag(holder);
        }
        else {
            holder = (ViewHolder) listItem.getTag();
        }

        VendorList vendor = vendorLists.get(position);

        Picasso.get().load(vendor.getLogoImage()).into(holder.logoView);
        holder.nameView.setText(vendor.getVendorName());
        holder.kgView.setText("N" + " " + vendor.getAmountPerKg() + " " + "per kg");
        holder.locationView.setText(vendor.getVendorLocation());

        RatingBar rate = holder.ratingView;
        rate.setIsIndicator(true);
        if (vendor.getRatingImage() > 0){
            rate.setRating(vendor.getRatingImage());
        }else {
            rate.setVisibility(View.GONE);
        }

        return listItem;
    }

    static class ViewHolder {
        public ImageView logoView;
        public TextView nameView;
        public TextView kgView;
        public TextView locationView;
        public RatingBar ratingView;
    }

    @Override
    public int getCount() {
        return vendorLists.size();
    }
}
