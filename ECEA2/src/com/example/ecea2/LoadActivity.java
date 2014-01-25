package com.example.ecea2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LoadActivity extends ListActivity {
	
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
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    
    /*String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
        "Linux", "OS/2" };*/
    String value = readFromFile("filelists.txt");
    String[] values = value.split("\\s+");
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    String item = (String) getListAdapter().getItem(position);
    //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    Intent intent = new Intent(this, ShowfileActivity.class);
    Bundle extras = new Bundle();
	extras.putString("EXTRA_FILENAME",item);
	intent.putExtras(extras);
	startActivity(intent);
  }
} 