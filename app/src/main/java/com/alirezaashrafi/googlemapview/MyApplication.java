package com.alirezaashrafi.googlemapview;
import com.alirezaashrafi.library.GoogleMapViewConfigs;
import com.alirezaashrafi.library.MapType;


public class MyApplication extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();

        GoogleMapViewConfigs.setDefaultMapType(MapType.SATELLITE);
    }
}
