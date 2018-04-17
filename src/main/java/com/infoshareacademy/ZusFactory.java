package com.infoshareacademy;

import java.util.HashMap;
import java.util.Map;

public class ZusFactory {

    private final Map<String, AppOperator> instruction;


    public static ZusFactory init() {

       ZusFactory command = new ZusFactory();

       command.instruction.put("menu", new Menu());

       return command;
    }
    private ZusFactory() {

        instruction = new HashMap();

    }
    public void follow(String input){
        if(!instruction.containsKey(input)) {
            input = "error";
        }
        instruction.get(input).execute();

    }



}
