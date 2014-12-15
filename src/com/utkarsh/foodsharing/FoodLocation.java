package com.utkarsh.foodsharing;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;
import android.app.Activity;
import android.os.Bundle;

public class FoodLocation extends Activity {
	static final LatLng CHADIGARH = new LatLng(30.75, 76.78);
	static final LatLng MYSORE = new LatLng(12.3000, 76.6500);
	static final LatLng SURAT = new LatLng(21.1700, 72.8300);
	static final LatLng NEW_DELHI = new LatLng(28.6139, 77.2089);
	static final LatLng DELHI_CENTRAL = new LatLng(28.36, 77.12);
	static final LatLng TIRUCHIRAPPLLI = new LatLng(10.7756, 78.6923);
	static final LatLng JAMSHEDPUR = new LatLng(22.8, 86.18);
	static final LatLng MANGALORE = new LatLng(12.961, 74.89);
	static final LatLng RAJKOT = new LatLng(22.3000, 70.7833);
	static final LatLng KANPUR = new LatLng(26.4607, 80.3334);
	static final LatLng NAVI_MUMBAI = new LatLng(19.12, 73.02);
	static final LatLng BANGALORE = new LatLng(12.9667, 77.5667);
	static final LatLng CHENNAI = new LatLng(13.0839, 80.2700);
	static final LatLng ROURKELA = new LatLng(22.2, 84.88);
	static final LatLng MANDYA = new LatLng(12.52, 76.9);

	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodmap);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		Marker ChandiGarh = map.addMarker(new MarkerOptions().position(
				CHADIGARH).title("ChandiGarh"));
		Marker Mysore = map.addMarker(new MarkerOptions().position(MYSORE)
				.title("MySore"));
		Marker Surat = map.addMarker(new MarkerOptions().position(SURAT).title(
				"Surat"));
		Marker New_Delhi = map.addMarker(new MarkerOptions()
				.position(NEW_DELHI).title("New Delhi"));
		Marker Delhi_Central = map.addMarker(new MarkerOptions().position(
				DELHI_CENTRAL).title("Delfi Central"));
		Marker Tirucchirapplli = map.addMarker(new MarkerOptions().position(
				TIRUCHIRAPPLLI).title("Tiruchirapplli(Trichy)"));
		Marker Jamshedpur = map.addMarker(new MarkerOptions().position(
				JAMSHEDPUR).title("Jamshedpur"));
		Marker Mangalore = map.addMarker(new MarkerOptions()
				.position(MANGALORE).title("Mangalore"));
		Marker Rajkot = map.addMarker(new MarkerOptions().position(RAJKOT)
				.title("Rajkot"));
		Marker Kanpur = map.addMarker(new MarkerOptions().position(KANPUR)
				.title("Kanpur"));
		Marker Navi_Mumbai = map.addMarker(new MarkerOptions().position(
				NAVI_MUMBAI).title("Navi Mumbai"));
		Marker Bangalore = map.addMarker(new MarkerOptions()
				.position(BANGALORE).title("Bangalore"));
		Marker Chennai = map.addMarker(new MarkerOptions().position(CHENNAI)
				.title("Chennai"));
		Marker Rourkela = map.addMarker(new MarkerOptions().position(ROURKELA)
				.title("Rourkela"));
		Marker Mandya = map.addMarker(new MarkerOptions().position(MANDYA)
				.title("Mandya"));

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(BANGALORE, 15));
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

		Marker Chandigarh = map.addMarker(new MarkerOptions()
				.position(CHADIGARH)
				.title("Chandigarh")
				.snippet("Cleanest Indian City")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_launcher)));

		if (map != null) {
			Marker bangalore = map.addMarker(new MarkerOptions().position(
					BANGALORE).title("Hamburg"));
			Marker chadigarh = map.addMarker(new MarkerOptions()
					.position(CHADIGARH)
					.title("Kiel")
					.snippet("Kiel is cool")
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.ic_launcher)));
		}
	}
}
