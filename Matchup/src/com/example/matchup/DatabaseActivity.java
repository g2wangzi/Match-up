package com.example.matchup;
// test comment
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DatabaseActivity extends ListActivity {
	public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    DatabaseHandler db = new DatabaseHandler(this);
    List<Contact> contacts = db.getAllContacts();
    ArrayList<String> values  = new ArrayList<String>();
    
    
    for (Contact cn : contacts) {
        String content = "Id: "+cn.getID() +" ,Name: " + cn.getName() + " ,Age: " + cn.getAge() + " ,Food: " + cn.getFood()
        		+ " ,Picurl: " + cn.getPicurl() + "Mov1rate:" + cn.getMov1rate() + "Mov2rate:" + cn.getMov2rate() + "Mov3rate:"
        		+ cn.getMov3rate() + "Mov4rate:" + cn.getMov4rate() + "Mov5rate:" + cn.getMov5rate();
        values.add(content);
    
    
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
    }

	}
  
  //  TO DO from id find the url to the picture
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    //String item = position;
	int peopleid = position + 1;
	DatabaseHandler db1 = new DatabaseHandler(this);
    String url = db1.getPicurlByID(Integer.toString(peopleid));
    //Log.d("url",url);
	//Toast.makeText(this, url + " selected", Toast.LENGTH_LONG).show();
    //Toast.makeText(this, url + " selected", Toast.LENGTH_LONG).show();
    
    
    Intent intent = new Intent(this, ShowPictureActivity.class);
    Bundle extras = new Bundle();
	extras.putString("EXTRA_URL",url);
	intent.putExtras(extras);
	startActivity(intent);
  }
  
}