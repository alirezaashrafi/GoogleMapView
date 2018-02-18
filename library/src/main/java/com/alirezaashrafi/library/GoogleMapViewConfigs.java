package com.alirezaashrafi.library;

public class GoogleMapViewConfigs {
    static float latitude = 35.744920f;
    static float longitude = 51.376303f;
    static int mapZoom = 17;
    static int mapHeight = 640;
    static int mapWidth = 640;
    static int mapScale = 1;
    static String mapType = "satellite";

    public static float getDefaultLatitude() {
        return GoogleMapViewConfigs.latitude;
    }

    public static float getDefaultLongitude() {
        return GoogleMapViewConfigs.longitude;
    }

    public static int getDefaultMapZoom() {
        return GoogleMapViewConfigs.mapZoom;
    }

    public static int getDefaultMapHeight() {
        return GoogleMapViewConfigs.mapHeight;
    }

    public static int getDefaultMapWidth() {
        return GoogleMapViewConfigs.mapWidth;
    }



    public static int getDefaultMapScale() {
        return GoogleMapViewConfigs.mapScale;
    }

    public static String getDefaultMapType() {
        return GoogleMapViewConfigs.mapType;
    }


    public static void setDefaultLatitude(float latitude) {
        GoogleMapViewConfigs.latitude = latitude;
    }

    public static void setDefaultLongitude(float longitude) {
        GoogleMapViewConfigs.longitude = longitude;

    }

    public static void setDefaultMapZoom(int mapZoom) {
        GoogleMapViewConfigs.mapZoom = mapZoom;
    }

    public static void setDefaultMapHeight(int mapHeight) {
        GoogleMapViewConfigs.mapHeight = mapHeight;
    }

    public static void setDefaultMapWidth(int mapWidth) {
        GoogleMapViewConfigs.mapWidth = mapWidth;
    }



    public static void setDefaultMapScale(MapScale mapScale) {
        GoogleMapViewConfigs.mapScale = mapScale.getValue();
    }

    public static void setDefaultMapType(MapType mapType) {
        GoogleMapViewConfigs.mapType = mapType.getValue();
    }


}