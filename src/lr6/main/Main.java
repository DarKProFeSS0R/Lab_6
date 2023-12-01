package lr6.main;

import lr6.credit.CreditManager;
import lr6.menu.Executor;
import lr6.menu.commands.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreditManager creditManager = new CreditManager();
        Executor executor = new Executor();
        Scanner scanner = new Scanner(System.in);

        executor.addCommand(new HelpCommand(executor));
        executor.addCommand(new ShowCreditCommand(creditManager));
        executor.addCommand(new AddCreditCommand(creditManager));
        executor.addCommand(new SearchCreditsCommand(creditManager));
        executor.addCommand(new UpdateCreditCommand(creditManager));
        executor.addCommand(new DeleteCreditCommand(creditManager));
        executor.addCommand(new ExitCommand());

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            executor.executeCommand(input);
        }
    }
}