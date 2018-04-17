package com.infoshareacademy;



import javax.json.JsonArray;
import java.io.IOException;
import java.util.Scanner;


public class ZUS {


    public static void main( String[] args ) throws IOException {

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Witamy w aplikacji , wybierz model samochodu");

        JSONLoader jsonLoader = new JSONLoader();

        String sURL = "http://infoshareacademycom.2find.ru/api/v2";

        jsonLoader.showDataType(sURL);
        jsonLoader.showDataArray(sURL);

        System.out.println(jsonLoader.toString());

        System.out.print("Wpisz nazwę marki : ");

        String input = inputReader.next();

       JsonArray models = SerchEngine.search(input);

        System.out.println(models);
    }
}
