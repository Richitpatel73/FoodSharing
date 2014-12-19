package com.utkarsh.foodsharing.SQLite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabase extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME = "FoodSharingDB.db";
	public static final String TABLE_NAME = "InfoTable";
	public static final String COLUMN_NAME = "name";
	
	public SQLiteDatabase(Context context) {
		super(context, DATABASE_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(android.database.sqlite.SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table InfoTable " +
		 "(_id integer primary key AUTOINCREMENT, name text,address text,city text,state text,country text,pincode integer, phone text,lat text,lng text)");
	}

	@Override
	public void onUpgrade(android.database.sqlite.SQLiteDatabase db,
			int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS InfoTable");
		onCreate(db);
		
	}
	
	public boolean insertData(String name, String address, String city, String state, String country, int pincode, String phone, String lat, String lng ){
		android.database.sqlite.SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", name);
		contentValues.put("address", address);
		contentValues.put("city", city);
		contentValues.put("state", state);
		contentValues.put("country", country);
		contentValues.put("pincode", pincode);
		contentValues.put("phone", phone);
		contentValues.put("lat", lat);
		contentValues.put("lng", lng);
		
		db.insert("InfoTable", null, contentValues);
		
		return true;
	}
	
	public ArrayList<String> getAllName(){
		ArrayList<String> list = new ArrayList<String>();
		android.database.sqlite.SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select name from InfoTable", null);
		res.moveToFirst();
		while(res.isAfterLast() == false){
			list.add(res.getString(res.getColumnIndex(COLUMN_NAME)));
			res.moveToNext();
		}
		return list;
		
	}

}
