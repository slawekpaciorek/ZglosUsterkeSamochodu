package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.infoshareacademy.JSONLoader;

public class SearchEngine {



    public static JsonArray search(String input) throws IOException{

        String linkConst = "http://infoshareacademycom.2find.ru";
        String linkVar =  "/api/v2/";
        String sURL = linkConst + linkVar;

        JsonArray resultArray;
        JsonArray inputArray;


        inputArray = new JSONLoader().showDataArray(sURL);

        JsonObject searchResult = inputArray.stream().filter(x->x.asJsonObject().getString("name").equals(input)).findAny().get().asJsonObject();

        System.out.println("WYszukiwana fraza : " + input);

        //System.out.println("Wynik szukania : " + searchresult);

        linkVar = searchResult.getString("link");

        sURL = linkConst + linkVar;

        resultArray = new JSONLoader().showDataArray(sURL);

        return resultArray;
    }

}
