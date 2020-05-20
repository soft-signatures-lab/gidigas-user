package com.enyata.framework.mvvm.ui.order;

public class HistoryList {
    
    private int iconImage;
    
    private String fullName;

    private String status;
    private String amount;

    private String kilogram;

    private String codeno;

    private String date;


    public HistoryList(int iconImage, String fullName, String status, String amount, String kilogram, String codeno, String date) {
        this.iconImage = iconImage;
        this.fullName = fullName;
        this.status= status;
        this.amount=amount;
        this.codeno =codeno;
        this.kilogram = kilogram;
        this.date = date;

    }

    public int getIconImage() {
        return iconImage;
    }

    public void setIconImage(int iconImage) {
        this.iconImage = iconImage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  String getAmount(){
        return amount;
    }
    public  void setAmount(String amount){this.amount = amount;}

    public String getKilogram(){
        return  kilogram;
    }
    public void setKilogram(String kilogram){
        this.kilogram = kilogram;
    }

    public String getCodeno(){return  codeno;}
    public void setCodeno(String codeno){this.codeno = codeno;}

    public String getDate(){return date;}
    public void  setDate(String date){this.date = date;}
    
}
