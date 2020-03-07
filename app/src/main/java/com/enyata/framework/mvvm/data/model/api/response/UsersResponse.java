package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersResponse {

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("job")
    private String job;

    @Expose
    @SerializedName("updatedAt")
    private String update;




    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getUpdate() {
        return update;
    }
}
