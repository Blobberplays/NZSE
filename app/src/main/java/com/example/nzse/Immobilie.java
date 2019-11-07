package com.example.nzse;
import java.lang.String;

public class Immobilie {

    double price;
    double rooms_count;
    boolean buy = false;
    double provision;
    String picture;

   Immobilie(double price, double rooms_count, boolean buy, double provision, String picture)
    {
    this.price = 0.0 ;
    this.rooms_count = 0.0;
    this.buy = false;
    this.provision = 2.5;
    this.picture = "";

    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public double getRooms_count() {
        return rooms_count;
    }

    public void setRooms_count(double rooms_count) {
        this.rooms_count = rooms_count;
    }



    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }



    public double getProvision() {
        return provision;
    }

    public void setProvision(double provision) {
        this.provision = provision;
    }



    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
