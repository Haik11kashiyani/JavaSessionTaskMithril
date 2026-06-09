package com.tss.entitys;

public class CricketInsides {


        private int numberOfMatch,Runs,wickets,id;
        private String name;
        public CricketInsides()
        {
                id=1;
                name="mr abc";
                numberOfMatch=1;
                Runs=100;
                wickets=0;
        }
        public CricketInsides(int numberOfMatch,int Runs,int id ,int wickets,String name)
        {
            this.name=name;
            this.id=id;
            this.Runs=Runs;
            this.wickets=wickets;
            this.numberOfMatch=numberOfMatch;
        }
        private String getName() {
            return name;
        }
    private int getid() {
        return id;
    }
    private int getNumberOfMatch() {
        return numberOfMatch;
    }
    private int getWickets() {
        return wickets;
    }
    private int getRuns() {
        return Runs;
    }
    private void setId(int id)
    {
        this.id=id;
    }
    private void setRuns(int Runs)
    {
        this.Runs=Runs;
    }
    private void setNumberOfMatch(int numberOfMatch)
    {
        this.numberOfMatch=numberOfMatch;
    }
    private void setWickets(int wickets)
    {
        this.wickets=wickets;
    }
    private void setName(String name)
    {
        this.name=name;
    }
    public double calculateAvrage()
        {
            return ((double)Runs/numberOfMatch);
        }
        public void printAll()
        {
            System.out.println("Id :"+id+"Name :"+name+"Number Of Match  :"+numberOfMatch +"\n Runs : "+Runs+"" +
                    "\n wickets :"+wickets+"\n Average :"+Runs/numberOfMatch );
        }


    }


