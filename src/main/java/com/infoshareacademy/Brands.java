package com.infoshareacademy;

import java.net.URL;
import java.util.ArrayList;



public class Brands {

    public String id;
    private String name;
    private String name_clear;
    private boolean hasImage;
    private String link;
    private ArrayList<Brands> brands = new ArrayList<>();


//    Setters and getters for ID

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    Setters and getters for NAME

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    Setters and getters for LINK

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

//    Setters and getters for brands

    public ArrayList<Brands> getBrands() {
        return brands;
    }

    public void setBrands(ArrayList<Brands> brands) {
        this.brands = brands;
    }

//    Setter and getters for hasImage

    public boolean isHasImage(){
        return hasImage;
    }

    public void setHasImage(boolean hasImage){
        this.hasImage = hasImage;
    }

    public String getName_clear() {
        return name_clear;
    }

    public void setName_clear(String name_clear){
        this.name_clear = name_clear;
    }

    public Brands(){

    }

//    Constructor - parametryzowany

    public Brands(String id, String name, String name_clear, boolean hasImage, String link){
        this.id = id;
        this.name = name;
        this.name_clear = name_clear;
        this.hasImage = hasImage;
        this.link = link;

    }
}

