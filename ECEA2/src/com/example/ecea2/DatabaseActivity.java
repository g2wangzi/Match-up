package com.example.ecea2;
// test comment
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class DatabaseActivity extends ListActivity {
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    DatabaseHandler db = new DatabaseHandler(this);
    List<Contact> contacts = db.getAllContacts(); 
    ArrayList<String> values  = new ArrayList<String>();
    
    
    for (Contact cn : contacts) {
        String content = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
        values.add(content);
    
    
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
  }

} 
}