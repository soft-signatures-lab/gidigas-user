package com.enyata.framework.mvvm.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    private  LoginRequest(){

    }
    public static class Request {

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        @Expose
        @SerializedName("uuid")
        private String uuid;




        public Request(String email, String password,String uuid) {
            this.email = email;
            this.password = password;
            this.uuid = uuid;
        }

        public String getLoginEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
        public String getUuid(){return uuid;}


        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            LoginRequest.Request request = (LoginRequest.Request) obj;

            if (email != null ? !email.equals(request.email) : request.email != null) {
                return false;
            }

            return password != null ? !password.equals(request.password) : request.password != null;
        }

        @Override
        public int hashCode() {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }
    }
}
