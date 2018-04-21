package com.infoshareacademy;

import java.util.HashMap;
import java.util.Map;

public class ZusFactory {

    private final Map<String, AppOperator> instruction;


    public static ZusFactory init() {

       ZusFactory command = new ZusFactory();

        command.instruction.put("menu", new Menu());
//        command.instruction.put("display-c", new Brands());
//        command.instruction.put("start", );

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
