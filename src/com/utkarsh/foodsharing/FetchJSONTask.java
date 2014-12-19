package com.utkarsh.foodsharing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.utkarsh.foodsharing.SQLite.SQLiteDatabase;

import android.content.Context;
import android.os.AsyncTask;

public class FetchJSONTask extends AsyncTask<Void, Void, ArrayList<String>> {
	
	
	
	MainActivity context;
	SQLiteDatabase db;
	public FetchJSONTask(MainActivity context) {
		
		this.context = context;
		
	}

	@Override
	protected ArrayList<String> doInBackground(Void... params) {
		db = new SQLiteDatabase(context);
		String json = null;
		try {
			InputStream is = context.getAssets().open("Data.json");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");
		    return parseJSON(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private ArrayList<String> parseJSON(String data) {
		ArrayList<String> list = new ArrayList<String>();
		String name, address, city, state ,country, phone, lat, lng;
		int pincode;
		try {
			JSONObject obj = new JSONObject(data);
			JSONArray dataArray = obj.getJSONArray("list");
			JSONObject jsonData;
			for(int i = 0; i < dataArray.length(); i++){
				jsonData = dataArray.getJSONObject(i);
				name = jsonData.getString("Name");
				address = jsonData.getString("Address");
				city = jsonData.getString("City");
				state = jsonData.getString("State");
				country = jsonData.getString("Country");
				phone = jsonData.getString("Mobile");
				lat = jsonData.getString("Lat");
				lng = jsonData.getString("Lng");
				pincode = jsonData.getInt("Pin");
				if(db.insertData(name, address, city, state, country, pincode, phone, lat, lng)){
					list = db.getAllName();
				}
				
				
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	@Override
	protected void onPostExecute(ArrayList<String> result) {
		// TODO Auto-generated method stub
		
		context.setArrayList(result);
	}

}
