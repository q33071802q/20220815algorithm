package design.template.application;

public class CDAccount extends Account{
    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.04d;
    }
}
