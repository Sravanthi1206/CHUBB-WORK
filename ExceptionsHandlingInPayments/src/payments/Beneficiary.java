package payments;

public class Beneficiary {
    private String name;
    private String accountNumber;

    public Beneficiary(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return name + " (" + accountNumber + ")";
    }
}
