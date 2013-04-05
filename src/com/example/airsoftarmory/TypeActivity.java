package com.example.airsoftarmory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class TypeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_type);
	
		View button1 = this.findViewById(R.id.rifle_button);
		button1.getBackground().setAlpha(190);
		
		View button2 = this.findViewById(R.id.support_button);
		button2.getBackground().setAlpha(190);
		
		View button3 = this.findViewById(R.id.sniper_button);
		button3.getBackground().setAlpha(190);
		
		View button4 = this.findViewById(R.id.smg_button);
		button4.getBackground().setAlpha(190);
		
		View button5 = this.findViewById(R.id.pistol_button);
		button5.getBackground().setAlpha(190);
		
		View button6 = this.findViewById(R.id.special_button);
		button6.getBackground().setAlpha(190);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_type, menu);
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
	
	public void goToSubType(View view) {
		
		//respond to button press
		Intent intent = new Intent(this, SubTypeActivity.class);
		Button pressed = (Button)view;
		String type = pressed.getText().toString();
		intent.putExtra("activity",type);
		startActivity(intent);
	}
}
