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

             String id = jsonObject.getString("id");
             String model_id = jsonObject.getString("model_id");
             String brand_id = jsonObject.getString("brand_id");
             String name = jsonObject.getString("name");
             int end_year = getValue("end_year", jsonObject);
             int end_month = getValue("end_month", jsonObject);
             int start_year = getValue("start_year", jsonObject);
             int start_month = getValue("start_month", jsonObject);
             int ccm = getValue("ccm", jsonObject);
             int power_kW = getValue("kw", jsonObject);
             int power_hp = getValue("hp", jsonObject);
             int cylinders = getValue("cylinders", jsonObject);
             String engine = jsonObject.get("engine").toString();
             String engine_desc = jsonObject.getString("engine_txt");
             String fuel = jsonObject.getString("fuel");
             String body = jsonObject.getString("body");
             String axle = jsonObject.get("axle").toString();
             String max_weight = jsonObject.get("max").toString();
             String link = jsonObject.getString("link");

             modelDetails.add(new ModelDetails(id,model_id,brand_id,name,end_year,end_month,start_year,start_month,ccm,power_kW, power_hp,cylinders,engine, engine_desc, fuel, body, axle,max_weight, link));

        }

        return modelDetails;
    }

    private int getValue(String name, JsonObject jsonObject){

        boolean checkNull = jsonObject.isNull(name);
        int value = 0;

        if(!checkNull) {
            String valueStr = jsonObject.getString(name);
            return value = Integer.parseInt(valueStr);
        }
        else
            return value;
    }


}
class ModelDetails{

    private String id;
    private String model_id;
    private String brand_id;
    private String name;
    private int end_year;
    private int end_month;
    private int start_year;
    private int start_month;
    private int ccm;
    private int power_kW;
    private int power_hp;
    private int cylinders;
    private String engine;
    private String engine_desc;
    private String fuel;
    private String body;
    private String axle;
    private String max_weight;
    private String link;

    public ModelDetails(){

    }

    public ModelDetails(String id, String model_id, String brand_id, String name, int end_year, int end_month, int start_year, int start_month, int ccm, int power_kW, int power_hp, int cylinders, String engine, String engine_desc, String fuel ,String body, String axle, String max_weight, String link){

        this.id = id;
        this.model_id = id;
        this.brand_id = brand_id;
        this.name = name;
        this.end_year = end_year;
        this.end_month = end_month;
        this.start_month = start_month;
        this.start_year = start_year;
        this.ccm = ccm;
        this.power_kW = power_kW;
        this.power_hp = power_hp;
        this.cylinders = cylinders;
        this.engine = engine;
        this.engine_desc = engine_desc;
        this.fuel = fuel;
        this.body = body;
        this.axle = axle;
        this.max_weight = max_weight;
        this.link = link;

    }

}
