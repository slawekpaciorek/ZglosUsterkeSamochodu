package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PartsCategory {



    public List<Category> getPartsCategory(String sublink) throws IOException{

        List<Category> partsCategoryList = new ArrayList<>();
        String searchLink = JSONLoader.MAINLINK + sublink;


        JsonArray jsonArray = new JSONLoader().showDataArray(searchLink);

        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);

            String name = jsonObject.getString("name");
            String link = jsonObject.getString("link");
            boolean sublist = jsonObject.getBoolean("has_children");

            partsCategoryList.add(new Category(name, link, sublist));

        }

        return partsCategoryList;
    }

    public List<Category> partsCategorySubList(String sublink) throws IOException{

        List<Category> subList = new ArrayList<>();
        String serachlink = JSONLoader.MAINLINK + sublink;
        JsonArray jsonArray = new JSONLoader().showDataArray(serachlink);

        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);

            String name = jsonObject.getString("name");
            String link = jsonObject.getString("link");
            boolean sublist = jsonObject.getBoolean("has_children");

            subList.add(new Category(name, link, sublist));
        }

        return subList;
    }

    public List<Stock> getStockList(String sublink) throws IOException{

        String searchLink = JSONLoader.MAINLINK + sublink;
        JsonArray jsonArray = new JSONLoader().showDataArray(searchLink);
        List<Stock> stockList = new ArrayList<>();

        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);

            String brand = jsonObject.getString("brand");
            String number = jsonObject.getString("number");
            String name = jsonObject.getString("name");
            String status = jsonObject.getString("status");
            String link = jsonObject.getString("link");

            stockList.add(new Stock(brand, number, name, status, link));
        }

        return stockList;
    }

}

class Category{

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

class Stock{

    private String brand;
    private String number;
    private String name;
    private String status;
    private String link;

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

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
