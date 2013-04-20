package com.example.airsoftarmory;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;

public class MyArmoryAddActivity extends Activity {

	private ImageView image;
	private static final int PICK_IMAGE = 1;
	private Spinner brandSpinner;
	private Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		
		setContentView(R.layout.activity_my_armory_add);
		
		addListenerOnButton();
		addListenerOnSubmitButton();
		addListenerOnSpinnerItemSelection();	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_my_armory_add, menu);
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
	
	public void addListenerOnButton() {
		 
		image = (ImageView) findViewById(R.id.tempButton);
		image.setOnClickListener(new OnClickListener() {
 
		@Override
		public void onClick(View arg0) {
			
			Intent intent = new Intent();
			intent.setType("image/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
		}
		});	
	
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK){
			Uri targetUri = data.getData();
			image.setImageURI(targetUri);
		}
	}
	
	public void addListenerOnSpinnerItemSelection() {
		
		brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
		brandSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	 }
	
	//get the selected dropdown list value  
	public void addListenerOnSubmitButton() {
		
		brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
		submit = (Button) findViewById(R.id.submitAdd_button);	 
		submit.setOnClickListener(new OnClickListener() {
	 
		@Override
		public void onClick(View v) {
			
			String str = String.valueOf(brandSpinner.getSelectedItem());
			System.out.println(str);
		}
		});
	}
}