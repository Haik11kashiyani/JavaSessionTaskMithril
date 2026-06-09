package com.tss.test;

import com.tss.entitys.CricketInsides;
import static com.tss.Validation.ValidationForAll.*;
import java.util.Scanner;

public class Cricket {
    public static void main(String[] args) {
        CricketInsides Rohit= new CricketInsides();
        CricketInsides Virat=new CricketInsides(234,10000,18,23,"Virat Kohli");

        Scanner scanner =new Scanner(System.in);
        System.out.println("enter the id :");
        int Id=scanner.nextInt();

        System.out.println("enter the name :");
        String name=scanner.nextLine();

        System.out.println("enter the Runs :");
        int Runs=scanner.nextInt();

        System.out.println("enter the Number of Match :");
        int numberofmatch=scanner.nextInt();

        System.out.println("enter the Wickets :");
        int wickets=scanner.nextInt();


        CricketInsides user=new CricketInsides(numberofmatch,Runs,Id,wickets,name);
        user.calculateAvrage();
        user.printAll();
    }
}
