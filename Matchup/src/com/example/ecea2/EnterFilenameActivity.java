package com.example.ecea2;

import java.io.IOException;
import java.io.OutputStreamWriter;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EnterFilenameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_filename);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_filename, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void writeToFile(String data,String filename, String mode) {
        try {
            if (mode == "private")
            {
            	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(filename, Context.MODE_PRIVATE));
            	outputStreamWriter.write(data);
            	outputStreamWriter.close();}
            else
            {
            	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(filename, Context.MODE_APPEND));
            	outputStreamWriter.write(data);
            	outputStreamWriter.close();
             }
            
        }
        catch (IOException e) {
            Log.e(MainActivity.class.getName(), "File write failed: " + e.toString());
        } 
         
    }
	
	public void finish(View view)
	{   
		EditText editText = (EditText) findViewById(R.id.editfilename);
		String filename = editText.getText().toString();
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		String firstname = extras.getString("EXTRA_FIRSTNAME");
		String ffood = extras.getString("EXTRA_FFOOD");
		String lastname = extras.getString("EXTRA_LASTNAME");
		String age = extras.getString("EXTRA_AGE");
		writeToFile(firstname, filename, "append");
		writeToFile(" ", filename, "append");
		writeToFile(lastname, filename, "append");
		writeToFile(" ", filename, "append");
		writeToFile(age, filename, "append");
		writeToFile(" ", filename, "append");
		writeToFile(ffood, filename, "append");
		writeToFile(filename, "filelists.txt", "append");
		writeToFile(" ", "filelists.txt", "append");
		Intent intent2 = new Intent(this, MainActivity.class);
		startActivity(intent2);
		
	}

}
