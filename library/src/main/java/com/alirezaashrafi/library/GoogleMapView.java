package com.alirezaashrafi.library;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.alirezaashrafi.library.interfaces.OnBitmapLoad;
import com.alirezaashrafi.library.interfaces.OnDrawableLoad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * HexDownload Created by AlirezaAshrafi on 2/17/2018.
 */

public class GoogleMapView extends ImageView {
    private final String TAG = this.getClass().getName();


    public static class Configs{
        public static float latitude = 35.744920f;
        public static float longitude = 51.376303f;
        public static int mapZoom = 17;
        public static int mapHeight = 640;
        public static int mapWidth = 640;
        public static int mapBlur = 0;
        public static boolean cacheMap = false;
        public static int mapScale = 1;
        public static String maptype = "satellite";


    }
    public GoogleMapView(Context context) {
        super(context);
        init(context, null);

    }

    public GoogleMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public GoogleMapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    public GoogleMapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public float getLatitude() {
        return Configs.latitude;
    }

    public void setLatitude(float latitude) {
        Configs.latitude = latitude;
        load();
    }

    public float getLongitude() {
        return Configs.longitude;
    }

    public void setLongitude(float longitude) {
        Configs.longitude = longitude;
        load();
    }

    public int getMapZoom() {
        return Configs.mapZoom;
    }

    public void setMapZoom(int mapZoom) {
        Configs.mapZoom = mapZoom;
        load();
    }

    public int getMapHeight() {
        return Configs.mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        Configs.mapHeight = mapHeight;
        load();
    }

    public int getMapWidth() {
        return Configs.mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        Configs.mapWidth = mapWidth;
        load();
    }

    public int getMapBlur() {
        return Configs.mapBlur;
    }

    public void setMapBlur(int mapBlur) {
        Configs.mapBlur = mapBlur;
        load();
    }

    public boolean isCacheMap() {
        return Configs.cacheMap;
    }

    public void setCacheMap(boolean cacheMap) {
        Configs.cacheMap = cacheMap;
        load();
    }

    public void setMapType(MapType mapType) {


        setMapType(mapType.getValue());

        load();
    }

    public String getMapType() {
        return Configs.maptype;
    }

    public void setMapScale(MapScale mapScale) {
        Configs.mapScale = mapScale.getValue();
        load();
    }

    public int getMapScale() {
        return Configs.mapScale;
    }

    public enum MapType {
        satellite(0),
        roadmap(1),
        hybrid(2),
        terrain(3);
        private int value;
        MapType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    private void setMapType(int type) {
        switch (type) {
            case 0:
                Configs.maptype = "satellite";
                break;
            case 1:
                Configs.maptype = "roadmap";
                break;
            case 2:
                Configs.maptype = "hybrid";
                break;
            case 3:
                Configs.maptype = "terrain";
                break;
        }
    }

    public enum MapScale {
        LOW(1),
        HIGH(2);
        private int value;
        MapScale(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }


    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.GoogleMapView);
            Configs.latitude = typedArray.getFloat(R.styleable.GoogleMapView_setLatitude, Configs.latitude);
            Configs.longitude = typedArray.getFloat(R.styleable.GoogleMapView_setLongitude, Configs.longitude);
            Configs.mapZoom = typedArray.getInt(R.styleable.GoogleMapView_setMapZoom, Configs.mapZoom);
            Configs.mapHeight = typedArray.getInt(R.styleable.GoogleMapView_setMapHeight, Configs.mapHeight);
            Configs.mapWidth = typedArray.getInt(R.styleable.GoogleMapView_setMapWidth, Configs.mapWidth);
            Configs.mapBlur = typedArray.getInt(R.styleable.GoogleMapView_setMapBlur, Configs.mapBlur);
            Configs.cacheMap = typedArray.getBoolean(R.styleable.GoogleMapView_setCacheMap, Configs.cacheMap);
            Configs.mapScale = typedArray.getInt(R.styleable.GoogleMapView_setMapScale, Configs.mapScale);
            int mapType = typedArray.getInt(R.styleable.GoogleMapView_setMapType, 0);
            setMapType(mapType);

            try {
                load();
            } finally {
                invalidate();
                requestLayout();
                typedArray.recycle();
            }
        }
    }

    private void load() {
        load(Configs.mapZoom
                , Configs.mapBlur
                , Configs.latitude
                , Configs.longitude
                , Configs.maptype
                , Configs.mapWidth
                , Configs.mapHeight
                , Configs.cacheMap
                , Configs.mapScale);
    }

    private void load(int zoom, int blur, float latitude, float longitude, final String maptype, int width, int height, boolean cache, int scale) {

        List<Get> gets = new ArrayList<>();
        gets.add(new Get().setKey("center").setValue(String.valueOf(latitude) + "," + String.valueOf(longitude)));
        gets.add(new Get().setKey("zoom").setValue(zoom));
        gets.add(new Get().setKey("size").setValue(String.valueOf(width) + "x" + String.valueOf(height)));
        gets.add(new Get().setKey("maptype").setValue(maptype));
        gets.add(new Get().setKey("scale").setValue(scale));
        gets.add(new Get().setKey("format").setValue("jpg"));

        String link = buildURI("https://maps.googleapis.com/maps/api/staticmap", gets);
        if (cache) {
            Pico.with(getContext()).from(link).smartCache().setBlur(blur).into(new OnBitmapLoad() {
                @Override
                public void bitmap(Bitmap bitmap) {

                    if (Configs.maptype.equals(maptype)){
                        setImageBitmap(bitmap);
                        invalidate();
                        requestLayout();
                    }

                }
            });
        } else {
            Pico.with(getContext()).from(link).setBlur(blur).into(new OnBitmapLoad() {
                @Override
                public void bitmap(Bitmap bitmap) {
                    if (Configs.maptype.equals(maptype)){
                        setImageBitmap(bitmap);
                        invalidate();
                        requestLayout();
                    }
                }
            });
        }
    }


    private String buildURI(String url, List<Get> gets) {
        Uri.Builder builder = Uri.parse(url).buildUpon();
        for (int i = 0; i < gets.size(); i++) {
            builder.appendQueryParameter(gets.get(i).getKey(), gets.get(i).getValue());
        }
        return builder.toString();
    }

}
