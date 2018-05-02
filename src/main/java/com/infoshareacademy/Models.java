package com.infoshareacademy;

import java.net.URL;

class Models extends Brands {

    private String id;
    private String name;
    private String end_year;
    private String end_month;
    private String start_year;
    private String start_month;
    private String vehicle_group;
    private String link;

//    getters & setter for ID

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    getters & setters for NAME

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    getters & setters for END YEAR

    public String getEnd_year() {
        return end_year;
    }

    public void setEnd_year(String end_year) {
        this.end_year = end_year;
    }

//    getters & setters for END MONTH

    public String getEnd_month() {
        return end_month;
    }

    public void setEnd_month(String end_month) {
        this.end_month = end_month;
    }

//    getters & setters START YEAR

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }

//    getters & setters START MONTH

    public String getStart_month() {
        return start_month;
    }

    public void setStart_month(String start_month) {
        this.start_month = start_month;
    }

//    getters & setters VEHICLE GROUP

    public String getVehicle_group() {
        return vehicle_group;
    }

    public void setVehicle_group(String vehicle_group) {
        this.vehicle_group = vehicle_group;
    }

//    getters & setters LINK

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

//    Constructors

    public Models(){

    }

    public Models(String id, String name, String end_year, String end_month, String start_year, String start_month, String vehicle_group, String link){
        this.id = id;
        this.name = name;
        this.end_year = end_year;
        this.end_month = end_month;
        this.start_year = start_year;
        this.start_month = start_month;
        this.vehicle_group = vehicle_group;
        this.link = link;
    }

    @Override
    public String toString() {
        return
        "\nModel : " + name +
                "\t\n Numer id : " + id +
                "\t\n Nazwa modelu : " + name +
                "\t\n Rozpoczęcie produkcji : " + start_month + "-" + start_year +
                "\t\n Zakończenie produkcji : " + end_month + "-" + end_year +
                "\t\n Grupa : " + vehicle_group +
                "\t\n Link : " + link;

    }
}
