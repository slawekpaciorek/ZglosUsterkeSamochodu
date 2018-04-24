package com.infoshareacademy;

import javax.json.JsonArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchOperator implements AppOperator  {

    Scanner inputReader = new Scanner(System.in);
    JSONLoader jsonLoader = new JSONLoader();
    String input;
    boolean inputValidation = false;

    @Override
    public void execute() {

        List<Brands> brandsList = null;
        try {
            brandsList = new BrandsList().getBrandsList();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(brandsList);

        List brandsNames = null;

        try {
            brandsNames = new BrandsList().brandsNames;
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(brandsNames);

        String brandsNameForEachLetter = null;

        try {
            brandsNameForEachLetter = new BrandsList().brandsNameForEachLetter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(brandsNameForEachLetter);

        System.out.print("Aby zobaczyć listę dosętpnych pojazdów wpisz 'lista' : ");

        try {
            jsonLoader.data = jsonLoader.showDataType(JSONLoader.MAINLINK + JSONLoader.SUBLINK);
            jsonLoader.dataContent = jsonLoader.showDataArray(JSONLoader.MAINLINK + JSONLoader.SUBLINK);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        while (!inputValidation) {
            input = inputReader.next();
            System.out.println();
            if (input.equals("lista")) {
                System.out.println(jsonLoader.toString());
                inputValidation = true;
            } else
                System.out.println("Wprowadz poprawnie komendę");
        }

        inputValidation = false;

        System.out.println();
        System.out.print("Aby wybrać interesujący cię pojazd wpisz nazwę marki pojazdu : ");

        try {
            input = inputReader.next();
            JsonArray jsonArray = jsonLoader.showDataArray(JSONLoader.MAINLINK + JSONLoader.SUBLINK);
            JsonArray modelsList = SearchEngine.search(input);
            System.out.println(modelsList);
            inputValidation = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println();
        System.out.println("Wybierz model pojazdu : ");
        System.out.println();
        System.out.println();
    }
}
