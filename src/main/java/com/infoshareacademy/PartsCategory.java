package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.List;

class PartsCategory {

    private String name;
    private String link;

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public PartsCategory(){

    }

    public PartsCategory(String name, String link){
        this.name = name;
        this.link = link;
    }

    public List<PartsCategory> getPartsCategory(String sublink) throws IOException{

        List<PartsCategory> partsCategoryList = null;
        String searchLink = JSONLoader.MAINLINK + sublink;


        JsonArray jsonArray = new JSONLoader().showDataArray(searchLink);

        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);

            String name = jsonObject.getString("name");
            String link = jsonObject.getString("link");

            partsCategoryList.add(new PartsCategory(name, link));

        }



        return partsCategoryList;
    }

    @Override
    public String toString() {
        return "\nNazwa kategori : " + name +
                "\n Link do kategori : " + link ;
    }
}
