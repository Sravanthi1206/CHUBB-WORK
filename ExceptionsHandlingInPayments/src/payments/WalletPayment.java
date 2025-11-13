package payments;

import exceptions.*;

public class WalletPayment extends Payment {

    private double walletBalance;

    public WalletPayment(double amount, String beneficiary, double walletBalance) {
        super(amount, beneficiary);
        this.walletBalance = walletBalance;
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (beneficiary == null || beneficiary.isEmpty())
                throw new BeneficiaryNotFoundException("Beneficiary not found");

            if (amount > walletBalance)
                throw new InsufficientBalanceException("Insufficient wallet balance. Please recharge or choose another method.");

            System.out.println("Wallet payment of Rs " + amount + " to " + beneficiary + " processed successfully.");
            walletBalance -= amount;
        } catch (Exception e) {
            throw new TransactionFailedException("Wallet transaction failed", e);
        }
    }
}
