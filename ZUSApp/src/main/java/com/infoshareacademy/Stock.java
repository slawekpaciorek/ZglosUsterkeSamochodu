package com.infoshareacademy;

public class Stock {
    private String brand;
    private String number;
    private String name;
    private String status;
    private String link;

    public String getLink() {
        return link;
    }

    public Stock(){

    }


    public Stock(String brand, String number, String name, String status, String link){

        this.brand = brand;
        this.number = number;
        this.name = name;
        this.status = status;
        this.link = link;
    }

    @Override
    public String toString() {
        return "\n\t" + name + "" +
                "\n marka : " + brand +
                "\n nr katalogowy : " + number +
                "\n status : " + status + "\n";
    }
}
