package com.infoshareacademy;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

class PartsDetails {

    private String id;
    private HashMap<String, String> details;
    private Optional<ArrayList<HashMap<String, String>>> properties;
    private Optional<ArrayList<String>> pdfURLFile;
    private Optional<ArrayList<String>> jpgURLFile;
    private Optional<ArrayList<String>> additionalInfo;


}
