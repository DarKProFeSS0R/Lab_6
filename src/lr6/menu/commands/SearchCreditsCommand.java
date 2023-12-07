package lr6.menu.commands;

import lr6.credit.Credit;
import lr6.credit.CreditManager;

import java.util.List;

public class SearchCreditsCommand implements Command {
    private CreditManager creditManager;

    public SearchCreditsCommand(CreditManager creditManager) {
        this.creditManager = creditManager;
    }

    public String getCommandName() {
        return "search";
    }

    public void execute(String params) {
        try {
            String[] tokens = params.split(" ");

            if (tokens.length != 5) {
                throw new IllegalArgumentException("Invalid input. Please enter expected LoanAmount, InterestRate, LoanTermMonths, EarlyRepayment (y/n), and CreditLineIncrease (y/n).");
            }

            double maxLoanAmount = Double.parseDouble(tokens[0]);
            double maxInterestRate = Double.parseDouble(tokens[1]);
            int maxLoanTermMonths = Integer.parseInt(tokens[2]);
            boolean allowEarlyRepayment = "y".equalsIgnoreCase(tokens[3]);
            boolean allowCreditLineIncrease = "y".equalsIgnoreCase(tokens[4]);

            List<Credit> result = creditManager.searchCredits(
                    maxLoanAmount, maxInterestRate, maxLoanTermMonths,
                    allowEarlyRepayment, allowCreditLineIncrease);

            if (result.isEmpty()) {
                System.out.println("No matching credits found.");
            } else {
                System.out.println("Suitable credits:");
                for (Credit credit : result) {
                    System.out.println(credit.toString());
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide valid numeric values for maxLoanAmount, maxInterestRate, and maxLoanTermMonths.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getCommandDesc() {
        return " - command to search suitable credits in CreditList";
    }

}