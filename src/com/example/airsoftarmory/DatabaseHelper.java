package com.example.airsoftarmory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	//The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.example.airsoftarmory/databases/";
 
    private static String DB_NAME = "airsoftArmory";
 
    private SQLiteDatabase myDataBase; 
 
    private final Context myContext;
    
    static final String colId="_id";
    static final String colName="Name";
    static final String colBrand="Brand";
    static final String colLocale="locale";
    static final String gunTable="AirsoftGuns";
    
    Cursor cursor;
    
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DatabaseHelper(Context context) {
 
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
    }	
    
    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{
 
    	boolean dbExist = checkDataBase();
 
    	if(dbExist) {
    		//do nothing - database already exist
    	}else{
    		//By calling this method an empty database will be created into the default system path
               //of your application so we are gonna be able to overwrite that database with our database.
        	this.getReadableDatabase();
        	try {
    			copyDataBase();
    		} catch (IOException e) {
        		throw new Error("Error copying database");
        	}
    	} 	
    }
    
    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){
 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    	}catch(SQLiteException e){
    		//database does't exist yet
    	}
 
    	if(checkDB != null){
    		checkDB.close();
    	}
 
    	return checkDB != null ? true : false;
    }
    
    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transferring bytestream.
     * */
    private void copyDataBase() throws IOException{
 
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	FileOutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the input file to the output file
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
    }
    
    public void openDataBase() throws SQLException{
    	 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }
 
    @Override
	public synchronized void close() {
    	
    	if(myDataBase != null) {
    		myDataBase.close();
    	}
 
    	super.close();
	}
    
    public Cursor getAllByBrand(String brandName) {
    	
    	SQLiteDatabase db=this.getReadableDatabase();
    	
    	Cursor cur = db.rawQuery("SELECT Name from AirsoftGuns WHERE Brand=?", new String [] {brandName});
 	   	return cur;
    }
    
    public Cursor getAllByType(String subtype) {
    	
    	SQLiteDatabase db=this.getReadableDatabase();
    	
    	Cursor cur = db.rawQuery("SELECT Name from AirsoftGuns WHERE SubType=?", new String [] {subtype});
 	   	return cur;
    }
    
    public Cursor getAllByPropulsion(String propulsiontype) {
    	
    	SQLiteDatabase db=this.getReadableDatabase();
    	
    	Cursor cur = db.rawQuery("SELECT Name from AirsoftGuns WHERE Propulsion=?", new String [] {propulsiontype});
 	   	return cur;
    }
    
    public Cursor getAllByFps(String fps) {
    	
    	String high = "0";
    	String low = "0";
    	if(fps.equals("Less than 200")){
    		high = "199";
    		low = "0";
    	}
    	if(fps.equals("200 to 250")){
    		high = "249";
    		low = "200";
    	}
    	if(fps.equals("250 to 300")){
    		high = "299";
    		low = "250";
    	}
    	if(fps.equals("300 to 350")){
    		high = "349";
    		low = "300";
    	}
    	if(fps.equals("350 to 400")){
    		high = "399";
    		low = "350";
    	}
    	if(fps.equals("400 to 450")){
    		high = "449";
    		low = "400";
    	}
    	if(fps.equals("450 to 500")){
    		high = "499";
    		low = "450";
    	}
    	if(fps.equals("Greater than 500")){
    		high = "1000";
    		low = "500";
    	}
    	
    	SQLiteDatabase db=this.getReadableDatabase();
    	
    	Cursor cur = db.rawQuery("SELECT Name from AirsoftGuns WHERE FPS BETWEEN ? AND ?", new String [] {low, high});
 	   	return cur;
    }
    
    public Cursor getStatsByName(String gunName) {
    	
    	SQLiteDatabase db=this.getReadableDatabase();
    	
    	Cursor cur = db.rawQuery("SELECT * from AirsoftGuns WHERE Name=?", new String [] {gunName});
 	   	return cur;
    }
    
    public Cursor getAllInArmory() {
    	
    	SQLiteDatabase db=this.getReadableDatabase();
    	
    	Cursor cur = db.rawQuery("SELECT Model from MyArmory", new String [] {});
 	   	return cur;
    }
    
    public void insertRow(String brand, String model, String fps, String rof, String propulsion, String blowback, String weight, String length, 
    		String diameter, String upgrades, String attachments, String info) {
    	
    	SQLiteDatabase db=this.getWritableDatabase();
    	ContentValues cv=new ContentValues();
    	
    	cv.put("Brand", brand);
    	cv.put("Model", model);
    	cv.put("FPS", fps);
    	cv.put("ROF", rof);
    	cv.put("Propulsion", propulsion);
    	cv.put("Blowback", blowback);
    	cv.put("Weight", weight);
    	cv.put("BarrelLength", length);
    	cv.put("BarrelDiameter", diameter);
    	cv.put("Upgrades", upgrades);
    	cv.put("Attachments", attachments);
    	cv.put("AdditionalInfo", info);
    	
    	db.insert("MyArmory", "_id", cv);
    	
    	db.close();
    }
    
    public void deleteRow(String name) {
    	
    	SQLiteDatabase db=this.getWritableDatabase();
    	db.delete("MyArmory", "Model=?", new String []{name});
    	db.close();
    }

 
	@Override
	public void onCreate(SQLiteDatabase db) {
 
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
}