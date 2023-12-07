package lr6.menu.commands;

public interface Command {
    String getCommandName();
    void execute(String params);

    String getCommandDesc();
}