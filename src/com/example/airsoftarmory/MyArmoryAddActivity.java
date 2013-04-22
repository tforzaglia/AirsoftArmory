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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;

public class MyArmoryAddActivity extends Activity {

	private static final int PICK_IMAGE = 1;
	private ImageView image;
	private Spinner brandSpinner;
	private EditText modelEditText;
	private Spinner fpsSpinner;
	private Spinner rofSpinner;
	private Spinner typeSpinner;
	private Spinner propulsionSpinner;
	private Spinner blowbackSpinner;
	private EditText weightEditText;
	private Spinner barrellengthSpinner;
	private Spinner barreldiameterSpinner;
	private EditText upgradesEditText;
	private EditText attachmentsEditText;
	private EditText additionalinfoEditText;
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
		fpsSpinner = (Spinner) findViewById(R.id.fpsSpinner);
		fpsSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());		
		rofSpinner = (Spinner) findViewById(R.id.rofSpinner);
		rofSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());		
		typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
		typeSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());		
		propulsionSpinner = (Spinner) findViewById(R.id.propulsionSpinner);
		propulsionSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());		
		blowbackSpinner = (Spinner) findViewById(R.id.blowbackSpinner);
		blowbackSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());		
		barrellengthSpinner = (Spinner) findViewById(R.id.barrellengthSpinner);
		barrellengthSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());		
		barreldiameterSpinner = (Spinner) findViewById(R.id.barreldiameterSpinner);
		barreldiameterSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	 }
	
	//get the selected dropdown list value  
	public void addListenerOnSubmitButton() {
		
		brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
		modelEditText = (EditText) findViewById(R.id.model_textField);
		fpsSpinner = (Spinner) findViewById(R.id.fpsSpinner);
		rofSpinner = (Spinner) findViewById(R.id.rofSpinner);
		typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
		propulsionSpinner = (Spinner) findViewById(R.id.propulsionSpinner);
		blowbackSpinner = (Spinner) findViewById(R.id.blowbackSpinner);
		weightEditText = (EditText) findViewById(R.id.weight_textField);
		barrellengthSpinner = (Spinner) findViewById(R.id.barrellengthSpinner);
		barreldiameterSpinner = (Spinner) findViewById(R.id.barreldiameterSpinner);
		upgradesEditText = (EditText) findViewById(R.id.upgrades_textField);
		attachmentsEditText = (EditText) findViewById(R.id.attachments_textField);
		additionalinfoEditText = (EditText) findViewById(R.id.additionalinfo_textField);
		submit = (Button) findViewById(R.id.submitAdd_button);	 
		submit.setOnClickListener(new OnClickListener() {
	 
		@Override
		public void onClick(View v) {
			
			String manufacturer = String.valueOf(brandSpinner.getSelectedItem());
			String model = modelEditText.getText().toString();
			String fps = String.valueOf(fpsSpinner.getSelectedItem());
			String rof = String.valueOf(rofSpinner.getSelectedItem());
			String type = String.valueOf(typeSpinner.getSelectedItem());
			String propulsion = String.valueOf(propulsionSpinner.getSelectedItem());
			String blowback = String.valueOf(blowbackSpinner.getSelectedItem());
			String weight = weightEditText.getText().toString();
			String barrellength = String.valueOf(barrellengthSpinner.getSelectedItem());
			String barreldiameter = String.valueOf(barreldiameterSpinner.getSelectedItem());
			String upgrades = upgradesEditText.getText().toString();
			String attachments = attachmentsEditText.getText().toString();
			String additionalinfo = additionalinfoEditText.getText().toString();
			
			System.out.println("manufacturer: " + manufacturer + "\n" +
								"model: " + model + "\n" +
								"fps: " + fps + "\n" +
								"rof: " + rof + "\n" +
								"type: " + type + "\n" +
								"propulsion: " + propulsion + "\n" +
								"blowback: " + blowback + "\n" +
								"weight: " + weight + "\n" +
								"inner barrel length: " + barrellength + "\n" +
								"inner barrel diameter: " + barreldiameter + "\n" +
								"upgrades: " + upgrades + "\n" +
								"attachments: " + attachments + "\n" +
								"addtional info: " + additionalinfo + "\n" 
					);
		}
		});
	}
}