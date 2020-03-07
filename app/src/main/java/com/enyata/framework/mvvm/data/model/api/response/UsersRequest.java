package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersRequest {
    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("job")
    private String job;

    public UsersRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
