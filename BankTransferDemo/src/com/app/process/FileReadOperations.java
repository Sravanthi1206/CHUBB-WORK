package com.app.process;

import java.io.*;
import java.util.*;

class Transaction {
    String senderName, senderCountry, senderIFSC;
    long senderAccNo;
    double senderBalance, transferAmount;
    String mode;
    String receiverName, receiverCountry, receiverIFSC;
    long receiverAccNo;

    public Transaction(String[] data) {
        this.senderName = data[0];
        this.senderCountry = data[1];
        this.senderAccNo = Long.parseLong(data[2]);
        this.senderIFSC = data[3];
        this.senderBalance = Double.parseDouble(data[4]);
        this.transferAmount = Double.parseDouble(data[5]);
        this.mode = data[6];
        this.receiverName = data[7];
        this.receiverCountry = data[8];
        this.receiverAccNo = Long.parseLong(data[9]);
        this.receiverIFSC = data[10];
    }
}

public class FileReadOperations {

    public static void main(String[] args) {
        String filePath = "userdettails.txt";
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11) {
                    transactions.add(new Transaction(data));
                } else {
                    System.out.println("Invalid line skipped: " + line);
                }
            }

            double totalHdfcTransfers = 0;

            System.out.println("=== VALID TRANSFERS ===");
            for (Transaction t : transactions) {
                if (t.transferAmount > 0 && t.senderBalance >= t.transferAmount) {
                    t.senderBalance -= t.transferAmount;
                    System.out.println(
                        t.senderName + " transferred ₹" + t.transferAmount +
                        " to " + t.receiverName + " via " + t.mode +
                        " | Remaining Balance: ₹" + t.senderBalance);

                    if (t.senderIFSC.startsWith("HDFC")) {
                        totalHdfcTransfers += t.transferAmount;
                    }
                } else {
                    System.out.println("❌ Invalid transfer by " + t.senderName +
                                       " (Insufficient funds or invalid amount)");
                }
            }

            System.out.println("\nTotal amount transferred by HDFC Bank senders: ₹" + totalHdfcTransfers);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
