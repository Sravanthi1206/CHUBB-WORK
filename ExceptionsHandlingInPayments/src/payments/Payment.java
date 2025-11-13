package payments;

import exceptions.TransactionFailedException;

public abstract class Payment {
    protected double amount;
    protected String beneficiary;

    public Payment(double amount, String beneficiary) {
        this.amount = amount;
        this.beneficiary = beneficiary;
    }

    public abstract void processPayment() throws TransactionFailedException;
}
