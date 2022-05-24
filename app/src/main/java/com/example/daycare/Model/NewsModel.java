package com.example.daycare.Model;

public class NewsModel {
    String Accost, Details, Date;

    public NewsModel(String accost, String date, String details) {
        Accost = accost;
        Date = date;
        Details = details;
    }

    public String getAccost() {
        return Accost;
    }
    public String getDate(){
        return Date;
    }
    public String getDetails() {
        return Details;
    }
}
