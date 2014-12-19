package com.utkarsh.foodsharing;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

public class FoodLocation extends Activity {

	private GoogleMap map;
	Location myLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodmap);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		Intent intent = getIntent();

		LatLng position = getLatLng(
				Double.parseDouble(intent.getStringExtra("lat")),
				Double.parseDouble(intent.getStringExtra("lng")));
		Marker marker = map.addMarker(new MarkerOptions().position(position)
				.title("Orphanage"));
		marker.setIcon(BitmapDescriptorFactory
				.fromResource(R.drawable.ic_launcher));
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		map.setMyLocationEnabled(true);
		myLocation = map.getMyLocation();
		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(position).zoom(12).build();
		map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

	}

	private LatLng getLatLng(Double lat, Double lng) {

		return new LatLng(lat, lng);

	}
}
