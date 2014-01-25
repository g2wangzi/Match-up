package com.example.ecea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class FilterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		Spinner s = (Spinner)findViewById(R.id.f_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.food_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filter, menu);
		return true;
	}
	
	public void show(View view) {
		Intent intent = new Intent(this, ShowFilterActivity.class);
		Bundle extras = new Bundle();
		Spinner myspinner = (Spinner) findViewById(R.id.f_spinner);
		EditText editText1 = (EditText) findViewById(R.id.agefrom);
		EditText editText2 = (EditText) findViewById(R.id.ageupto);
		String ffood = myspinner.getSelectedItem().toString();
		String agefrom = editText1.getText().toString();
		String ageupto = editText2.getText().toString();
		extras.putString("EXTRA_FFOOD",ffood);
		extras.putString("EXTRA_AGEFROM",agefrom);
		extras.putString("EXTRA_AGEUPTO",ageupto);
		intent.putExtras(extras);
		startActivity(intent);
	}

}
