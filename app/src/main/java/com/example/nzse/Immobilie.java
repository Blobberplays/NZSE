package com.example.nzse;

import java.io.Serializable;
import java.lang.String;

public class Immobilie implements Serializable {

    private double price;
    private double rooms_count;
    private boolean buy = false;
    private double provision;
    private String picture;
    private int id;
    private static int idCounter = 0;
    private boolean smoke;
    private boolean animals;
    private boolean intrested;

    public boolean isIntrested() {
        return intrested;
    }

    public void setIntrested(boolean intrested) {
        this.intrested = intrested;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;




    /*Immobilie(double price, double rooms_count, boolean buy, double provision, String picture) {
        this.id = idCounter++;
        this.price = price;
        this.rooms_count = rooms_count;
        this.buy = buy;
        this.provision = provision;
        this.picture = picture;

    }*/
    Immobilie(double price, double rooms_count, boolean buy, double provision, String picture, boolean smoke, boolean animals) {
        this.id = idCounter++;
        this.price = price;
        this.rooms_count = rooms_count;
        this.buy = buy;
        this.provision = provision;
        this.picture = picture;
        this.smoke = smoke;
        this.animals = animals;
        intrested=false;

    }
    Immobilie(double price, double rooms_count, boolean buy, double provision, String picture, boolean smoke, boolean animals,String description) {
        this.id = idCounter++;
        this.price = price;
        this.rooms_count = rooms_count;
        this.buy = buy;
        this.provision = provision;
        this.picture = picture;
        this.smoke = smoke;
        this.animals = animals;
        this.description = description;
        intrested=false;
    }
    Immobilie(double price, double rooms_count, boolean buy, double provision, boolean smoke, boolean animals,String description) {
        this.id = idCounter++;
        this.price = price;
        this.rooms_count = rooms_count;
        this.buy = buy;
        this.provision = provision;
        this.picture = Integer.toString(id);
        this.smoke = smoke;
        this.animals = animals;
        this.description = description;
        intrested=false;
    }
    public int getId() {
        return id;
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

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public boolean isAnimals() {
        return animals;
    }

    public void setAnimals(boolean animals) {
        this.animals = animals;
    }
}
