package com.tss.entitys;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {

    Random rand = new Random();
    private static int count=1;
    private double balance;
   private long accountNumber;
    private int id;
    private String name;
    private String accountType;
    public BankAccount()
    {
        id=count++;
        name="null";
        accountNumber =  rand.nextInt(99999999 - 10000000 + 1) + 10000000;
        balance=500.00;
        accountType="null";

    }
    public BankAccount(String name,double balance,String accountType)
    {   this.accountType=accountType;
        this.name=name;
        this.id=count++;
        this.balance=balance;
        accountNumber =  rand.nextInt(99999999 - 10000000 + 1) + 10000000;

    }
    public String getName() {
        return name;
    }public long getAccountNumber() {
        return accountNumber;
    }
    public void updateName(String newName) {
        setName(newName);
    }
    public void setAccounttype(String newAccountType) {
        setAccountType(newAccountType);
    }
    public void updatebalance(double balance){
        setBalance(balance);
    }

    public int getid() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public String getaccountType()
    {
        return accountType;
    }
    private void setAccountType(String accountType)
    {
        this.accountType=accountType;
    }
    private void setId(int id)
    {
        this.id=id;
    }
    private void setBalance(double balance)
    {
        this.balance=balance;
    }
    private void setName(String name)
    {
        this.name=name;
    }

    public void deposit(double amount)
    {
        balance=balance+amount;
    }
    public void withdraw(double amount)
    {
        balance=balance-amount;
    }
    public void printAll()
    {
        System.out.println("Id :"+id+"Name :"+name+"current balance  :"+balance +"\n account type : "+accountType + "account number :"+accountNumber);
    }



}

