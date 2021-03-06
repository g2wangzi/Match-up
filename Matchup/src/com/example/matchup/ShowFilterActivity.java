package com.example.matchup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;



public class ShowFilterActivity extends ListActivity {
	// String ffood = "Apple";
/*
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		DatabaseHandler db = new DatabaseHandler(this);
		//String ffood = "Carrot";
		//String agefrom = null;
		//String ageupto = null;


		Intent intent = getIntent();

		if (intent.getExtras() != null)
		{   
			Bundle extras = intent.getExtras();
			ffood = extras.getString("EXTRA_FFOOD");
			//agefrom = extras.getString("EXTRA_AGEFROM");
			//ageupto = extras.getString("EXTRA_AGEUPTO");
		}
		else
		{
			new AlertDialog.Builder(this)
			.setTitle("Sorry")
			.setMessage("You need to EnterNames first then store")
			.setPositiveButton("Back", null)
			.show();
		}


	    
		//List<Contact> contacts = db.getSelectedContacts(ffood, agefrom, ageupto);
		List<Contact> contacts = db.getSelectedContacts(ffood);
		ArrayList<String> values  = new ArrayList<String>();

	    for (Contact cn : contacts) {
	        String content = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Age: " + cn.getAge() + " ,Food: " + cn.getFood();
	        values.add(content);
	    
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_2, values);
	    setListAdapter(adapter);
	    }
	    
	}
*/
	@Override
	protected void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
	    DatabaseHandler db = new DatabaseHandler(this);
	    String ffood = null;
	    String agefrom = null;
	    String ageupto = null;
	    
	    Intent intent = getIntent();
	    if (intent.getExtras() != null)
		{
	    	Bundle extras = intent.getExtras();
	    	ffood = extras.getString("EXTRA_FFOOD");
	    	agefrom = extras.getString("EXTRA_AGEFROM");
			ageupto = extras.getString("EXTRA_AGEUPTO");
		} else {
			new AlertDialog.Builder(this)
			.setTitle("Sorry")
			.setMessage("Error showing contacts.")
			.setPositiveButton("Back", null)
			.show();
		}
	    
	    List<Contact> contacts = db.getSelectedContacts(ffood, agefrom, ageupto);
	    ArrayList<String> values  = new ArrayList<String>();
	    
	    for (Contact cn : contacts) {
	        String content = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Age: " + cn.getAge() + " ,Food: " + cn.getFood()
	        		+ " ,Picurl: " + cn.getPicurl();
	        values.add(content);
	    
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        		android.R.layout.simple_list_item_1, values);
	        setListAdapter(adapter);
	    }
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	    //String item = position;
		  String position1 = Integer.toString(position + 1);
		  DatabaseHandler db = new DatabaseHandler(this);
		  String picaddress = db.getPicurlByID(position1);
	}


}
