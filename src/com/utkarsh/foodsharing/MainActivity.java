package com.utkarsh.foodsharing;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.utkarsh.foodsharing.SQLite.SQLiteDatabase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView lvMain;
	private SQLiteDatabase db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new FetchJSONTask(this).execute();
		
		lvMain = (ListView) findViewById(R.id.lvMain);
		/*db = new SQLiteDatabase(getBaseContext());
		ArrayList<String> list = db.getAllInfo();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), android.R.layout.simple_list_item_1, list);
		lvMain.setAdapter(adapter);*/

		
		
		

	}
	protected void setArrayList(ArrayList<String> list){
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), android.R.layout.simple_list_item_1, list);
		lvMain.setAdapter(adapter);
		//Toast.makeText(getBaseContext(), "success", Toast.LENGTH_LONG).show();
	}

}
