package com.tss.test;

import com.tss.entitys.BankAccount;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        BankAccount user1=new BankAccount();
        Scanner scanner =  new Scanner(System.in);

        System.out.println("Enter the Account details");
        System.out.println("Enter your name :");
        user1.setName(scanner.nextLine());
        while (true) {
            System.out.println("Enter the Account account balance :");
            double balanceInput = scanner.nextDouble();
            if (balanceInput < 500) {
                System.out.println("You can not enter less than 500");
            }
            else {
                user1.setBalance(balanceInput);
                break;
            }
        }
        while (true) {
            System.out.println("enter the account type " +
                    "1.current" +
                    "2.savings");

            int accountType = scanner.nextInt();

            if (accountType ==1) {
                user1.setAccountType("Current Account");

                break;
            } else if (accountType==2) {
                user1.setAccountType("Savings Account");
                break;
            } else {
                System.out.println("invalid input");

            }
        }

        int choice=0;
        while (true){


        System.out.println("enter 1.deposit " +
                "           2. withdraw " +
                "3. balance"+
                "4. print information"+
                "5. exit"
        );
        choice=scanner.nextInt();

        if (choice==1)
        {

            System.out.println("enter the amount to deposit :");
            double balance=scanner.nextDouble();

            if (balance<0)
            {
                System.out.println("invalid input");


            }
            else {
                user1.deposit(balance);
                System.out.println("current balance :"+user1.getBalance());
            }


        } else if (choice==2) {
            System.out.println("enter the amount to withdraw :");
            double balance=scanner.nextDouble();
        if (balance<0){
            System.out.println("invalid input");
        }
        else {
            if (user1.getBalance()<(500+balance))
            {
                System.out.println("500rupees must in Bank Account");
                System.out.println("current balance :"+user1.getBalance());

            }
            else
            {
                user1.withdraw(balance);
                System.out.println("current balance :"+user1.getBalance());
            }
        }
        }
        else if(choice==3)
        {System.out.println("current balance :"+user1.getBalance());


        } else if (choice==4) {
            user1.printAll();
        } else if (choice==5) {
            break;
        } else {
            System.out.println("enter valid choice");
        }
        }

        BankAccount account2=new BankAccount("Prince",1500,"Saving Account");
        account2.printAll();
    }
}
