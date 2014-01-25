package com.example.ecea2;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class ShowFilterActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_filter);
		DatabaseHandler db = new DatabaseHandler(this);
	    List<Contact> contacts = db.getAllContacts(); 
	    ArrayList<String> values  = new ArrayList<String>();
	    Intent intent = getIntent();
	    
	    
	    for (Contact cn : contacts) {
	        String content = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Age: " + cn.getAge() + " ,Food: " + cn.getFood();
	        values.add(content);
	    
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter);
	    }
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_filter, menu);
		return true;
	}

}
