package com.infoshareacademy;

public class ModelDetails{

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
