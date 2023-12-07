package lr6.menu;

import lr6.menu.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Executor {
    private List<Command> commands;

    public Executor() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommand(String input) {
        String[] parts = input.split(" ", 2);
        String commandName = parts[0];
        String params = parts.length > 1 ? parts[1] : "";

        for (Command command : commands) {
            if (command.getCommandName().equals(commandName)) {
                command.execute(params);
                return;
            }
        }

        System.out.println("Unknown command: " + commandName);
    }

    public void showHelp() {
        System.out.println("List of commands:");
        for (Command command : commands) {
            System.out.println(command.getCommandName()+command.getCommandDesc());
        }
    }
}