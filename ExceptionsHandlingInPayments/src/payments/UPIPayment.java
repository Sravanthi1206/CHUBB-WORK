package payments;

import exceptions.*;

public class UPIPayment extends Payment {

    public UPIPayment(double amount, String beneficiary) {
        super(amount, beneficiary);
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (beneficiary == null || beneficiary.isEmpty())
                throw new BeneficiaryNotFoundException("Beneficiary not found");

            if (amount <= 0)
                throw new InvalidAmountException("Invalid UPI amount");

            if (Math.random() < 0.2) // simulate invalid credentials
                throw new InvalidCredentialsException("UPI PIN invalid");

            System.out.println("UPI payment of Rs " + amount + " to " + beneficiary + " processed successfully.");
        } catch (Exception e) {
            throw new TransactionFailedException("UPI transaction failed", e);
        }
    }
}
