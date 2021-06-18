package view.home.handlers;

import model.Address;
import service.UserService;
import view.handler.Handler;

import java.util.Scanner;

public class AddressHandler implements Handler {
    private UserService userService;
    private Scanner scanner;

    public AddressHandler(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute(){
        System.out.println("Enter your street name: ");
        String streetName = scanner.nextLine();
        System.out.println("Enter your city: ");
        String city = scanner.nextLine();
        System.out.println("Enter your postal code: ");
        int postalCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your country: ");
        String country = scanner.nextLine();
        Address address = new Address(streetName,city,postalCode,country);
        userService.updateUserAddress(address);
    }
}
