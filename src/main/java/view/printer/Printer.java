package view.printer;

import model.Product;

import java.util.List;

public final class Printer {
    private Printer(){ }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printSeparation(){
        printMessage("-------------------------------");
    }

    public static void printLogInMenu(){
        printMessage("Welcome to Jogurtowska Shop");
        printMessage("1 - Login");
        printMessage("2 - Register");
        printMessage("0 - exit");
    }

    public static void printMainMenu(){
        printMessage("-----Main Menu-----");
        printMessage("1 - Edit user info");
        printMessage("2 - Manage my products");
        printMessage("3 - Go to shop");
        printMessage("4 - Print bought products");
        printMessage("0 - Log out");
    }

    public static void printProductArray(List<Product> productArr){
        int index = 0;
        for(Product product : productArr){
            index++;
            System.out.printf(index+". "+product.getName());
            printMessage("Price: " + product.getPrice());
            printMessage("Description: " + product.getDescription());
            printSeparation();
        }
    }

    public static void printWarning(){
        printMessage("------------WARNING------------");
        printMessage("This action cannot be undone.");
        printSeparation();
    }
}
