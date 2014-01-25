package com.example.ecea2;

public class Contact {
    
    //private variables
    int _id;
    String _name;
    String _age;
    String _food;
     
    // Empty constructor
    public Contact(){
         
    } //vantic test test comment
    
    public void test2() {

    }
    // Sean test comment
    // constructor
    public Contact(int id, String name, String _age, String _food){
        this._id = id;
        this._name = name;
        this._age = _age;
        this._food = _food;
    }
     
    // constructor
    public Contact(String name, String _age, String _food){
        this._name = name;
        this._age = _age;
        this._food = _food;
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
    
    public void test1()
    {
     
    }
    
 // getting Food
    public String getFood(){
        return this._food;
    }
     
    // setting Age
    public void setFood(String food){
        this._food = food;
    }
}