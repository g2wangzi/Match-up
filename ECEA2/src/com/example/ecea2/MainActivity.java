package com.example.ecea2;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void exitapp(View view) {
		finish();
		System.exit(0);
	}
	
	public void toname(View view) {
		Intent intententer = new Intent(this, EnterNameActivity.class);
		startActivity(intententer);
	}
	
	public void store(View view){
		Intent intent = getIntent();
		if (intent != null && getIntent().getData() != null)
		{   
			Bundle extras = intent.getExtras();
			String firstname = extras.getString("EXTRA_FIRSTNAME");
			String lastname = extras.getString("EXTRA_LASTNAME");
			String age = extras.getString("EXTRA_AGE");
			String ffood = extras.getString("EXTRA_FFOOD");
			Intent intent2 = new Intent(this, EnterFilenameActivity.class);
			Bundle extras2 = new Bundle();
			extras2.putString("EXTRA_FIRSTNAME",firstname);
			extras2.putString("EXTRA_LASTNAME",lastname);
			extras2.putString("EXTRA_AGE",age);
			extras2.putString("EXTRA_FFOOD",ffood);
			intent2.putExtras(extras2);
	        startActivity(intent2);
		}
		else
		{
			new AlertDialog.Builder(this)
			.setTitle("Sorry")
			.setMessage("You need to EnterNames first then store")
			.setPositiveButton("Back", null)
			.show();
		}
	}
	
	public void load(View view) {
		Intent intent = new Intent(this, LoadActivity.class);
		startActivity(intent);
	}
	
	public void view(View view) {
		Intent intent = new Intent(this, AllFileActivity.class);
		startActivity(intent);
	}
	
	public void viewdatabase(View view) {
		Intent intent = new Intent(this, DatabaseActivity.class);
		startActivity(intent);
	}

}
