package lr6.menu.commands;

import lr6.credit.CreditManager;

public class DeleteCreditCommand implements Command {
    private CreditManager creditManager;

    public DeleteCreditCommand(CreditManager creditManager) {
        this.creditManager = creditManager;
    }

    @Override
    public void execute(String params) {
        try {
            int creditID = Integer.parseInt(params);
            creditManager.deleteCredit(creditID);
        } catch (NumberFormatException e) {
            System.out.println("Invalid credit ID. Please provide a valid integer.");
        }
    }

    @Override
    public String getCommandName() {
        return "delete";
    }
    @Override
    public String getCommandDesc() {
        return " - command to delete credits from CreditList";
    }
}