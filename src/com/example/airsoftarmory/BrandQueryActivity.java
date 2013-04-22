package com.example.airsoftarmory;

import java.util.ArrayList;

import com.example.airsoftarmory.DatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.support.v4.app.NavUtils;

public class BrandQueryActivity extends Activity {

	private Cursor cursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ScrollView scrollView= new ScrollView(this);
	    LinearLayout mainLayout = new LinearLayout(this);
	    mainLayout.setOrientation(LinearLayout.VERTICAL);
	    mainLayout.setBackgroundResource(R.drawable.background);
	    
	    Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        String calledFrom = intent.getStringExtra("calledFrom");
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        
        if(calledFrom.equals("brand")) {
        	cursor = dbHelper.getAllByBrand(activity);
        }
        if(calledFrom.equals("type")) {
        	cursor = dbHelper.getAllByType(activity);
        }
        if(calledFrom.equals("propulsion")) {
        	cursor = dbHelper.getAllByPropulsion(activity);
        }
        if(calledFrom.equals("fps")) {
        	cursor = dbHelper.getAllByFps(activity);
        }
		cursor.moveToFirst();
			
		ArrayList<String> gunNames = new ArrayList<String>();
		while (cursor.isAfterLast() == false) {
	        	String gun = cursor.getString(cursor.getColumnIndex("Name"));
	        	gunNames.add(gun);
	        	cursor.moveToNext();
		}
		
		for(int i = 0; i < gunNames.size(); i++) {
			LinearLayout ll = new LinearLayout(this);			
	        Button b = new Button(this);
	        b.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 goToGunInfo(v);
	             }
	         });
	        LayoutParams params = new LayoutParams(
	                LayoutParams.MATCH_PARENT,      
	                LayoutParams.MATCH_PARENT
	        );
	        //left, top, right, bottom
	        params.setMargins(25, 40, 25, 40);
	        b.setLayoutParams(params);
	        b.setText(gunNames.get(i));   
	        b.setBackgroundResource(R.drawable.buttons);	  
	        b.setTextColor(Color.WHITE);
	        ll.addView(b);                    
	        mainLayout.addView(ll);
		}
		scrollView.addView(mainLayout);
	    setContentView(scrollView);
		
		cursor.close();
	}
	
	//View parameter is the view that was clicked
	public void goToGunInfo(View view) {
								
		//respond to button press
		Intent intent = new Intent(this, GunInfoActivity.class);
		Button pressed = (Button)view;
		String gunName = pressed.getText().toString();
		intent.putExtra("activity",gunName);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_brand_query, menu);
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
