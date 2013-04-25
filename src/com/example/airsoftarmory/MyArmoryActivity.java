package com.example.airsoftarmory;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.support.v4.app.NavUtils;

public class MyArmoryActivity extends Activity {

	private Cursor cursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_armory);
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ll);
		
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,      
                LayoutParams.MATCH_PARENT
        );
		textView.setLayoutParams(params);
		
		DatabaseHelper dbHelper = new DatabaseHelper(this);
		cursor = dbHelper.getAllInArmory();
		cursor.moveToFirst();
		
		ArrayList<String> gunNames = new ArrayList<String>();
		while (cursor.isAfterLast() == false) {
	        	String gun = cursor.getString(cursor.getColumnIndex("Model"));
	        	gunNames.add(gun);
	        	cursor.moveToNext();
		}
		System.out.println(gunNames);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < gunNames.size(); i++) {
			sb.append(gunNames.get(i) + "\n");
		}
		textView.setText(sb.toString());
		System.out.println(sb.toString());
		
		linearLayout.addView(textView, 0);
		//linearLayout.invalidate();
		//setContentView(textView);
		//setContentView(R.layout.activity_my_armory);
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
		Intent intent = new Intent(this, MyArmoryAddActivity.class);
		startActivity(intent);
	}
		
	//View parameter is the view that was clicked
	public void goToArmoryRemove(View view) {
			
		//respond to button press
		//Intent intent = new Intent(this, MainSearchActivity.class);
		//startActivity(intent);
	}

}
