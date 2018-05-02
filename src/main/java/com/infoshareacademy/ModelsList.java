package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ModelsList {

    public List <Models> modelsList = new ArrayList<>();

    public List<Models> getModelsList(String sublink) throws IOException {

        String searchLink = JSONLoader.MAINLINK + sublink;

        JsonArray jsonArray = new JSONLoader().showDataArray(searchLink);

        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);


            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String end_year = jsonObject.get("end_year").toString();
            String end_month = jsonObject.get("end_month").toString();
            String start_year = jsonObject.get("start_year").toString();
            String start_month = jsonObject.get("start_month").toString();
            String vehicle_group = jsonObject.getString("vehicle_group");
            String link = jsonObject.getString("link");



            modelsList
                    .add(new Models(id, name, end_year, end_month, start_year, start_month, vehicle_group, link ));
        }

        return modelsList;

    }

    public List getModelsListNames(String sublink)throws IOException{


        List modelsNamesList = new ModelsList().getModelsList(sublink).stream().map(x->x.getName()).collect(Collectors.toList());

        return modelsNamesList;
    }



}
