package com.example.matchup;

public class Contact {
    
    //private variables
    int _id;
    String _name;
    String _age;
    String _food;
    String _picurl;
     
    // Empty constructor
    public Contact(){
         
    } //vantic test test comment
    
    // Sean test comment
    // constructor
    public Contact(int id, String name, String _age, String _food, String _picurl){
        this._id = id;
        this._name = name;
        this._age = _age;
        this._food = _food;
        this._picurl = _picurl;
    }
     
    // constructor
    public Contact(String name, String _age, String _food, String _picurl){
        this._name = name;
        this._age = _age;
        this._food = _food;
        this._picurl = _picurl;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting ID
    public void setID(int id){
        this._id = id;
    }
     
    // getting Name
    public String getName(){
        return this._name;
    }
     
    // setting Name
    public void setName(String name){
        this._name = name;
    }
     
    // getting Age
    public String getAge(){
        return this._age;
    }
     
    // setting Age
    public void setAge(String age){
        this._age = age;
    }
    
    // getting Food
    public String getFood(){
        return this._food;
    }
     
    // setting Food
    public void setFood(String food){
        this._food = food;
    }
    
    // getting Picurl
    public String getPicurl(){
        return this._picurl;
    }
     
    // setting Picurl
    public void setPicurl(String picurl){
        this._picurl = picurl;
    }
}