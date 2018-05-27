package com.infoshareacademy;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class SearchOperator implements AppOperator  {

    Scanner inputReader = new Scanner(System.in);
    JSONLoader jsonLoader = new JSONLoader();
    String input;
    boolean inputValidation = false;

    @Override
    public void execute() {

/*
    WYBÓR MARKI POJAZDU

*/
        List<Brands> listOfBrands = null;
        Brands brand = new Brands();
        BrandsList brandsList = null;

        try {
            brandsList = new BrandsList();
            listOfBrands = brandsList.getBrandsList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n-------------------------Wybor marki pojazdu-------------------------\n");

        System.out.println("Wybierz markę pojazdu, postępuj wg wskazówek");
        System.out.println("\t1. Możesz wpisać markę pojazdu- wpisz markę pojazdu np. 'Renault'");
        System.out.println("\t2. Możesz wpisać literę aby sprawdzić dostępne modele - wpisz literę, np 'a' ");
        System.out.println("\t3. Możesz wyświetlić wszystkie dostęone marki - wpisz 'all' ");


        while (!inputValidation) {
            System.out.print("\nWpisz wybraną komendę (wpisz komende) : ");
            input = returnInput().toUpperCase();
            System.out.println();

            if (brandsList.brandsNames.contains(input)) {
                brand = listOfBrands.stream().filter(x -> x.getName().equals(input)).findAny().get();
                System.out.println("Wybrana marka pojazdu to : " + brand.getName().toUpperCase());
                inputValidation = true;

            } else if (input.length() == 1) {
                String brandForLetter = input.toUpperCase() + " : " + brandsList.selectLetter(input);
                System.out.println(brandForLetter);
                System.out.println();
                brand = chooseFromList(listOfBrands, brand);
                inputValidation = true;

            } else if (input.toLowerCase().equals("all")) {
                System.out.println(brandsList.brandsNameForEachLetter());
                System.out.println();
                brand = chooseFromList(listOfBrands, brand);
                inputValidation = true;
            } else
                System.out.println("Wybierz poprawnie komendę");
        }

        inputValidation = false;

        System.out.print("\nCzy chcesz zobaczyć szczegóły wybranego rekordu, wpisz 'yes' lub 'no' : ");
        input = inputReader.next();
        System.out.println();

        if (input.equals("yes"))
            System.out.println(brand.toString());
        else
            System.out.println("Lista dosępnych modeli znajduje się poniżej.");
        System.out.println();

        String link = brand.getLink();
        List<Models> modelsListNames = new ArrayList<>();

        try {
            modelsListNames = new ModelsList().getModelsListNames(link);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(modelsListNames);

/*
    WYBÓR MODELU

*/
        System.out.println("\n-------------------------Wybor modelu-------------------------\n");

        Models model = new Models();
        List<Models> listOfModels = null;
        ModelsList modelList = null;


        try {
            modelList = new ModelsList();
            listOfModels = modelList.getModelsList(link);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!inputValidation) {

            System.out.print("Wybierz interesujacy Cie model : ");
            input = returnInput().trim().toLowerCase();
            System.out.println();
            List<String> modelsNamesList = listOfModels.stream().map(x->x.getName().toLowerCase().trim()).collect(Collectors.toList());

            if (modelsNamesList.contains(input)) {
                model = listOfModels.stream().filter(x -> x.getName().trim().toLowerCase().equals(input)).findAny().get();
                System.out.println();
                System.out.print("Wybrany przez Ciebie model to : " + brand.getName() + " " + model.getName() + ". " +
                        "\n\nJesli interesuja cie dodtakowe informacje wpisz 'more' lub 'forward' aby kontynuowac : ");

                String inputInIf = inputReader.next();

                if (inputInIf.equals("more")) {
                    System.out.println(model.toString());
                    inputValidation = true;
                }
                else if(inputInIf.equals("forward")){
                    System.out.println("\nPrzechodzisz do modulu wybierania rocznika.");
                    inputValidation = true;
                }

            } else
                System.out.println("\nWprowadzona nazwa nie jest prawidlowa.\n");
        }


        inputValidation = false;

/*
    WYBÓR ROCZNIKA

*/
        System.out.println("\n-------------------------Wybor rocznika-------------------------\n");

        System.out.println("Wybierz rocznik twojego pojazdu");
        System.out.print("\nPodaj rok : ");
        int usrVehicleYear = 0;
        int usrVehicleMonth = 0;

        while (!inputValidation) {

            usrVehicleYear = Integer.parseInt(inputReader.next());

            if(model.getEnd_year() > 0) {

                if (usrVehicleYear >= model.getStart_year() &&
                        usrVehicleYear <= model.getEnd_year()) {

                    inputValidation = true;

                }
                else if (usrVehicleYear < model.getStart_year()) {

                    System.out.print("Wybrany rok jest za niski, podaj rok produkcji auta jeszcze raz : ");

                }
                else if (usrVehicleYear > model.getEnd_year()){

                    System.out.print("Wybrany rok jest za wysoki, podaj rok produkcji auta jeszcze raz : ");

                }
            }
            else{

                    if(usrVehicleYear >= model.getStart_year() && usrVehicleYear <= LocalDate.now().getYear())
                    {
                        inputValidation = true;
                    }

                    else if (usrVehicleYear < model.getStart_year()) {

                        System.out.print("Wybrany rok jest za niski, podaj rok produkcji auta jeszcze raz : ");

                    }
                    else if (usrVehicleYear > model.getEnd_year()){

                        System.out.print("Wybrany rok jest za wysoki, podaj rok produkcji auta jeszcze raz : ");

                    }

                }
        }

        inputValidation = false;

        System.out.print("\nPodaj miesiac : ");

        while (!inputValidation) {

            usrVehicleMonth = Integer.parseInt(inputReader.next());

            if(usrVehicleYear == model.getStart_year()) {

                if (usrVehicleMonth >= model.getStart_month() && usrVehicleMonth <= 12)
                    inputValidation = true;
                else
                    System.out.print("Wpisz prawidlowy miesiac prdukcji auta : ");
            }
            else if(usrVehicleYear == model.getEnd_year()){

                if((usrVehicleMonth < LocalDate.now().getMonth().getValue()) && usrVehicleMonth > 0){

                    inputValidation = true;

                }
                else
                    System.out.print("Wpisz prawidlowy miesiac prdukcji auta : ");
            }
            else{
                if(usrVehicleMonth > 0 && usrVehicleMonth <= 12){
                    inputValidation = true;
                }
                else
                    System.out.print("Wpisz prawidlowy miesiac prdukcji auta : ");
            }

        }

        System.out.println("Data produkcji twojego auta to : " + usrVehicleMonth + "-" + usrVehicleYear);



/*
    WYBÓR NADWOZIA

*/
        System.out.println("\n-------------------------Wybor wersji i nadwozia-------------------------\n");

        List<ModelDetails> detailsList = new ArrayList<>();
        ModelDetails version = null;
        inputValidation = false;

        try {

            detailsList = new ModelDetailList().getModelDetails(model.getLink());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        List<String> possibleVersions = detailsList.stream().map(ModelDetails::getName).distinct().collect(Collectors.toList());

        System.out.println("Lista dostepnych wersji pojazdu : " + possibleVersions);

        List<String> possibleBody = detailsList.stream().map(ModelDetails::getBody).distinct().collect(Collectors.toList());

        System.out.println("Lista dostepnych wersji nadwozia : " + possibleBody);

        System.out.print("\nWybierz ineresujaca cie wersje pojazdu: ");

        while (!inputValidation) {

            input = returnInput().toLowerCase();
            List<String> possibleVersionsLowerCase = possibleVersions.stream().map(String::toLowerCase).collect(Collectors.toList());
            System.out.println();

            if (possibleVersionsLowerCase.contains(input)) {


                version = detailsList.stream().filter(x -> x.getName().toLowerCase().equals(input)).findAny().get();
                inputValidation = true;
            } else
                System.out.print("Wybrales bledna wersje pojazdu, wpisz poprawna nazwe wersji : ");

        }
        System.out.println("\nWybrales nasepujacy pojazd : " + brand.getName() + " " + model.getName() + " "
                + version.getName() + ", rok produkcji : " + usrVehicleYear + ".");


/*
    WYBÓR KATEGORII CZĘŚCI

*/
        System.out.println("\n-------------------------Wybor kategorii dla czesci-------------------------\n");

        System.out.println("Ponizej znajduje sie lista kategori czesci dla wybranego pojazd :");

        List<Category> partsCategories = null;
        String sublink = version.getLink();

        try {
            partsCategories = new PartsCategory().getPartsCategory(sublink);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> categoriesNames = partsCategories.stream().map(Category::getName).collect(Collectors.toList());
        System.out.println(categoriesNames.toString());

        System.out.print("\nWprowadz nazwe kategori : ");
        input = returnInput().toLowerCase();
        Category category = new Category();
        List<Category> partsSubList = new ArrayList<>();
        List<String> subCategoryNames = new ArrayList();
        Category subCategory = null;
        List<String> categoriesNamesLowerCase = categoriesNames.stream().map(String::toLowerCase).collect(Collectors.toList());

        if (categoriesNamesLowerCase.contains(input)) {

            category = partsCategories.stream()
                    .filter(x -> x.getName().toLowerCase().equals(input)).findAny().get();

            try {
                partsSubList = new PartsCategory().partsCategorySubList(category.getLink());
            } catch (IOException e) {
                e.printStackTrace();
            }
            subCategoryNames = partsSubList.stream().map(Category::getName).collect(Collectors.toList());
            System.out.println("\nWybierz podkategorie z listy ponizej : \n" + partsSubList.toString());
        }
        else {

            System.out.println("Wprowadziles bledna nazwe, nie ma takiej kategorii");

        }

        List <String> subCategoryNamesLowerCase = subCategoryNames.stream().map(String::toLowerCase).collect(Collectors.toList());
        inputValidation = false;

        while (!inputValidation) {

            System.out.print("\nWprowadz nazwe podkategori :");
            input = returnInput().toLowerCase();
            subCategory = partsSubList.stream().filter(x -> x.getName().toLowerCase().equals(input)).findAny().get();

            if (subCategoryNamesLowerCase.contains(input) && subCategory.getSublist()) {

                try {
                    partsSubList = new PartsCategory().partsCategorySubList(subCategory.getLink());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                subCategoryNames = partsSubList.stream().map(Category::getName).collect(Collectors.toList());

                System.out.println(partsSubList.toString());

            }
            else if(!subCategoryNamesLowerCase.contains(input)){
                System.out.println("\nWprowadz poprawna nazwe kategorii");
            }
            else {
                System.out.println("\nPrzechodzisz do modulu wybierania czesci.");
                inputValidation = true;
            }
            
            subCategoryNames = partsSubList.stream().map(Category::getName).collect(Collectors.toList());
            subCategoryNamesLowerCase = subCategoryNames.stream().map(String::toLowerCase).collect(Collectors.toList());

        }

        inputValidation = false;

/*
    WYBÓR CZĘŚCI

*/
        System.out.println("\n-------------------------Wybor czesci-------------------------\n");
        link = subCategory.getLink();
        List<Stock> stockList = new ArrayList<>();

        try {
            stockList = new PartsCategory().getStockList(link);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nLista czesci dla kategorii " + subCategory.getName() + " : " + stockList.toString());
/*
    WYBÓR POZIOMU JAKOŚCI

*/
    }

    public Brands chooseFromList(List<Brands> listOfBrands, Brands brand){


        System.out.print("Wybierz markę z pośród wyświetlonej listy : ");
        String inputIn = inputReader.next().toUpperCase();
        brand = listOfBrands.stream().filter(x -> x.getName().equals(inputIn)).findAny().get();
        System.out.println("Wybrana marka pojazdu to : " + brand.getName().toUpperCase());

        return brand;

    }

    public String returnInput(){
        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();


        return input;


    }


}
