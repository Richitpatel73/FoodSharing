package com.utkarsh.foodsharing;

import java.util.ArrayList;

import com.utkarsh.foodsharing.ConnectionDetector;
import com.utkarsh.foodsharing.SQLite.SQLiteDatabase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	// flag for Internet connection status
	Boolean isInternetPresent = false;
	// Connection detector class
	ConnectionDetector cd;

	private ListView lvMain;
	private static final String LAT_KEY = "lat";
	private static final String LNG_KEY = "lng";
	
	SQLiteDatabase db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
<<<<<<< HEAD
		// creating connection detector class instance
		cd = new ConnectionDetector(getApplicationContext());
		// get Internet status
		isInternetPresent = cd.isConnectingToInternet();
		// check for Internet status
		if (!isInternetPresent) {
			// Internet connection is not present
			// Ask user to connect to Internet
			showAlertDialog(MainActivity.this, "No Internet Connection",
					"You don't have internet connection. "
					+"\n"+ "Enable it & restart the app.", false);

		} else {
=======
		
		new FetchJSONTask(this).execute();
		db = new SQLiteDatabase(getBaseContext());
		lvMain = (ListView) findViewById(R.id.lvMain);
		lvMain.setOnItemClickListener(new OnItemClickListener() {
>>>>>>> upstream/master

			new FetchJSONTask(this).execute();
			db = new SQLiteDatabase(getBaseContext());
			lvMain = (ListView) findViewById(R.id.lvMain);
			lvMain.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView parent, View view,
						int position, long id) {

					Intent intent = new Intent(getBaseContext(),
							FoodLocation.class);
					intent.putExtra(LAT_KEY, (db.getAllLat()).get(position));
					intent.putExtra(LNG_KEY, (db.getAllLng()).get(position));
					startActivity(intent);
				}
			});
		}

	}

	/**
	 * Function to display simple Alert Dialog
	 * 
	 * @param context
	 *            - application context
	 * @param title
	 *            - alert dialog title
	 * @param message
	 *            - alert message
	 * @param status
	 *            - success/failure (used to set icon)
	 * */
	public void showAlertDialog(Context context, String title, String message,
			Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);

		// Setting alert dialog icon
		alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

		// Setting OK Button
		alertDialog.setButton("Exit", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			finish();
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}

	protected void setArrayList(ArrayList<String> list) {

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), android.R.layout.simple_list_item_1, list);
		lvMain.setAdapter(adapter);

	}
	
	

}
