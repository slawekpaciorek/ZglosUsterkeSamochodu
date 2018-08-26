package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelDetailList {

    private List <ModelDetails> modelDetails = new ArrayList();

    public List<ModelDetails> getModelDetails(String sublink) throws IOException {

        String searchlink = JSONLoader.MAINLINK + sublink;

        JsonArray jsonArray = new JSONLoader().showDataArray(searchlink);

        for (int i = 0; i < jsonArray.size() ; i++) {

            JsonObject jsonObject = jsonArray.getJsonObject(i);

             String id = getStringValue("id", jsonObject);
             String model_id = getStringValue("model_id", jsonObject);
             String brand_id = getStringValue("brand_id", jsonObject);
             String name = getStringValue("name", jsonObject);
             int end_year = getIntValue("end_year", jsonObject);
             int end_month = getIntValue("end_month", jsonObject);
             int start_year = getIntValue("start_year", jsonObject);
             int start_month = getIntValue("start_month", jsonObject);
             int ccm = getIntValue("ccm", jsonObject);
             int power_kW = getIntValue("kw", jsonObject);
             int power_hp = getIntValue("hp", jsonObject);
             int cylinders = getIntValue("cylinders", jsonObject);
             String engine = getStringValue("engine", jsonObject);
             String engine_desc = getStringValue("engine_txt", jsonObject);
             String fuel = getStringValue("fuel", jsonObject);
             String body = getStringValue("body", jsonObject);
             String axle = getStringValue("axle", jsonObject);
             String max_weight = getStringValue("max_weight", jsonObject);
             String link = getStringValue("link", jsonObject);

             modelDetails.add(new ModelDetails(id,model_id,brand_id,name,end_year,end_month,start_year,start_month,ccm,power_kW, power_hp,cylinders,engine, engine_desc, fuel, body, axle,max_weight, link));

        }

        return modelDetails;
    }

    private int getIntValue(String name, JsonObject jsonObject){

        boolean checkNull = jsonObject.isNull(name);
        int value = 0;

        if(!checkNull) {
            String valueStr = jsonObject.getString(name);
            return value = Integer.parseInt(valueStr);
        }
        else
            return value;
    }

    private String getStringValue(String name, JsonObject jsonObject){

        String value;

        boolean checkNull = jsonObject.isNull(name);

        if(!checkNull)
            value = jsonObject.getString(name);
        else
            value = "unknown";


        return value;
    }


}
