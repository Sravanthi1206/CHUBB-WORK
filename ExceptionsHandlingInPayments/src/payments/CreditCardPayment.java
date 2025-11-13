package payments;

import exceptions.*;

public class CreditCardPayment extends Payment {

    public CreditCardPayment(double amount, String beneficiary) {
        super(amount, beneficiary);
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (beneficiary == null || beneficiary.isEmpty())
                throw new BeneficiaryNotFoundException("Beneficiary not found");

            if (amount <= 0)
                throw new InvalidAmountException("Amount must be greater than zero");

            if (amount > 50000)
                throw new InsufficientBalanceException("Credit limit exceeded");

            System.out.println("Credit Card payment of Rs " + amount + " to " + beneficiary + " processed successfully.");
        } catch (Exception e) {
            throw new TransactionFailedException("Credit Card transaction failed", e);
        }
    }
}
