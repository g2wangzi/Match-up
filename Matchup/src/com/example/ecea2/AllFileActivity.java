package com.example.ecea2;
// test comment
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class AllFileActivity extends ListActivity {
	
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
    String filename = readFromFile("filelists.txt");
    String[] filenames = filename.split("\\s+");
    ArrayList<String> values  = new ArrayList<String>();
    for(String s: filenames)
     {String temp = readFromFile(s);
      values.add(temp);
     }
    
    
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
  }

} 