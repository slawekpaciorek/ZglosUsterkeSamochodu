package com.infoshareacademy;

import com.infoshareacademy.functions.JSONLoader;

import java.io.IOException;
import java.util.ArrayList;


public class ZUS
{


    public static void main( String[] args ) {




        System.out.println( "Witam w aplikacji do zgłaszania usterek twojego samochodu." );


        Brands brands = new Brands();
        ArrayList brandsList = brands.getBrands();

        JSONLoader jsonLoader = new JSONLoader();





        try {
            if(jsonLoader.showDataArray() != null){
                for(int i = 0; i < jsonLoader.showDataArray().size(); i++)
                {
                    brandsList.add(jsonLoader.showDataArray().getJsonObject(i));
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        System.out.println(brandsList);
    }
}
