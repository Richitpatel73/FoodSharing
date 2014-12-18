package com.utkarsh.foodsharing;

import java.util.ArrayList;

import com.utkarsh.foodsharing.SQLite.SQLiteDatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lvMain;
	private SQLiteDatabase db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startService(new Intent(getBaseContext(), JSON_Service.class));

		lvMain = (ListView) findViewById(R.id.lvMain);
		db = new SQLiteDatabase(getBaseContext());
		ArrayList<String> list = db.getAllInfo();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), android.R.layout.simple_list_item_1, list);
		lvMain.setAdapter(adapter);

		
		
		

	}

}
