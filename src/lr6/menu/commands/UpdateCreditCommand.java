package lr6.menu.commands;

import lr6.credit.CreditManager;

public class UpdateCreditCommand implements Command {
    private CreditManager creditManager;

    public UpdateCreditCommand(CreditManager creditManager) {
        this.creditManager = creditManager;
    }

    @Override
    public void execute(String params) {
        try {
            String[] tokens = params.split(" ");

            if (tokens.length < 7) {
                System.out.println("Invalid input. Please provide creditID, loanAmount, interestRate, and loanTermMonths for updated credit.");
                return;
            }

            int creditID = Integer.parseInt(tokens[0]);
            String bankName = tokens[1];
            double loanAmount = Double.parseDouble(tokens[2]);
            double interestRate = Double.parseDouble(tokens[3]);
            int loanTermMonths = Integer.parseInt(tokens[4]);
            String earlyRepaymentStr = tokens[5];
            String creditLineIncreaseStr = tokens[6];

            if (!earlyRepaymentStr.equalsIgnoreCase("y") && !earlyRepaymentStr.equalsIgnoreCase("n")) {
                throw new IllegalArgumentException("Invalid value for earlyRepayment. Please provide 'y' or 'n'.");
            }

            if (!creditLineIncreaseStr.equalsIgnoreCase("y") && !creditLineIncreaseStr.equalsIgnoreCase("n")) {
                throw new IllegalArgumentException("Invalid value for creditLineIncrease. Please provide 'y' or 'n'.");
            }

            creditManager.updateCreditDetails(creditID, bankName, loanAmount, interestRate, loanTermMonths,
                    earlyRepaymentStr, creditLineIncreaseStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide valid numeric values for creditID, loanAmount, interestRate, and loanTermMonths.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String getCommandName() {
        return "update";
    }
    public String getCommandDesc() {
        return " - command to update credits in CreditList";
    }

}