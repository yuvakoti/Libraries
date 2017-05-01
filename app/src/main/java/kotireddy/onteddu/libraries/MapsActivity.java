package kotireddy.onteddu.libraries;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latDouble,longDouble;
    private String address= "",name="";
    private TextView addressTV,nameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        addressTV = (TextView) findViewById(R.id.infotext);
        nameTV = (TextView) findViewById(R.id.name);
        Intent intent = getIntent();
        String lat = intent.getStringExtra("lat");
        String longi = intent.getStringExtra("long");
        latDouble = Double.parseDouble(lat);
        longDouble = Double.parseDouble(longi);
        address = intent.getStringExtra("address");
        name = intent.getStringExtra("name");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = new LatLng(latDouble, longDouble);
        mMap.addMarker(new MarkerOptions().position(location).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.setMaxZoomPreference(85);
        nameTV.setText(name);
        addressTV.setText(address);
    }
}
