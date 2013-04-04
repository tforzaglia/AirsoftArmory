package com.example.airsoftarmory;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class GunInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//create the text view
	    TextView textView = new TextView(this);
		textView.setTextSize(40);
	    Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        
        DatabaseHelper dbHelper = new DatabaseHelper(this);
		Cursor cursor = dbHelper.getStatsByName(activity);
		cursor.moveToFirst();
		ArrayList<String> stats = new ArrayList<String>();
		while (cursor.isAfterLast() == false) {
			
			String name = cursor.getString(cursor.getColumnIndex("Name"));
			String brand = cursor.getString(cursor.getColumnIndex("Brand"));
			String type = cursor.getString(cursor.getColumnIndex("Type"));
			String subtype = cursor.getString(cursor.getColumnIndex("SubType"));
			String blowback = cursor.getString(cursor.getColumnIndex("Blowback"));
			String propulsion = cursor.getString(cursor.getColumnIndex("Propulsion"));
			String fps = cursor.getString(cursor.getColumnIndex("FPS"));
			String rof = cursor.getString(cursor.getColumnIndex("ROF"));
			String length = cursor.getString(cursor.getColumnIndex("InnerBarrelLength"));
			String diameter = cursor.getString(cursor.getColumnIndex("InnerBarrelDiameter"));
				
			stats.add(name);
			stats.add(brand);
			stats.add(type);
			stats.add(subtype);
			stats.add(blowback);
			stats.add(propulsion);
			stats.add(fps);
			stats.add(rof);
			stats.add(length);
			stats.add(diameter);
			
	        cursor.moveToNext();
		}
		
		//Debugging -- works
        for(int j = 0; j < stats.size(); j++) {
        	System.out.println(stats.get(j));
        }
        //textView.setText("test");
        textView.setText("Gun Name: " + stats.get(0) + "\n" + "Manufacturer: " + stats.get(1) + "\n" + "Gun Type: " + stats.get(2) + "\n" + 
        		"Gun Sub-Type: " + stats.get(3) + "\n" + "Blowback?: " + stats.get(4) + "\n" + "Propulsion: " + stats.get(5) + "\n" +
        		"FPS: " + stats.get(6) + "\n" + "ROF: " + stats.get(7) + "\n" + 
        		"Inner Barrel Length: " + stats.get(8) + "\n" + "Inner Barrel Diameter: " + stats.get(9) + "\n");        
        textView.setTextSize(textView.getTextSize() - 50.0f);
        setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gun_info, menu);
		return true;
	}

}
