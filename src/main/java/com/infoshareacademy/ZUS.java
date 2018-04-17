package com.infoshareacademy;

import java.util.Scanner;

public class ZUS
{
    private static ZusFactory instruction = ZusFactory.init();

    public static void main( String[] args ) {

        String input = "menu";
        instruction.follow(input);

    }
}
