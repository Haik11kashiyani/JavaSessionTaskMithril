package com.tss.test;

import com.tss.entitys.BankAccount;
import java.util.Scanner;
import static com.tss.Validation.ValidationForAll.inputInteger;
import static com.tss.Validation.ValidationForAll.inputString;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankaccounts[] = new BankAccount[3];

        
        for (int i = 0; i < bankaccounts.length; i++) {
            System.out.println("Enter the Account details for the user " + (i + 1));
            System.out.print("Enter name: ");
            bankaccounts[i] = new BankAccount();
            bankaccounts[i].updateName(inputString());


            while (true) {
                System.out.print("Enter the Account account balance: ");
                double balanceInput = inputInteger();
                if (balanceInput < 500) {
                    System.out.println("You cannot enter less than 500");
                } else {
                    bankaccounts[i].updatebalance(balanceInput);
                    break;
                }
            }


            while (true) {
                System.out.println("Enter the account type\n1. Current\n2. Savings");
                int accountType = inputInteger();
                if (accountType == 1) {
                    bankaccounts[i].setAccounttype("Current Account");
                    break;
                } else if (accountType == 2) {
                    bankaccounts[i].setAccounttype("Savings Account");
                    break;
                } else {
                    System.out.println("Invalid input. Please choose 1 or 2.");
                }
            }
        }


        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Deposit\n2. Withdraw\n3. Balance\n4. Print Information\n5. Transfer to other account\n6. Exit");
            int choice = inputInteger();
            int accountNumberInput;
            int result;

            if (choice == 1) {
                System.out.print("Enter the account number to deposit: ");
                accountNumberInput = inputInteger();
                result = findAccountUser(bankaccounts, accountNumberInput);

                // FIX: Validated against -1 instead of 0
                if (result == -1) {
                    System.out.println("Account not found.");
                } else {
                    System.out.print("Enter the amount to deposit: ");
                    double balance = inputInteger();
                    if (balance < 0) {
                        System.out.println("Invalid input amount.");
                    } else {
                        bankaccounts[result].deposit(balance);
                        System.out.println("Deposited successfully.");
                    }
                }
            }
            else if (choice == 2) {
                System.out.print("Enter the account number to withdraw: ");
                accountNumberInput = inputInteger();
                result = findAccountUser(bankaccounts, accountNumberInput);

                if (result == -1) {
                    System.out.println("Account not found.");
                } else {
                    System.out.print("Enter the amount to withdraw: ");
                    double balance = inputInteger();
                    if (balance < 0) {
                        System.out.println("Invalid input amount.");
                    } else {
                        if (bankaccounts[result].getBalance() < (500 + balance)) {
                            System.out.println("500 rupees must remain in the Bank Account");
                            System.out.println("Current balance: " + bankaccounts[result].getBalance());
                        } else {
                            bankaccounts[result].withdraw(balance);
                            System.out.println("Current balance: " + bankaccounts[result].getBalance());
                        }
                    }
                }
            }
            else if (choice == 3) {
                System.out.print("Enter the account number to get the balance: ");
                accountNumberInput = inputInteger();
                result = findAccountUser(bankaccounts, accountNumberInput);

                if (result == -1) {
                    System.out.println("Account not found.");
                } else {
                    System.out.println("Current balance: " + bankaccounts[result].getBalance());
                }
            }
            else if (choice == 4) {
                System.out.print("Enter the account number to get information: ");
                accountNumberInput = inputInteger();
                result = findAccountUser(bankaccounts, accountNumberInput);

                if (result == -1) {
                    System.out.println("Account not found.");
                } else {
                    bankaccounts[result].printAll();
                }
            }
            else if (choice == 5) {
                System.out.print("Enter your account number to send money: ");
                accountNumberInput = inputInteger();
                int resultofsender = findAccountUser(bankaccounts, accountNumberInput);

                if (resultofsender == -1) {
                    System.out.println("Sender account not found.");
                } else {
                    System.out.print("Enter the account number to receive money: ");
                    int accountNumberInputReceiver = inputInteger();
                    int resultofreceive = findAccountUser(bankaccounts, accountNumberInputReceiver);

                    if (resultofreceive == -1) {
                        System.out.println("Receiver account not found.");
                    } else {
                        System.out.print("Enter the amount to transfer: ");
                        double withdrawBalance = inputInteger();

                        if (bankaccounts[resultofsender].getBalance() < (500 + withdrawBalance)) {
                            System.out.println("Insufficient funds. 500 rupees must remain in your account.");
                            System.out.println("Your current balance: " + bankaccounts[resultofsender].getBalance());
                        } else {
                            bankaccounts[resultofsender].withdraw(withdrawBalance);
                            bankaccounts[resultofreceive].deposit(withdrawBalance);
                            System.out.println("Transfer successful!");
                            System.out.println("Your remaining balance: " + bankaccounts[resultofsender].getBalance());
                        }
                    }
                }
            }
            else if (choice == 6) {
                System.out.println("Thank you for using the banking application!");
                break;
            }
            else {
                System.out.println("Enter a valid choice.");
            }
        }
        scanner.close();
    }


    public static int findAccountUser(BankAccount[] arrayofusers, int accounttofind) {
        for (int i = 0; i < arrayofusers.length; i++) {
            if (arrayofusers[i] != null && arrayofusers[i].getAccountNumber() == accounttofind) {
                return i;
            }
        }
        return -1;
    }
}
