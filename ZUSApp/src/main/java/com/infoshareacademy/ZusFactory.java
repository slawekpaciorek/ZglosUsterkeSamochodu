package com.infoshareacademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZusFactory {

    private final Map<String, AppOperator> instruction;


    public static ZusFactory init() {

       ZusFactory command = new ZusFactory();

        command.instruction.put("menu", new Menu());
        command.instruction.put("display-c", ()-> {
            try {
                System.out.println(new BrandsList().brandsNameForEachLetter());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        command.instruction.put("start", new SearchOperator());
        command.instruction.put("exit", ()-> System.out.println("Dziękujemy za skorzytsanie z aplikacji"));

       return command;
    }

    ZusFactory() {
        instruction = new HashMap();
    }

    public void follow(String input){
        if(!instruction.containsKey(input)) {
            input = "error";
        }
        instruction.get(input).execute();

    }



}
