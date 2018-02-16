package com.alirezaashrafi.googlemapview;

import com.alirezaashrafi.library.GoogleMapView;

/**
 * GoogleMapView Created by AlirezaAshrafi on 2/17/2018.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        GoogleMapView.Configs.maptype = "roadmap";
    }
}
