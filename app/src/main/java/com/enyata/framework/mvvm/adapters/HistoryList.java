package com.enyata.framework.mvvm.adapters;

public class HistoryList {



    private String networkName;

    private String date;
    private String complete;
    private  String amount;

    public HistoryList( String networkName, String date,String amount,String complete) {

        this.networkName = networkName;
        this.date = date;
        this.amount=amount;
        this.complete = complete;
    }





    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getDate() { return date; }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComplete() {return complete; }
    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getAmount() {return amount; }
    public void setAmount(String amount) {
        this.amount = amount;
    }

}
