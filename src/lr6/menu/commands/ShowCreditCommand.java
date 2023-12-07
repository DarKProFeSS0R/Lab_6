package lr6.menu.commands;

import lr6.credit.Credit;
import lr6.credit.CreditManager;

public class ShowCreditCommand implements Command {
    private CreditManager creditManager;

    public ShowCreditCommand(CreditManager creditManager) {
        this.creditManager = creditManager;
    }

    @Override
    public void execute(String params) {
        if ("all".equalsIgnoreCase(params)) {
            for (Credit credit : creditManager.getAllCredits()) {
                System.out.println(credit.toString());
            }
        } else {
            try {
                int creditID = Integer.parseInt(params);
                Credit credit = creditManager.findCreditById(creditID);

                if (credit != null) {
                    System.out.println(credit.toString());
                } else {
                    System.out.println("Credit with ID " + creditID + " not found.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide 'all' or a valid integer ID.");
            }
        }
    }

    @Override
    public String getCommandName() {
        return "show";
    }
    @Override
    public String getCommandDesc() {
        return " - command to show credits from CreditList";
    }
}