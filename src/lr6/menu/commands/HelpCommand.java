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

    public void execute(String params) {
        executor.showHelp();
    }
    @Override
    public String getCommandDesc() {
        return " - command to display list of commands";
    }
}
