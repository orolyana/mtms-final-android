package com.example.ibra.project;

public class Contact {
    int id,level,bank,plate;
    String pass,name,user,start,destination;
    public void setStart(String start){
        this.start=start;
    }
    public  String getStart(){
        return this.start;
    }
    public void setDestination(String destination){
        this.destination=destination;
    }
    public String getDestination(){
        return this.destination;
    }
    public void setBank(int bank){
        this.bank=bank;
    }
    public int getBank(){
        return this.bank;

    }
    public void setLevel(int level)
    {
        this.level=level;
    }
    public int getLevel(){
        return this.level;

    }
    public void setPlate(int plate){
        this.plate=plate;
    }
    public int getPlate(){
        return this.plate;

    }

    public void setName(String name){
        this.name=name;

    }

    public String getName(){
        return  this.name;
    }

    public void setUser(String user){
        this.user=user;
    }
    public  String getUser(){
        return this.user;
    }
    public void setPass(String pass){
        this.pass=pass;

    }

    public String getPass(){
        return  this.pass;
    }

}
