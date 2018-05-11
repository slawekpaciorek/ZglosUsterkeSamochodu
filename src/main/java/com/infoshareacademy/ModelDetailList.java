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

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public String getEngine_desc() {
        return engine_desc;
    }

    public String getFuel() {
        return fuel;
    }

    public String getBody() {
        return body;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return  "\n" + name + "{" +
                "id='" + id + '\'' +
                ", model_id='" + model_id + '\'' +
                ", brand_id='" + brand_id + '\'' +
                ", name='" + name + '\'' +
                ", end_year=" + end_year +
                ", end_month=" + end_month +
                ", start_year=" + start_year +
                ", start_month=" + start_month +
                ", ccm=" + ccm +
                ", power_kW=" + power_kW +
                ", power_hp=" + power_hp +
                ", cylinders=" + cylinders +
                ", engine='" + engine + '\'' +
                ", engine_desc='" + engine_desc + '\'' +
                ", fuel='" + fuel + '\'' +
                ", body='" + body + '\'' +
                ", axle='" + axle + '\'' +
                ", max_weight='" + max_weight + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
