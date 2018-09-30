package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartsCategory {

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



