package com.alirezaashrafi.googlemapview;

import android.util.Log;

import com.alirezaashrafi.library.GoogleMapViewConfigs;

/**
 * GoogleMapView Created by AlirezaAshrafi on 2/17/2018.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        GoogleMapViewConfigs.mapType = GoogleMapViewConfigs.SATELLITE;
        GoogleMapViewConfigs.cacheMap = true;
    }
}
