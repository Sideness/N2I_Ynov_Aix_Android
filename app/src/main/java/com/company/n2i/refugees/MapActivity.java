package com.company.n2i.refugees;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_flag, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

// Réalisation une action en fonction du drapeau cliqué
        if (id == R.id.action_french_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("fr");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "fr", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        else if (id == R.id.action_iran_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("fa");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "fa", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);

        }
        else if (id == R.id.action_saudi_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("ar");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "ar", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        else if (id == R.id.action_uk_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("en");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "en", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Tour Eiffel
        LatLng paris = new LatLng(48.858093, 2.294694);
        mMap.addMarker(new MarkerOptions()
                .position(paris)
                .title("Resto du coeur - Tour Eiffel")
                .snippet(getString(R.string.marker_food))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker_nourriture",200,200))));


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8453200, 2.3149500))
                .title("Centre Hospitalier Universitaire - Necker")
                .snippet(getString(R.string.marker_care))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker_soin",200,200))));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.837408, 2.338886))
                .title("Centre Hospitalier Universitaire - Cochin")
                .snippet(getString(R.string.marker_care))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker_soin",200,200))));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.842036, 2.322128))
                .title("Centre d'accueil - Tour Montparnasse")
                .snippet(getString(R.string.marker_sleep))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker_lit",200,200))));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.840193, 2.314575))
                .title("Freemoos")
                .snippet(getString(R.string.marker_cloths))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker_vetements",200,200))));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.844483, 2.324767))
                .title("McDonald's - Rue de rennes")
                .snippet(getString(R.string.marker_wifi))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker_wifi",200,200))));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.841235, 2.319907))
                .title("Fnac Paris Gare Montparnasse")
                .snippet(getString(R.string.marker_wifi))
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker_wifi",200,200))));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paris,15));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
    }

    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}
