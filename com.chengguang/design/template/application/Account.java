package design.template.application;

public abstract class Account {
    public final double calculateInterest() {
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType);
        return amount * interestRate;
    }

    private double calculateAmount(String accountType) {
        return 7243.00d;
    }

    protected abstract String doCalculateAccountType();

    protected abstract double doCalculateInterestRate();

}
