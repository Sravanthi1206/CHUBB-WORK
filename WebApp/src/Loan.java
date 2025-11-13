class Loan {
    double amount;
    double rate;
    int years;
    double downPayment;

    Loan(double amount, double rate, int years, double downPayment) {
        this.amount = amount;
        this.rate = rate;
        this.years = years;
        this.downPayment = downPayment;
    }

    // Simple Interest total
    double simpleTotalAmount() {
        double principal = amount - downPayment;
        double interest = (principal * rate * years) / 100;
        return principal + interest;
    }

    // Compound Interest total
    double compoundTotalAmount() {
        double principal = amount - downPayment;
        return principal * Math.pow((1 + (rate / 100.0)), years);
    }

    // EMI based on type
    double emi(String type) {
        int months = years * 12;
        if (type.equalsIgnoreCase("si")) {
            return simpleTotalAmount() / months;
        } else if (type.equalsIgnoreCase("ci")) {
            return compoundTotalAmount() / months;
        } else {
            System.out.println("Invalid interest type! Choose 'SI' or 'CI'.");
            return 0;
        }
    }

    // Get total amount based on type
    double totalAmount(String type) {
        if (type.equalsIgnoreCase("si")) {
            return simpleTotalAmount();
        } else if (type.equalsIgnoreCase("ci")) {
            return compoundTotalAmount();
        } else {
            System.out.println("Invalid interest type! Choose 'SI' or 'CI'.");
            return 0;
        }
    }
}
