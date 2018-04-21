package com.infoshareacademy;

import java.io.IOException;
import java.util.Scanner;

public class ZUS {
    private static ZusFactory instruction = ZusFactory.init();

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        boolean stop = false;

        while (!stop) {

            instruction.follow("menu");

            System.out.print("Wpisz polecenie : ");
            String input = inputReader.next();

            stop = input.equals("exit");

            System.out.println();
            instruction.follow(input);
            System.out.println();


        }

        inputReader.close();

    }
}
