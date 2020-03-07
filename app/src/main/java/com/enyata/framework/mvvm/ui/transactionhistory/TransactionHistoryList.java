package com.enyata.framework.mvvm.ui.transactionhistory;

public class TransactionHistoryList {

    private String name;
    private String partoneValue;
    private String color;
    private  String year;

    public TransactionHistoryList(String name, String partoneValue,String year,String color) {
        this.name = name;
        this.partoneValue = partoneValue;
        this.year = year;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartoneValue() {
        return partoneValue;
    }

    public void setPartoneValue(String partoneValue) {
        this.partoneValue = partoneValue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String complete) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
