package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrandsList {

    public List<Brands> brandsList = new ArrayList<Brands>();

    public BrandsList() throws IOException {
    }

    public List<Brands> getBrandsList() throws IOException {
        JsonArray jsonArray = new JSONLoader().showDataArray(JSONLoader.MAINLINK + JSONLoader.SUBLINK);


        for (int i = 0; i < jsonArray.size(); i++) {

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

    public List<String> brandsNames = getBrandsList().stream().map(Brands::getName).collect(Collectors.toList());

    public String brandsNameForEachLetter(){

        return "A : " + selectLetter("A") +
        "\nB : " + selectLetter("B") +
        "\nC : " + selectLetter("C") +
        "\nD : " + selectLetter("D") +
        "\nE : " + selectLetter("E") +
        "\nF : " + selectLetter("F") +
        "\nG : " + selectLetter("G") +
        "\nH : " + selectLetter("H") +
        "\nI : " + selectLetter("I") +
        "\nJ : " + selectLetter("J") +
        "\nK : " + selectLetter("K") +
        "\nL : " + selectLetter("L") +
        "\nM : " + selectLetter("M") +
        "\nN : " + selectLetter("N") +
        "\nO : " + selectLetter("O") +
        "\nP : " + selectLetter("P") +
        "\nR : " + selectLetter("R") +
        "\nS : " + selectLetter("S") +
        "\nT : " + selectLetter("T") +
        "\nU : " + selectLetter("U") +
        "\nW : " + selectLetter("W") +
        "\nX : " + selectLetter("X") +
        "\nY : " + selectLetter("Y") +
        "\nZ : " + selectLetter("Z") ;

    }

    public List<Brands> selectLetter(String input){

        List names = brandsNames.stream().filter(x->x.startsWith(input)).collect(Collectors.toList());

        return names;
    }




}