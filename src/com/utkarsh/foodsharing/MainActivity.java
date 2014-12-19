package com.utkarsh.foodsharing;

import java.util.ArrayList;

import com.utkarsh.foodsharing.SQLite.SQLiteDatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lvMain;
	private static final String LAT_KEY = "lat";
	private static final String LNG_KEY = "lng";
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new FetchJSONTask(this).execute();
		db = new SQLiteDatabase(getBaseContext());
		lvMain = (ListView) findViewById(R.id.lvMain);
		lvMain.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView parent, View view,
					int position, long id) {

				Intent intent = new Intent(getBaseContext(), FoodLocation.class);
				intent.putExtra(LAT_KEY, (db.getAllLat()).get(position));
				intent.putExtra(LNG_KEY, (db.getAllLng()).get(position));
				startActivity(intent);
			}
		});

	}

	protected void setArrayList(ArrayList<String> list) {

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), android.R.layout.simple_list_item_1, list);
		lvMain.setAdapter(adapter);

	}

}
