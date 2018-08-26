package com.infoshareacademy;

import java.net.URL;
import java.time.LocalDateTime;

public class Models extends Brands {

    private String id;
    private String name;
    private int end_year;
    private int end_month;
    private int start_year;
    private int start_month;
    private String vehicle_group;
    private String link;

    public Models(){

    }

    public Models(String id, String name, int end_year, int end_month, int start_year, int start_month, String vehicle_group, String link){
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
                "\t\n Zakończenie produkcji : " + endDateProduction() +
                "\t\n Grupa : " + vehicle_group +
                "\t\n Link : " + link;

    }

    public String endDateProduction(){

        String endDateProduction = new String();

        if(end_year == 0 && end_month == 0)
            endDateProduction = "in production";
        else
            endDateProduction = end_month + "-" + end_year;

        return endDateProduction;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnd_year() {
        return end_year;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public int getEnd_month() {
        return end_month;
    }

    public void setEnd_month(int end_month) {
        this.end_month = end_month;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public int getStart_month() {
        return start_month;
    }

    public void setStart_month(int start_month) {
        this.start_month = start_month;
    }

    public String getVehicle_group() {
        return vehicle_group;
    }

    public void setVehicle_group(String vehicle_group) {
        this.vehicle_group = vehicle_group;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
