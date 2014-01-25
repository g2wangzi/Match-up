package com.example.ecea2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EnterNameActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_name);
		Spinner s = (Spinner)findViewById(R.id.f_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.food_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_name, menu);
		return true;
	}
	
	public void done(View view)
	{
		Intent intent = new Intent(this, MainActivity.class);
		Bundle extras = new Bundle();
		EditText editText1 = (EditText) findViewById(R.id.editfname);
		String firstname = editText1.getText().toString();
		EditText editText2 = (EditText) findViewById(R.id.editlname);
		String lastname = editText2.getText().toString();
		EditText editText3 = (EditText) findViewById(R.id.editage);
		Spinner myspinner = (Spinner) findViewById(R.id.f_spinner);
		String ffood = myspinner.getSelectedItem().toString();
		String age = editText3.getText().toString();
		extras.putString("EXTRA_FIRSTNAME",firstname);
		extras.putString("EXTRA_LASTNAME",lastname);
		extras.putString("EXTRA_AGE",age);
		extras.putString("EXTRA_FFOOD",ffood);
		intent.putExtras(extras);
		startActivity(intent);	
	}
	
	public void storeindatabase(View view)
	{
	  DatabaseHandler db = new DatabaseHandler(this);
	  EditText editText1 = (EditText) findViewById(R.id.editfname);
	  String firstname = editText1.getText().toString();
	  EditText editText2 = (EditText) findViewById(R.id.editlname);
	  String lastname = editText2.getText().toString();
	  EditText editText3 = (EditText) findViewById(R.id.editage);
	  Spinner myspinner = (Spinner) findViewById(R.id.f_spinner);
	  String ffood = myspinner.getSelectedItem().toString();
	  String age = editText3.getText().toString();
	  db.addContact(new Contact(firstname+lastname, age, ffood));
	  
		
	  
	  
	}

}
