package com.example.airsoftarmory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
				
		
		super.onCreate(savedInstanceState);
/*
        DatabaseHelper myDbHelper = new DatabaseHelper(this);
 
        try {
        	myDbHelper.createDataBase();
        } catch(IOException ioe) {
        	throw new Error("Unable to create database");
        }
 
        try { 
        	myDbHelper.openDataBase(); 
        }catch(SQLException sqle){
        	throw sqle;
        }
*/        
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	//View parameter is the view that was clicked
	public void goToMainSearch(View view) {
		
		//respond to button press
		Intent intent = new Intent(this, MainSearchActivity.class);
		startActivity(intent);
	}
	
	@Override
	public void onDestroy() {
	    super.onDestroy();  // Always call the superclass
	    
	    // Stop method tracing that the activity started during onCreate()
	    android.os.Debug.stopMethodTracing();
	}

}
