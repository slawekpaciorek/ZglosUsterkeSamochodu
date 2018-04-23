package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrandsList {

    public List <Brands> brandsList = new ArrayList<Brands>();

    public List<Brands> getBrandsList() throws IOException{
        JsonArray jsonArray = new JSONLoader().showDataArray(JSONLoader.MAINLINK + JSONLoader.SUBLINK);



        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);

        String name = jsonObject.getString("name");
        String id = jsonObject.getString("id");
        String name_clear = jsonObject.getString("name_clear");
        String link = jsonObject.getString("link");
        boolean hasImage = jsonObject.getBoolean("has_image");

        brandsList.add(new Brands(id, name, name_clear, hasImage, link));
        }

        return brandsList;
    }
}
