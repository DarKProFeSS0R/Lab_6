package lr6.menu.commands;

import lr6.menu.Executor;

public class HelpCommand implements Command {
    private Executor executor;

    public HelpCommand(Executor executor) {
        this.executor = executor;
    }

    public String getCommandName() {
        return "help";
    }

    public String getCommandDescription() {
        return "Display a list of commands and their descriptions.";
    }
    public void execute(String params) {
        executor.showHelp();
    }
}
