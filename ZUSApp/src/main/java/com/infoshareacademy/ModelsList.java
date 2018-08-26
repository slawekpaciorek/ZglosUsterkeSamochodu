package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModelsList {

    public List <Models> modelsList = new ArrayList<>();

    public List<Models> getModelsList(String sublink) throws IOException {

        String searchLink = JSONLoader.MAINLINK + sublink;

        JsonArray jsonArray = new JSONLoader().showDataArray(searchLink);

        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);


            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            int end_year = value("end_year", jsonObject);
            int end_month = value("end_month", jsonObject);
            int start_year = value("start_year", jsonObject);
            int start_month = value("start_month", jsonObject);
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

    private int value(String name, JsonObject jsonObject) {

        boolean checkNull = jsonObject.isNull(name);
        int value = 0;

        if (!checkNull){
            String valueS = jsonObject.getString(name);
            return value = Integer.parseInt(valueS);
        }
        else
            return value;
    }


}
