package com.alirezaashrafi.googlemapview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alirezaashrafi.library.GoogleMapView;
import com.alirezaashrafi.library.MapScale;
import com.alirezaashrafi.library.MapType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleMapView googleMapView = (GoogleMapView) findViewById(R.id.googleMapView);
        googleMapView.setLatitude(35.744920f);
        googleMapView.setLongitude(51.376303f);
        googleMapView.setMapType(MapType.SATELLITE);
        googleMapView.setMapScale(MapScale.HIGH);
        googleMapView.setMapZoom(15);
        googleMapView.setMapWidth(350);
        googleMapView.setMapHeight(350);
        googleMapView.setZoomable(this);
        //googleMapView.setLocation(location);
    }



}
