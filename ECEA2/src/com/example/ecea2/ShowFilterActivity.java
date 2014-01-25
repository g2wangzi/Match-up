package com.example.ecea2;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
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
		Intent intent = getIntent();
		String ffood =null;
		String agefrom =null;
		String ageupto =null;
		if (intent.getExtras() != null)
		{   
			Bundle extras = intent.getExtras();
			ffood = extras.getString("EXTRA_FFOOD");
			agefrom = extras.getString("EXTRA_AGEFROM");
			ageupto = extras.getString("EXTRA_AGEUPTO");
		}
		else
		{
			new AlertDialog.Builder(this)
			.setTitle("Sorry")
			.setMessage("You need to EnterNames first then store")
			.setPositiveButton("Back", null)
			.show();
		}
	    
		 List<Contact> contacts = db.getSelectedContacts(ffood, agefrom, ageupto); 
		 ArrayList<String> values  = new ArrayList<String>();

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
