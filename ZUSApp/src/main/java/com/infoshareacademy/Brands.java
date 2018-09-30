package com.infoshareacademy;

import javax.json.JsonObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;



public class Brands {

    public String id;
    private String name;
    private String name_clear;
    private boolean hasImage;
    private String link;

    public Brands(){

    }


    public Brands(String id, String name, String name_clear, boolean hasImage, String link){
        this.id = id;
        this.name = name;
        this.name_clear = name_clear;
        this.hasImage = hasImage;
        this.link = link;

    }
    public Brands(String input) throws IOException {

        String link = JSONLoader.MAINLINK + JSONLoader.SUBLINK;

        JsonObject brand = new JSONLoader().showDataArray(link)
                .stream().filter(o->o.asJsonObject().getString("name").equals(input))
                .findAny().get().asJsonObject();

        this.id = brand.getString("id");
        this.name = brand.getString("name");
        this.name_clear = brand.getString("name_clear");
        this.hasImage = brand.getBoolean("has_image");
        this.link = brand.getString("link");
    }

    @Override
    public String toString() {
        return "[ Marka: " + name +
                "\n\t id : " + id +
                "\n\t nazwa : " + name +
                "\n\t nazwa prosta : " + name_clear +
                "\n\t obraz : " + hasImage +
                "\n\t link : " + link + " ]\n";

    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}

