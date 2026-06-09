package com.tss.test;

import com.tss.entitys.CricketInsides;
import static com.tss.Validation.ValidationForAll.*;
import java.util.Scanner;

public class Cricket {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        CricketInsides cricketrs[] = new CricketInsides[3];
        while (true)
        {
            System.out.println("enter 1.add the players information \n" +
                    "2. display all the players information \n" +
                    "3.calculate Average of players\n" +
                    "4.exit\n");

            int choice=inputInteger();
            if (choice==1)
            {
                for (int i=0; i<cricketrs.length; i++)
                {

                    System.out.println("enter the id for player:"+(i+1));
                    int Id=inputInteger();

                    System.out.println("enter the name of player:"+(i+1));
                    String name=inputString();

                    System.out.println("enter the Runs of player:"+(i+1));
                    int Runs=inputInteger();

                    System.out.println("enter the Number of Match player: "+(i+1));
                    int numberofmatch=inputInteger();

                    System.out.println("enter the Wickets of Match player: "+(i+1));
                    int wickets=inputInteger();
                    cricketrs[i]=new CricketInsides(numberofmatch,Runs,Id,wickets,name);

                }
            } else if (choice==2) {
                for (int i=0; i<cricketrs.length; i++)
                {
                    System.out.println("id :"+cricketrs[i].getid());

                    System.out.println("name :"+cricketrs[i].getName());

                    System.out.println("Runs :"+cricketrs[i].getRuns());

                    System.out.println("Number of Match : "+cricketrs[i].getNumberOfMatch());

                    System.out.println("Wickets : "+cricketrs[i].getWickets());

                }
            } else if (choice==3) {
                while (true)
                {
                System.out.println("Enter 1.for all players average\n" +
                        "2. for specific player\n" +
                        "3.exit average\n");
                int player=inputInteger();

                if (player==1)
                {
                    for (int i=0; i<cricketrs.length; i++)
                    {
                        System.out.print("Average of : "+cricketrs[i].getName());
                        System.out.println("| is : "+cricketrs[i].calculateAvrage());

                    }

                } else if (player==2)
                {
                    while (true)
                    {
                        System.out.println("Enter player id between 1 to\n" +(cricketrs.length)+
                                " 3.exit average\n");
                        int idofplayer=inputInteger();
                        if (idofplayer<1 || idofplayer > cricketrs.length-1)
                        {
                            System.out.println("invalid player");
                        }
                        else {
                            System.out.print("Average of : "+cricketrs[idofplayer-1].getName());
                            System.out.println("| is : "+cricketrs[idofplayer-1].calculateAvrage());

                            break;
                        }
                    }


                } else if (player==3) {
                    break;
                }
                else {
                    System.out.println("invalid input ");
                }
                }
            } else if (choice==4) {
                break;
            }
            else {
                System.out.println("invalid choice ");
            }


        }
    }
}
