package com.example.airsoftarmory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class MainSearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_search);
		
		View button1 = this.findViewById(R.id.brand_button);
		button1.getBackground().setAlpha(190);
		
		View button2 = this.findViewById(R.id.type_button);
		button2.getBackground().setAlpha(190);
		
		View button3 = this.findViewById(R.id.propulsion_button);
		button3.getBackground().setAlpha(190);
		
		View button4 = this.findViewById(R.id.fps_button);
		button4.getBackground().setAlpha(190);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_search, menu);
		return true;
	}
	
	//View parameter is the view that was clicked
	public void goToBrandSearch(View view) {
			
		//respond to button press
		Intent intent = new Intent(this, BrandActivity.class);
		startActivity(intent);
	}
	
	//View parameter is the view that was clicked
	public void goToTypeSearch(View view) {
				
		//respond to button press
		Intent intent = new Intent(this, TypeActivity.class);
		startActivity(intent);
	}
	
	//View parameter is the view that was clicked
	public void goToPropulsionSearch(View view) {
					
		//respond to button press
		Intent intent = new Intent(this, PropulsionActivity.class);
		startActivity(intent);
	}
		
	//View parameter is the view that was clicked
	public void goToFpsSearch(View view) {
					
		//respond to button press
		Intent intent = new Intent(this, FpsActivity.class);
		startActivity(intent);
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

}
