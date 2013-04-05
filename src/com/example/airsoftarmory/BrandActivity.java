package com.example.airsoftarmory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class BrandActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brand);
		
		View button1 = this.findViewById(R.id.aandk_button);
		button1.getBackground().setAlpha(190);
		
		View button2 = this.findViewById(R.id.aps_button);
		button2.getBackground().setAlpha(190);
		
		View button3 = this.findViewById(R.id.ares_button);
		button3.getBackground().setAlpha(190);
		
		View button4 = this.findViewById(R.id.cyma_button);
		button4.getBackground().setAlpha(190);
		
		View button5 = this.findViewById(R.id.classicarmy_button);
		button5.getBackground().setAlpha(190);
		
		View button6 = this.findViewById(R.id.dboys_button);
		button6.getBackground().setAlpha(190);
		
		View button7 = this.findViewById(R.id.echo1_button);
		button7.getBackground().setAlpha(190);
		
		View button8 = this.findViewById(R.id.gandg_button);
		button8.getBackground().setAlpha(190);
		
		View button9 = this.findViewById(R.id.gandp_button);
		button9.getBackground().setAlpha(190);
		
		View button10 = this.findViewById(R.id.ics_button);
		button10.getBackground().setAlpha(190);
		
		View button11 = this.findViewById(R.id.javelin_button);
		button11.getBackground().setAlpha(190);
		
		View button12 = this.findViewById(R.id.jg_button);
		button12.getBackground().setAlpha(190);
		
		View button13 = this.findViewById(R.id.kwa_button);
		button13.getBackground().setAlpha(190);
		
		View button14 = this.findViewById(R.id.kingarms_button);
		button14.getBackground().setAlpha(190);
		
		View button15 = this.findViewById(R.id.lct_button);
		button15.getBackground().setAlpha(190);
		
		View button16 = this.findViewById(R.id.lancertactical_button);
		button16.getBackground().setAlpha(190);
		
		View button17 = this.findViewById(R.id.src_button);
		button17.getBackground().setAlpha(190);
		
		View button18 = this.findViewById(R.id.socomgear_button);
		button18.getBackground().setAlpha(190);
		
		View button19 = this.findViewById(R.id.tsd_button);
		button19.getBackground().setAlpha(190);
		
		View button20 = this.findViewById(R.id.tokyomarui_button);
		button20.getBackground().setAlpha(190);
		
		View button21 = this.findViewById(R.id.vfcgb_button);
		button21.getBackground().setAlpha(190);
		
		View button22 = this.findViewById(R.id.we_button);
		button22.getBackground().setAlpha(190);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_brand, menu);
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
	public void goToBrandQuery(View view) {
							
		//respond to button press
		Intent intent = new Intent(this, BrandQueryActivity.class);
		Button pressed = (Button)view;
		String brandName = pressed.getText().toString();
		String callingClass = "brand";
		intent.putExtra("activity",brandName);
		intent.putExtra("calledFrom",callingClass);
		startActivity(intent);
	}
}
