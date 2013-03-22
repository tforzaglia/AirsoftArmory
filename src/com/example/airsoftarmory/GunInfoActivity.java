package com.example.airsoftarmory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class GunInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//create the text view --replaced later by button with gun names
	    TextView textView = new TextView(this);
		textView.setTextSize(40);
	    Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        textView.setText(activity);        
        setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gun_info, menu);
		return true;
	}

}
