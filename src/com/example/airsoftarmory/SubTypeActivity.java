package com.example.airsoftarmory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.support.v4.app.NavUtils;

public class SubTypeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ScrollView scrollView= new ScrollView(this);
	    LinearLayout mainLayout = new LinearLayout(this);
	    mainLayout.setOrientation(LinearLayout.VERTICAL);
	    mainLayout.setBackgroundResource(R.drawable.background);
	    
	    Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        
        String[] rifles = {"AK", "AUG", "FAL", "G36", "GALIL", "HK416/417", "L85", "M4/M16/AR", "M14", "M249/M60/MK23/PKM", 
        		"MASADA/ACR", "MP44", "SCAR", "SIG 550/551/552/556", "TAR-21", "THOMPSON", "XCR"};
        String[] supports = {""};
        String[] snipers = {"DRAGUNOV", "M24/M28", "SR25"};
        String[] smgs = {"FN2000", "MP5", "MP7", "MP9", "MP40", "P90", "PDW", "UMP", "UZI"};
        String[] pistols = {"1911", "DESERT EAGLE", "GLOCK", "M9", "MAC10/11", "USP"};
        String[] specials = {"MGL", "Minigun"};
		List<String> selection = new ArrayList<String>();
		
		if(activity.equals("Rifle")) {
			selection = Arrays.asList(rifles);
		}
		else if(activity.equals("Support")) {
			selection = Arrays.asList(supports);
		}
		else if(activity.equals("Sniper")) {
			selection = Arrays.asList(snipers);
		}
		else if(activity.equals("SMG")) {
			selection = Arrays.asList(smgs);
		}
		else if(activity.equals("Pistol")) {
			selection = Arrays.asList(pistols);
		}
		else if(activity.equals("Special")) {
			selection = Arrays.asList(specials);
		}
		
		for(int i = 0; i < selection.size(); i++) {
			LinearLayout ll = new LinearLayout(this);			
	        Button b = new Button(this);
	        b.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 goToQuery(v);
	             }
	         });
	        LayoutParams params = new LayoutParams(
	                LayoutParams.MATCH_PARENT,      
	                LayoutParams.MATCH_PARENT
	        );
	        //left, top, right, bottom
	        params.setMargins(25, 40, 25, 40);
	        b.setLayoutParams(params);
	        b.setText(selection.get(i));   
	        b.setBackgroundResource(R.drawable.buttons);	        
	        ll.addView(b);                    
	        mainLayout.addView(ll);
		}
		
		scrollView.addView(mainLayout);
	    setContentView(scrollView);
		
	}
	
	//View parameter is the view that was clicked
	public void goToQuery(View view) {
									
		//respond to button press
		Intent intent = new Intent(this, BrandQueryActivity.class);
		Button pressed = (Button)view;
		String subtype = pressed.getText().toString();
		String callingClass = "type";
		intent.putExtra("calledFrom",callingClass);
		intent.putExtra("activity",subtype);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sub_type, menu);
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

}
