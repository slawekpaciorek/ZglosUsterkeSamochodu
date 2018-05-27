package com.infoshareacademy;

import java.io.IOException;
import java.util.Scanner;

public class ZUS {
    private static ZusFactory instruction = ZusFactory.init();

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        boolean stop = false;
        boolean inputValidation = false;
        String input = null;

        while (!stop) {

            instruction.follow("menu");

            while(!inputValidation) {

                System.out.print("\nWpisz polecenie (wpisz lub wybierz numer) : ");
                input = inputReader.next();

                if (input.equals("1")||input.equals("display-c")){
                    input = "display-c";
                    inputValidation = true;}
                else if (input.equals("2")||input.equals("start")){
                    input = "start";
                    inputValidation = true;}
                else if (input.equals("3")||input.equals("manual")){
                    input = "manual";
                    inputValidation = true;}
                else{
                    System.out.println("\nWprowadz poprawna komende.");
                }
            }
            inputValidation = false;
            stop = input.equals("exit");

            System.out.println();
            instruction.follow(input);
            System.out.println();


        }

        inputReader.close();

    }
}
