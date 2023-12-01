package lr6.credit;

import java.util.ArrayList;
import java.util.List;

public class CreditManager {
    private List<Credit> credits;

    public CreditManager() {
        this.credits = new ArrayList<>();
    }

    public void addCredit(int creditID, String bankName, double loanAmount, double interestRate, int loanTermMonths, String earlyRepaymentStr, String creditLineIncreaseStr) {
        Credit credit = new Credit(creditID, bankName, loanAmount, interestRate, loanTermMonths, earlyRepaymentStr, creditLineIncreaseStr);
        credits.add(credit);
        System.out.println("Credit from " + bankName + " added.");
    }

    public List<Credit> searchCredits(double maxLoanAmount, double maxInterestRate, int maxLoanTermMonths,
                                      boolean allowEarlyRepayment, boolean allowCreditLineIncrease) {
        List<Credit> result = new ArrayList<>();

        for (Credit credit : credits) {
            if (credit.getLoanAmount() <= maxLoanAmount &&
                    credit.getInterestRate() <= maxInterestRate &&
                    credit.getLoanTermMonths() <= maxLoanTermMonths &&
                    (allowEarlyRepayment || !credit.isEarlyRepayment()) &&
                    (allowCreditLineIncrease || !credit.isCreditLineIncrease())) {
                result.add(credit);
            }
        }

        return result;
    }

    public void updateCreditDetails(int creditID, String bankName, double loanAmount, double interestRate,
                                    int loanTermMonths, String earlyRepaymentStr, String creditLineIncreaseStr) {
        Credit creditToUpdate = findCreditById(creditID);
        if (creditToUpdate != null) {
            creditToUpdate.setBankName(bankName);
            creditToUpdate.setLoanAmount(loanAmount);
            creditToUpdate.setInterestRate(interestRate);
            creditToUpdate.setLoanTermMonths(loanTermMonths);
            creditToUpdate.setEarlyRepayment(parseYesNo(earlyRepaymentStr));
            creditToUpdate.setCreditLineIncrease(parseYesNo(creditLineIncreaseStr));
            System.out.println("Credit№" + creditID + " updated.");
        } else {
            System.out.println("Credit№" + creditID + " not found. Unable to update credit.");
        }
    }
    private boolean parseYesNo(String value) {
        return "y".equalsIgnoreCase(value);
    }

    public void deleteCredit(int creditID) {
        Credit creditToDelete = findCreditById(creditID);
        if (creditToDelete != null) {
            credits.remove(creditToDelete);
            System.out.println("Credit№" + creditID + " deleted.");
        } else {
            System.out.println("Credit№" + creditID + " not found. Unable to delete credit.");
        }
    }

    public Credit findCreditById(int creditID) {
        for (Credit credit : credits) {
            if (credit.getCreditID() == creditID) {
                return credit;
            }
        }
        return null;
    }

    public List<Credit> getAllCredits() {
        return credits;
    }
}