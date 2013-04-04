package com.example.airsoftarmory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
    
    public Cursor getStatsByName(String gunName) {
    	
    	SQLiteDatabase db=this.getReadableDatabase();
    	
    	Cursor cur = db.rawQuery("SELECT * from AirsoftGuns WHERE Name=?", new String [] {gunName});
 	   	return cur;
    }

 
	@Override
	public void onCreate(SQLiteDatabase db) {
 
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
}