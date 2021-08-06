package view.home.user_info.handlers;

import model.Address;
import service.UserService;
import view.handler.Handler;
import view.printer.Printer;

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
        Printer.printMessage("Enter your street name: ");
        String streetName = scanner.nextLine();
        Printer.printMessage("Enter your city: ");
        String city = scanner.nextLine();
        Printer.printMessage("Enter your postal code: ");
        int postalCode = scanner.nextInt();
        scanner.nextLine();
        Printer.printMessage("Enter your country: ");
        String country = scanner.nextLine();
        Address address = new Address(streetName,city,postalCode,country);
        userService.updateUserAddress(address);
    }
}
