package com.example.ecea2;
// test comment
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DatabaseActivity extends ListActivity {
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    DatabaseHandler db = new DatabaseHandler(this);
    List<Contact> contacts = db.getAllContacts(); 
    ArrayList<String> values  = new ArrayList<String>();
    
    
    for (Contact cn : contacts) {
        String content = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Age: " + cn.getAge() + " ,Food: " + cn.getFood();
        values.add(content);
    
    
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
  }

   }
  
  //  TO DO from id find the url to the picture
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    //String item = position;
	  int position1 = position + 1;
    Toast.makeText(this, position1 + " selected", Toast.LENGTH_LONG).show();
    //Intent intent = new Intent(this, ShowfileActivity.class);
    //Bundle extras = new Bundle();
	//extras.putString("EXTRA_FILENAME",item);
	//intent.putExtras(extras);
	//startActivity(intent);
  }
  
}