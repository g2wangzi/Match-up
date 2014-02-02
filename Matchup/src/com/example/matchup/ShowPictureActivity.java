package com.example.matchup;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.example.ecea2.R;

public class ShowPictureActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_picture);
		    
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_picture, menu);
		return true;
	}
	
	public void showpicture(View view) {
		ImageView imgView=(ImageView) findViewById(R.id.imageView1);
		Intent intent = getIntent();
		String url = null;
		if (intent.getExtras() != null)
		{   
			Bundle extras = intent.getExtras();
			url = extras.getString("EXTRA_URL");
		}
		else
		{
			new AlertDialog.Builder(this)
			.setTitle("Sorry")
			.setMessage("You need to EnterNames first then store")
			.setPositiveButton("Back", null)
			.show();
		}
		
		File picture = new File(url);
		if(picture.exists()){

		 Bitmap myBitmap = BitmapFactory.decodeFile(picture.getAbsolutePath());
		 Bitmap smallpic = Bitmap.createScaledBitmap(myBitmap, 500, 500, true);
		 imgView.setImageBitmap(smallpic);

		}
		else
		{
			//Toast.makeText(this, "Picture not existed", Toast.LENGTH_LONG).show();	
			Log.d("error", "wrongwrongwrong");
		}

	}
	
	

}
