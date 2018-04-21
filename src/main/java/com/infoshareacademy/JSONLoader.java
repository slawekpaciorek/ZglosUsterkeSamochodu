package com.infoshareacademy;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Objects;

import javax.json.JsonObject;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

public class JSONLoader {

    public String jsonObjectName;

    public static String MAINLINK = "http://infoshareacademycom.2find.ru";
    public static String SUBLINK = "/api/v2";


    public String sURL;
    public String data;
    public ArrayList dataContent;

    public String showDataType(String sURL) throws IOException {
        //sURL = "http://infoshareacademycom.2find.ru/api/v2";
        URL url = new URL(sURL);

        InputStream is =  url.openStream();
        JsonReader rdr = Json.createReader(is);
        JsonObject jsonObject = rdr.readObject();

        return data = jsonObject.getString("datatype");

    }

    public ArrayList showDataArray(String sURL) throws IOException {
        //sURL = "http://infoshareacademycom.2find.ru/api/v2/";

        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonReader jsonReader = Json.createReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObject = jsonReader.readObject();

        JsonArray jsonArray = (JsonArray) jsonObject.get("data");

        ArrayList<String> jsonList = new ArrayList<String>();
        if (jsonArray != null) {
            int len = jsonArray.size();
            for (int i=0;i<len;i++){
                jsonList.add(jsonArray.get(i).toString());
            }
        }

        return dataContent = jsonList;

    }



    @Override
    public String toString() {
        return "Data : " +  data +
                "\n" + data + " : " + dataContent;


    }
}
