package com.alirezaashrafi.googlemapview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alirezaashrafi.library.GoogleMapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleMapView googleMapView = (GoogleMapView) findViewById(R.id.googleMapView);
        googleMapView.setMapScale(GoogleMapView.MapScale.HIGH);
    }
}
