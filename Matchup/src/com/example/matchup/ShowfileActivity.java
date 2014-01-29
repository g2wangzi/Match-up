package com.example.matchup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.ecea2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ShowfileActivity extends Activity {
	
       public String readFromFile(String filename) {
        
        String ret = "";
         
        try {
            InputStream inputStream = openFileInput(filename);
             
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                 
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                 
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e(MainActivity.class.getName(), "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(MainActivity.class.getName(), "Can not read file: " + e.toString());
        }
 
        return ret;
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showfile);
		TextView textview = (TextView) findViewById(R.id.filecontent);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		String filename = extras.getString("EXTRA_FILENAME");
		String content = readFromFile(filename);
		textview.setText(content);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.showfile, menu);
		return true;
	}

}
