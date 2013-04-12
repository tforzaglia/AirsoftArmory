package com.example.airsoftarmory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class MyArmoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_armory);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_my_armory, menu);
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
	
	//View parameter is the view that was clicked
	public void goToArmorySearch(View view) {
			
		//respond to button press
		//Intent intent = new Intent(this, MainSearchActivity.class);
		//startActivity(intent);
	}
		
	//View parameter is the view that was clicked
	public void goToArmoryAdd(View view) {
			
		//respond to button press
		//Intent intent = new Intent(this, MainSearchActivity.class);
		//startActivity(intent);
	}
		
	//View parameter is the view that was clicked
	public void goToArmoryRemove(View view) {
			
		//respond to button press
		//Intent intent = new Intent(this, MainSearchActivity.class);
		//startActivity(intent);
	}

}
