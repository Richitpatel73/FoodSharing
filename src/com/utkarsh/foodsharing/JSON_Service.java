package com.utkarsh.foodsharing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class JSON_Service extends Service {
	String url = "http://dev.oneworkbook.com/ims/geo/countries";
	static String JSON = "";
	static InputStream is = null;
	final String TAG = "JsonParser.java";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public void onStart(Intent intent, int startId) {

		Toast.makeText(this, "Service Started", 200).show();

		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				try {
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(url);
					HttpResponse response = httpClient.execute(httpGet);
					HttpEntity httpEntity = response.getEntity();
					is = httpEntity.getContent();

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(is, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = null;
					while ((line = reader.readLine()) != null) {
						sb.append(line + "\n");
					}
					is.close();
					JSON = sb.toString();
					Log.e("data", JSON);

				} catch (Exception e) {
					Log.e(TAG, "Error converting result " + e.toString());
				}

				return null;
			}
		}.execute();

	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	}

}
