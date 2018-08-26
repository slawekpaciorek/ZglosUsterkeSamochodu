package com.infoshareacademy;

public class Category{

    private String name;
    private String link;
    private boolean sublist;

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public boolean getSublist(){
        return sublist;
    }

    public Category(){

    }

    public Category(String name, String link, boolean sublist){
        this.name = name;
        this.link = link;
        this.sublist = sublist;
    }

    @Override
    public String toString() {
        return "\nNazwa kategori : " + name +
                "\nLink do kategori : " + link + "\n";
    }


}