package view;

import view.handler.Handler;
import view.printer.Printer;

import java.util.Map;

public class Controller {
    private Map<String, Handler> commands;

    public Controller(Map<String, Handler> commands) {
        this.commands = commands;
    }

    public void handleUserInput(String userInput){
        if (commands.containsKey(userInput)) {
            Handler handler = commands.get(userInput);
            handler.execute();
        } else {
            Printer.printMessage("Command not found");
        }
    }
}
