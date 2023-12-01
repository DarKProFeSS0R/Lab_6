package lr6.credit;

public class Credit {
    private int creditID;
    private String bankName;
    private double loanAmount;
    private double interestRate;
    private int loanTermMonths;
    private boolean earlyRepayment;
    private boolean creditLineIncrease;

    public Credit(int creditID, String bankName, double loanAmount, double interestRate, int loanTermMonths,
                  String earlyRepaymentStr, String creditLineIncreaseStr) {
        this.creditID = creditID;
        this.bankName = bankName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanTermMonths = loanTermMonths;
        this.earlyRepayment = parseYesNo(earlyRepaymentStr);
        this.creditLineIncrease = parseYesNo(creditLineIncreaseStr);
    }

    private boolean parseYesNo(String value) {
        return "y".equalsIgnoreCase(value);
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(int loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    public boolean isEarlyRepayment() {
        return earlyRepayment;
    }

    public void setEarlyRepayment(boolean earlyRepayment) {
        this.earlyRepayment = earlyRepayment;
    }

    public boolean isCreditLineIncrease() {
        return creditLineIncrease;
    }

    public void setCreditLineIncrease(boolean creditLineIncrease) {
        this.creditLineIncrease = creditLineIncrease;
    }

    @Override
    public String toString() {
        return "Credit№" + creditID +
                ": Bank - " + bankName +
                ", Amount - " + loanAmount +
                ", Interest rate - " + interestRate +
                ", Term - " + loanTermMonths +
                ", Early repayable - " + earlyRepayment +
                ", Credit line increasable - " + creditLineIncrease;
    }
}