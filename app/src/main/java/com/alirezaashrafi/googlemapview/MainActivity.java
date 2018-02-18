package com.alirezaashrafi.googlemapview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alirezaashrafi.library.GoogleMapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initAttr(map1);
        initAttr(map2);
        initAttr(map3);
        initAttr(map4);
        initAttr(map5);
        initAttr(map6);
    }

    private void initAttr(GoogleMapView googleMapView) {
    }

    private GoogleMapView map1;
    private GoogleMapView map2;
    private GoogleMapView map3;
    private GoogleMapView map4;
    private GoogleMapView map5;
    private GoogleMapView map6;

    public void initViews() {
        map1 = (GoogleMapView) findViewById(R.id.map1);
        map2 = (GoogleMapView) findViewById(R.id.map2);
        map3 = (GoogleMapView) findViewById(R.id.map3);
        map4 = (GoogleMapView) findViewById(R.id.map4);
        map5 = (GoogleMapView) findViewById(R.id.map5);
        map6 = (GoogleMapView) findViewById(R.id.map6);
    }

}
