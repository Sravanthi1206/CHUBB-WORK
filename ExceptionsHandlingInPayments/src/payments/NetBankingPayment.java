package payments;

import exceptions.*;

public class NetBankingPayment extends Payment {

    public NetBankingPayment(double amount, String beneficiary) {
        super(amount, beneficiary);
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (beneficiary == null || beneficiary.isEmpty())
                throw new BeneficiaryNotFoundException("Beneficiary not found");

            if (Math.random() < 0.3)
                throw new PaymentGatewayTimeoutException("Payment gateway timeout");

            if (Math.random() < 0.2)
                throw new InvalidCredentialsException("Bank password invalid");

            System.out.println("NetBanking payment of Rs " + amount + " to " + beneficiary + " processed successfully.");
        } catch (Exception e) {
            throw new TransactionFailedException("NetBanking transaction failed", e);
        }
    }
}
