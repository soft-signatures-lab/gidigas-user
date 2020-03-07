package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserColorResponse {


    @Expose
    @SerializedName("page")
    private int page;

    @Expose
    @SerializedName("per_page")
    private int per_page;

    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("total_pages")
    private int total_pages;

    @Expose
    @SerializedName("data")
    private List<UserResponse> data;

    public List<UserResponse> getData() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return total_pages;
    }
}
