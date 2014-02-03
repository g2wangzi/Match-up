package com.example.matchup;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ecea2.R;

public class EnterNameActivity extends Activity {
	public String picurl = null;
	public int[] rates=new int[]{1,2,3,4,5};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_name);
		Spinner food_s = (Spinner)findViewById(R.id.f_spinner);
		ArrayAdapter<CharSequence> adapter_food = ArrayAdapter.createFromResource(
				this, R.array.food_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter_food.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		food_s.setAdapter(adapter_food);
		

		Spinner mov1_s = (Spinner)findViewById(R.id.mov1_spinner);
		ArrayAdapter<CharSequence> adapter_mov1 = ArrayAdapter.createFromResource(
				this, R.array.rate_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter_mov1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mov1_s.setAdapter(adapter_mov1);
		
		Spinner mov2_s = (Spinner)findViewById(R.id.mov2_spinner);
		ArrayAdapter<CharSequence> adapter_mov2 = ArrayAdapter.createFromResource(
				this, R.array.rate_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter_mov2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mov2_s.setAdapter(adapter_mov2);
		
		Spinner mov3_s = (Spinner)findViewById(R.id.mov3_spinner);
		ArrayAdapter<CharSequence> adapter_mov3 = ArrayAdapter.createFromResource(
				this, R.array.rate_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter_mov3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mov3_s.setAdapter(adapter_mov3);
		
		Spinner mov4_s = (Spinner)findViewById(R.id.mov4_spinner);
		ArrayAdapter<CharSequence> adapter_mov4 = ArrayAdapter.createFromResource(
				this, R.array.rate_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter_mov4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mov4_s.setAdapter(adapter_mov4);
		
		Spinner mov5_s = (Spinner)findViewById(R.id.mov5_spinner);
		ArrayAdapter<CharSequence> adapter_mov5 = ArrayAdapter.createFromResource(
				this, R.array.rate_spinner, android.R.layout.simple_spinner_dropdown_item);
		adapter_mov5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mov5_s.setAdapter(adapter_mov5);
		
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
		Spinner fspinner = (Spinner) findViewById(R.id.f_spinner);
		String ffood = fspinner.getSelectedItem().toString();
		Spinner mov1spinner = (Spinner) findViewById(R.id.mov1_spinner);
		String mov1rate = mov1spinner.getSelectedItem().toString();
		Spinner mov2spinner = (Spinner) findViewById(R.id.mov2_spinner);
		String mov2rate = mov2spinner.getSelectedItem().toString();
		Spinner mov3spinner = (Spinner) findViewById(R.id.mov3_spinner);
		String mov3rate = mov3spinner.getSelectedItem().toString();
		Spinner mov4spinner = (Spinner) findViewById(R.id.mov4_spinner);
		String mov4rate = mov4spinner.getSelectedItem().toString();
		Spinner mov5spinner = (Spinner) findViewById(R.id.mov5_spinner);
		String mov5rate = mov5spinner.getSelectedItem().toString();
		String age = editText3.getText().toString();
		extras.putString("EXTRA_FIRSTNAME",firstname);
		extras.putString("EXTRA_LASTNAME",lastname);
		extras.putString("EXTRA_AGE",age);
		extras.putString("EXTRA_FFOOD",ffood);
		extras.putString("EXTRA_PICURL", picurl);
		extras.putString("EXTRA_MOV1RATE", mov1rate);
		extras.putString("EXTRA_MOV2RATE", mov2rate);
		extras.putString("EXTRA_MOV3RATE", mov3rate);
		extras.putString("EXTRA_MOV4RATE", mov4rate);
		extras.putString("EXTRA_MOV5RATE", mov5rate);
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
	  Spinner mov1spinner = (Spinner) findViewById(R.id.mov1_spinner);
	  Integer mov1rate = Integer.parseInt(mov1spinner.getSelectedItem().toString());
	  Spinner mov2spinner = (Spinner) findViewById(R.id.mov2_spinner);
	  Integer mov2rate = Integer.parseInt(mov2spinner.getSelectedItem().toString());
	  Spinner mov3spinner = (Spinner) findViewById(R.id.mov3_spinner);
	  Integer mov3rate = Integer.parseInt(mov3spinner.getSelectedItem().toString());
	  Spinner mov4spinner = (Spinner) findViewById(R.id.mov4_spinner);
	  Integer mov4rate = Integer.parseInt(mov4spinner.getSelectedItem().toString());
	  Spinner mov5spinner = (Spinner) findViewById(R.id.mov5_spinner);
	  Integer mov5rate = Integer.parseInt(mov5spinner.getSelectedItem().toString());
	  String age = editText3.getText().toString();
	  //Log.d("stringtag", picurl);
	  db.addContact(new Contact(firstname+" "+lastname, age, ffood, picurl, mov1rate, mov2rate, mov3rate, mov4rate, mov5rate));
	  

	}
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Uri fileUri;
	
	public void photo(View view)
	{
		
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

	    fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
	    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

	    // start the image capture Intent
	    if(intent.resolveActivity(getPackageManager()) != null)
	    {
	    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);	
	}
	}
	
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;

	/** Create a file Uri for saving an image or video */
	public Uri getOutputMediaFileUri(int type){
	      return Uri.fromFile(getOutputMediaFile(type));
	}

	/** Create a File for saving an image or video */
	public File getOutputMediaFile(int type){
	    // To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.

	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "MyCameraApp");
	    // This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("MyCameraApp", "failed to create directory");
	            return null;
	        }
	    }

	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    if (type == MEDIA_TYPE_IMAGE){
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "IMG_"+ timeStamp + ".jpg");
	        picurl = mediaStorageDir.getPath() + File.separator +
	    	        "IMG_"+ timeStamp + ".jpg";
	        
	    } else {
	        return null;
	    }

	    return mediaFile;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	            // Image captured and saved to fileUri specified in the Intent
	            Toast.makeText(this, "Image saved:\n", Toast.LENGTH_LONG).show();
	        } else if (resultCode == RESULT_CANCELED) {
	            // User cancelled the image capture
	        } else {
	            // Image capture failed, advise user
	        }
	    }
	    
	}
	

}
