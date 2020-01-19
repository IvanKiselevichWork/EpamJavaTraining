package by.javatr.finance.controller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.general.ExitCommand;
import by.javatr.finance.controller.command.general.WrongRequestCommand;
import by.javatr.finance.controller.command.mainmenu.RegistrationCommand;
import by.javatr.finance.controller.command.mainmenu.ShowMainMenuCommand;
import by.javatr.finance.controller.command.mainmenu.SignInCommand;
import by.javatr.finance.controller.command.usermenu.AddRecordCommand;
import by.javatr.finance.controller.command.usermenu.RemoveRecordCommand;
import by.javatr.finance.controller.command.usermenu.ShowAllUserRecordsCommand;
import by.javatr.finance.controller.command.usermenu.ShowUserMenuCommand;

import java.util.HashMap;

public final class CommandProvider {
    private final HashMap<CommandName, Command> commandMap = new HashMap<>();

    public CommandProvider() {
        commandMap.put(CommandName.EXIT, new ExitCommand());
        commandMap.put(CommandName.SIGN_IN, new SignInCommand());
        commandMap.put(CommandName.REGISTRATION, new RegistrationCommand());
        commandMap.put(CommandName.SHOW_MAIN_MENU, new ShowMainMenuCommand());
        commandMap.put(CommandName.SHOW_USER_MENU, new ShowUserMenuCommand());
        commandMap.put(CommandName.WRONG_REQUEST, new WrongRequestCommand());
        commandMap.put(CommandName.SHOW_ALL_RECORDS, new ShowAllUserRecordsCommand());
        commandMap.put(CommandName.ADD_RECORD, new AddRecordCommand());
        commandMap.put(CommandName.REMOVE_RECORD, new RemoveRecordCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commandMap.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            //todo log
            command = commandMap.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
