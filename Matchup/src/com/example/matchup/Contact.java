package com.example.matchup;

public class Contact {
    
    //private variables
    int _id;
    String _name;
    String _age;
    String _food;
    String _picurl;
    int _mov1rate;
    int _mov2rate;
    int _mov3rate;
    int _mov4rate;
    int _mov5rate;
     
    // Empty constructor
    public Contact(){
         
    } //vantic test test comment
    
    // Sean test comment
    // constructor
    public Contact(int id, String name, String _age, String _food, String _picurl, int _mov1rate, int _mov2rate, int _mov3rate,
    		int _mov4rate, int _mov5rate){
        this._id = id;
        this._name = name;
        this._age = _age;
        this._food = _food;
        this._picurl = _picurl;
        this._mov1rate = _mov1rate;
        this._mov2rate = _mov2rate;
        this._mov3rate = _mov3rate;
        this._mov4rate = _mov4rate;
        this._mov5rate = _mov5rate;
    }
     
    // constructor
    public Contact(String name, String _age, String _food, String _picurl, int _mov1rate, int _mov2rate, int _mov3rate,
    		int _mov4rate, int _mov5rate){
        this._name = name;
        this._age = _age;
        this._food = _food;
        this._picurl = _picurl;
        this._mov1rate = _mov1rate;
        this._mov2rate = _mov2rate;
        this._mov3rate = _mov3rate;
        this._mov4rate = _mov4rate;
        this._mov5rate = _mov5rate;
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
    
    // getting Mov1rate
    public int getMov1rate(){
        return this._mov1rate;
    }
     
    // setting Mov1rate
    public void setMov1rate(int rate){
        this._mov1rate = rate;
    }
    
    // getting Mov2rate
    public int getMov2rate(){
        return this._mov2rate;
    }
     
    // setting Mov2rate
    public void setMov2rate(int rate){
        this._mov2rate = rate;
    }
    
    // getting Mov3rate
    public int getMov3rate(){
        return this._mov3rate;
    }
     
    // setting Mov3rate
    public void setMov3rate(int rate){
        this._mov3rate = rate;
    }
    
    // getting Mov4rate
    public int getMov4rate(){
        return this._mov4rate;
    }
     
    // setting Mov4rate
    public void setMov4rate(int rate){
        this._mov4rate = rate;
    }
    
    // getting Mov5rate
    public int getMov5rate(){
        return this._mov5rate;
    }
     
    // setting Mov5rate
    public void setMov5rate(int rate){
        this._mov5rate = rate;
    }
}