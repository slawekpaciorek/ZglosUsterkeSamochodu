package com.infoshareacademy;

import java.util.Scanner;

public class ZUS
{
    private static ZusFactory instruction = ZusFactory.init();

    public static void main( String[] args ) {
        
        Scanner inputReader = new Scanner(System.in);
        private boolean stop = false;

        while(!stop){
            
        String input = "menu";
        String input = instruction.follow(input);

        stop = input.equals("exit");
        
        System.out.println();
        instruction.follow(input);
        System.out.println();
            
    }
}
