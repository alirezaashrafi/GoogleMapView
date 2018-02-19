package com.alirezaashrafi.googlemapview;

import com.alirezaashrafi.library.GoogleMapViewConfigs;
import com.alirezaashrafi.library.MapScale;
import com.alirezaashrafi.library.MapType;


public class MyApplication extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();

        GoogleMapViewConfigs.setDefaultMapType(MapType.SATELLITE);
        GoogleMapViewConfigs.setDefaultLatitude(35.744920f);
        GoogleMapViewConfigs.setDefaultLongitude(51.376303f);
        GoogleMapViewConfigs.setDefaultMapZoom(17);
        GoogleMapViewConfigs.setDefaultMapScale(MapScale.HIGH);
        GoogleMapViewConfigs.setDefaultMapHeight(350);
        GoogleMapViewConfigs.setDefaultMapWidth(350);
    }
}
