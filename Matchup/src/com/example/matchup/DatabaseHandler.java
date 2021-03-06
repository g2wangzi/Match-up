package com.example.matchup;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "FavouriteFood";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_FOOD = "food";
    private static final String KEY_PICURL = "picurl";
    private static final String KEY_MOV1 = "mov1rate";
    private static final String KEY_MOV2 = "mov2rate";
    private static final String KEY_MOV3 = "mov3rate";
    private static final String KEY_MOV4 = "mov4rate";
    private static final String KEY_MOV5 = "mov5rate";
    
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AGE + " INTEGER," + KEY_FOOD + " TEXT," + KEY_PICURL + " TEXT,"
                + KEY_MOV1 + " INTEGER," + KEY_MOV2 + " INTEGER," + KEY_MOV3 + " INTEGER,"
                + KEY_MOV4 + " INTEGER," + KEY_MOV5 + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_AGE, contact.getAge()); // Contact Age
        values.put(KEY_FOOD, contact.getFood()); // Contact Food
        values.put(KEY_PICURL, contact.getPicurl()); // Contact Picurl
        values.put(KEY_MOV1, contact.getMov1rate()); // Contact Mov1rate
        values.put(KEY_MOV2, contact.getMov2rate()); // Contact Mov2rate
        values.put(KEY_MOV3, contact.getMov3rate()); // Contact Mov3rate
        values.put(KEY_MOV4, contact.getMov4rate()); // Contact Mov4rate
        values.put(KEY_MOV5, contact.getMov5rate()); // Contact Mov5rate
 
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single contact
    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                KEY_NAME, KEY_AGE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9));
        // return contact
        return contact;
    }
     
    // Getting All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setAge(cursor.getString(2));
                contact.setFood(cursor.getString(3));
                contact.setPicurl(cursor.getString(4));
                contact.setMov1rate(cursor.getInt(5));
                contact.setMov2rate(cursor.getInt(6));
                contact.setMov3rate(cursor.getInt(7));
                contact.setMov4rate(cursor.getInt(8));
                contact.setMov5rate(cursor.getInt(9));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
 
    // Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_AGE, contact.getAge());
        values.put(KEY_FOOD, contact.getFood());
        values.put(KEY_PICURL, contact.getPicurl());
        values.put(KEY_MOV1, contact.getMov1rate());
        values.put(KEY_MOV2, contact.getMov2rate());
        values.put(KEY_MOV3, contact.getMov3rate());
        values.put(KEY_MOV4, contact.getMov4rate());
        values.put(KEY_MOV5, contact.getMov5rate());
 
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
 
    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
 
 
    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
    
    // Getting Selected Contacts
    public List<Contact> getSelectedContacts(String food, String agefrom, String ageupto) {
    //public List<Contact> getSelectedContacts(String food) {
        List<Contact> contactList = new ArrayList<Contact>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + " WHERE " + KEY_AGE + ">? AND " + KEY_AGE + "<? AND " + KEY_FOOD + "=?";
        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + " WHERE " + KEY_FOOD + " =?" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[] {agefrom, ageupto, food});
        //Cursor cursor = db.rawQuery(selectQuery, new String[] {food});
        
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setAge(cursor.getString(2));
                contact.setFood(cursor.getString(3));
                contact.setPicurl(cursor.getString(4));
                contact.setMov1rate(cursor.getInt(5));
                contact.setMov2rate(cursor.getInt(6));
                contact.setMov3rate(cursor.getInt(7));
                contact.setMov4rate(cursor.getInt(8));
                contact.setMov5rate(cursor.getInt(9));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        db.close();
        // return contact list
        return contactList;
    }
    
    public String getPicurlByID(String id) {
    	String selectQuery = "SELECT "+ KEY_PICURL + " FROM " + TABLE_CONTACTS + " WHERE " + KEY_ID + "=?";
    	SQLiteDatabase db2 = this.getWritableDatabase();
    	Cursor cursor = db2.rawQuery(selectQuery, new String[] {id});
    	//Contact contact = new Contact();
    	
    	cursor.moveToFirst();
    	return cursor.getString(0);
    }
 
}