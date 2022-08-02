package ADVANCED.LAB6_Defining_Classes.P3_Bank_Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] lineArgument = scan.nextLine().split("\\s+");

        Map<Integer, BankAccount> accountMap = new HashMap<>();

        String command = lineArgument[0];
        while (!command.equals("End")) {
            String result = "";

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountMap.put(bankAccount.getId(), bankAccount);
                    result = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    int accountID = Integer.parseInt(lineArgument[1]);
                    double money = Double.parseDouble(lineArgument[2]);

                    if (accountMap.containsKey(accountID)) {
                        BankAccount bankAccountFromMap = accountMap.get(accountID);
                        bankAccountFromMap.deposit(money);
                        accountMap.put(accountID, bankAccountFromMap);
                        result = String.format("Deposited %.0f to ID%d", money, accountID);
                    } else {
                        result = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(lineArgument[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    int accountId = Integer.parseInt(lineArgument[1]);
                    int year = Integer.parseInt(lineArgument[2]);

                    if (accountMap.containsKey(accountId)) {
                        BankAccount bankAccount1 = accountMap.get(accountId);
                        double totalInterest = bankAccount1.getInterest(year);
                        result = String.format("%.2f", totalInterest);
                    } else {
                        result = "Account does not exist";
                    }
                    break;
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }
            lineArgument = scan.nextLine().split("\\s+");
            command = lineArgument[0];
        }
    }
}
