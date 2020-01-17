package by.javatr.finance.view;

import by.javatr.finance.view.command.ShowMainMenuViewCommand;
import by.javatr.finance.view.command.ViewCommand;

import java.util.HashMap;

public class ViewCommandProvider {

    private final HashMap<CommandName, ViewCommand> commandMap = new HashMap<>();

    public ViewCommandProvider() {
        commandMap.put(CommandName.SHOW_MAIN_MENU, new ShowMainMenuViewCommand());
    }

    public ViewCommand getCommand(String name) {
        CommandName commandName = null;
        ViewCommand viewCommand = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            viewCommand = commandMap.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            //todo log
            viewCommand = commandMap.get(CommandName.WRONG_REQUEST);
        }
        return viewCommand;
    }
}
