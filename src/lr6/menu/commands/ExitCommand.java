package lr6.menu.commands;

public class ExitCommand implements Command {
    public String getCommandName() {
        return "exit";
    }

    public void execute(String params) {
        System.out.println("Closing...");
        System.exit(0);
    }
}

