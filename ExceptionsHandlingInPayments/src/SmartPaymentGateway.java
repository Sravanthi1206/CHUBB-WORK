import java.util.*;
import payments.*;
import exceptions.*;

public class SmartPaymentGateway {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> transactionHistory = new ArrayList<>();

        // Beneficiaries as objects
        List<Beneficiary> beneficiaries = new ArrayList<>();
        beneficiaries.add(new Beneficiary("Rahul", "ACC001"));
        beneficiaries.add(new Beneficiary("Anjali", "ACC002"));

        System.out.println("----- Smart Payment Gateway System -----");

        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nSelect Operation:");
            System.out.println("1. Make a Payment");
            System.out.println("2. View Transaction History");
            System.out.println("3. Add Beneficiaries");
            System.out.println("4. View Beneficiaries");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int operation = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (operation) {
                case 1: // Payment
                    try {
                        System.out.println("\nSelect Payment Method:");
                        System.out.println("1. Credit Card");
                        System.out.println("2. UPI");
                        System.out.println("3. Wallet");
                        System.out.println("4. NetBanking");
                        System.out.print("Enter choice: ");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter beneficiary name: ");
                        String beneficiaryName = sc.nextLine();

                        // Find beneficiary object
                        Beneficiary beneficiary = null;
                        for (Beneficiary b : beneficiaries) {
                            if (b.getName().equalsIgnoreCase(beneficiaryName)) {
                                beneficiary = b;
                                break;
                            }
                        }
                        if (beneficiary == null)
                            throw new BeneficiaryNotFoundException("Beneficiary " + beneficiaryName + " not found");

                        Payment payment = null;
                        switch (choice) {
                            case 1:
                                payment = new CreditCardPayment(amount, beneficiary.getName());
                                break;
                            case 2:
                                payment = new UPIPayment(amount, beneficiary.getName());
                                break;
                            case 3:
                                payment = new WalletPayment(amount, beneficiary.getName(), 100); // example balance
                                break;
                            case 4:
                                payment = new NetBankingPayment(amount, beneficiary.getName());
                                break;
                            default:
                                System.out.println("Invalid payment choice.");
                                continue;
                        }

                        payment.processPayment();
                        transactionHistory.add("Paid Rs " + amount + " to " + beneficiary + " via " +
                                payment.getClass().getSimpleName());

                    } catch (TransactionFailedException e) {
                        System.out.println("Transaction failed: " + e.getCause().getMessage());
                    } catch (BeneficiaryNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Unexpected error: " + e.getMessage());
                    }
                    break;

                case 2: // Transaction history
                    System.out.println("\n--- Transaction History ---");
                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String record : transactionHistory) {
                            System.out.println(record);
                        }
                    }
                    break;

                case 3: // Add multiple beneficiaries
                    System.out.print("How many beneficiaries do you want to add? ");
                    int count = sc.nextInt();
                    sc.nextLine(); // consume newline
                    for (int i = 1; i <= count; i++) {
                        System.out.print("Enter name of beneficiary " + i + ": ");
                        String name = sc.nextLine();
                        System.out.print("Enter account number of " + name + ": ");
                        String accNo = sc.nextLine();
                        beneficiaries.add(new Beneficiary(name, accNo));
                        System.out.println("Beneficiary " + name + " added successfully.");
                    }
                    break;

                case 4: // View beneficiaries
                    System.out.println("\n--- Beneficiary List ---");
                    for (Beneficiary b : beneficiaries) {
                        System.out.println(b);
                    }
                    break;

                case 5: // Exit
                    continueOperations = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }

        System.out.println("\nThank you for using Smart Payment Gateway.");
        sc.close();
    }
}
