package com.enyata.framework.mvvm.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpRequest {
    private SignUpRequest(){

    }
    public static class Request {

    @Expose
    @SerializedName("surname")
    private String surname;

    @Expose
    @SerializedName("phone")
    private String phone;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("firstname")
    private String firstname;

    @Expose
    @SerializedName("fcmToken")
    private String fcmtoken;

        public Request(String surname, String phone, String email, String password, String firstname, String fcmtoken) {
            this.surname = surname;
            this.phone = phone;
            this.email = email;
            this.password = password;
            this.firstname = firstname;
            this.fcmtoken = fcmtoken;
        }
        public  String getSurname(){return surname;}
    public String getPhone(){return phone;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getFirstname(){return firstname;}
    public String getFcmtoken(){return fcmtoken;}

    }

}
