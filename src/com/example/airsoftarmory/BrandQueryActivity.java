package com.example.airsoftarmory;

import java.util.ArrayList;

import com.example.airsoftarmory.DatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class BrandQueryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ScrollView scrollView= new ScrollView(this);
		scrollView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	    LinearLayout mainLayout = new LinearLayout(this);
	    mainLayout.setOrientation(LinearLayout.VERTICAL);
	    mainLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	    mainLayout.setBackgroundResource(R.drawable.background);
	    //mainLayout.setPadding(16,16,25,50);
	    
		//create the text view --replaced later by button with gun names
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        
        DatabaseHelper dbHelper = new DatabaseHelper(this);
		Cursor cursor = dbHelper.getAllByBrand(activity);
		cursor.moveToFirst();
			
		ArrayList<String> gunNames = new ArrayList<String>();
		while (cursor.isAfterLast() == false) {
	        	String gun = cursor.getString(cursor.getColumnIndex("Name"));
	        	gunNames.add(gun);
	        	cursor.moveToNext();
		}
		
		for(int i = 0; i < gunNames.size(); i++) {
			LinearLayout ll = new LinearLayout(this);			
	        ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	        ll.setOrientation(LinearLayout.VERTICAL);
	        ll.setBackgroundResource(R.drawable.background);
	        ll.getPaddingLeft();
	        ll.setTag(i);
	        Button b = new Button(this);
	        b.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	        b.setTag(i);
	        b.setText(gunNames.get(i));            
	        ll.addView(b);                    
	        mainLayout.addView(ll);
		}
		
		scrollView.addView(mainLayout);
	    setContentView(scrollView);
	    
		//DEBUG
		System.out.println(gunNames);
		System.out.println(cursor.getCount());
		
		cursor.close();
		
		//HARD CODED FOR CYMA -- TESTING
        //textView.setText(gunNames.get(0).toString() + "\n" + gunNames.get(1).toString());        
        //setContentView(textView);
        
        //UNINSTALL THE APP IF DB IS UPDATED
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
