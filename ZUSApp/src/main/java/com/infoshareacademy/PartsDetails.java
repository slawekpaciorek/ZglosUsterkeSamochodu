package com.infoshareacademy;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.*;

class PartsDetails {

    private String id;
    private HashMap<String, String> details;
    private ArrayList<HashMap<String, String>> properties;
    private ArrayList<String> pdfURLFile;
    private ArrayList<String> jpgURLFile;
    private ArrayList<String> additionalInfo;

    private ObjectMapper objmap = new ObjectMapper();
    private URL url;
    private JsonNode jsonNode;

    public String getId(String link) throws IOException{
        String id;
        String searchLink = JSONLoader.MAINLINK + link;

        url = new URL(searchLink);
        jsonNode = objmap.readTree(url);

        JsonNode idNode = jsonNode.findPath("data").findPath("part").findPath("id");

        id = idNode.asText();

        return id;
    }
    public HashMap<String, String>getDetails(String link) throws IOException{
        HashMap<String, String> details;
        String searchLink = JSONLoader.MAINLINK + link;
        url = new URL(searchLink);
        jsonNode = objmap.readTree(url);

        JsonNode detailNode = jsonNode.findPath("data").findPath("part").findPath("data");

        details = objmap.convertValue(detailNode, HashMap.class);

        return details;
    }
    public ArrayList<HashMap<String, String>> getProperties(String link) throws IOException{
        ArrayList<HashMap<String,String>> properties = new ArrayList<>();
        String searchLink = JSONLoader.MAINLINK + link;
        url = new URL(searchLink);
        jsonNode = objmap.readTree(url);
        JsonNode propNode = jsonNode.findPath("data").findPath("part").get("properties");

        for (int i = 0; i <propNode.size() ; i++) {
            properties.add(objmap.convertValue(propNode.path(i), HashMap.class));
        }

        return properties;
    }
    public ArrayList<String> getPartData(String link, String dataName) throws IOException{
        ArrayList<String> dataList;
        String searchLink = JSONLoader.MAINLINK + link;
        url = new URL(searchLink);
        jsonNode = objmap.readTree(url);
        JsonNode dataNode = jsonNode.findPath("data").findPath("part").findPath(dataName);

        dataList = objmap.convertValue(dataNode, ArrayList.class);

        return dataList;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PartsDetails{" +
                "id='" + id + '\'' +
                ", details=" + details +
                ", properties=" + properties +
                ", pdfURLFile=" + pdfURLFile +
                ", jpgURLFile=" + jpgURLFile +
                ", additionalInfo=" + additionalInfo +
                '}';
    }
}




