package com.alirezaashrafi.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.alirezaashrafi.library.interfaces.OnBitmapLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * HexDownload Created by AlirezaAshrafi on 2/17/2018.
 */

public class GoogleMapView extends ImageView {
    private final String TAG = this.getClass().getName();

    private boolean init = false;
    private float latitude;
    private float longitude;
    private int mapZoom;
    private int mapHeight;
    private int mapWidth;
    private int mapBlur;
    private boolean cacheMap;
    private int mapScale;
    private String mapType;

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
        return this.latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
        load();
    }

    public void setLocation(Location location) {
        if (location != null) {
            latitude = (float)location.getLatitude();
            longitude = (float)location.getLongitude();
            load();
        }
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
        load();
    }

    public int getMapZoom() {
        return this.mapZoom;
    }

    public void setMapZoom(int mapZoom) {
        this.mapZoom = mapZoom;
        load();
    }

    public int getMapHeight() {
        return this.mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
        load();
    }

    public int getMapWidth() {
        return this.mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
        load();
    }

    public int getMapBlur() {
        return this.mapBlur;
    }

    public void setMapBlur(int mapBlur) {
        this.mapBlur = mapBlur;
        load();
    }

    public boolean isCacheMap() {
        return this.cacheMap;
    }

    public void setCacheMap(boolean cacheMap) {
        this.cacheMap = cacheMap;
        load();
    }

    public void setMapType(MapType mapType) {
        setMapType(mapType.getValue());
    }

    public String getMapType() {
        return this.mapType;
    }

    public void setMapScale(MapScale mapScale) {
        this.mapScale = mapScale.getValue();
        load();
    }

    public int getMapScale() {
        return this.mapScale;
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

        Log.i(TAG, "setMapType: " + type);
        switch (type) {
            case 0:
                this.mapType = "satellite";
                break;
            case 1:
                this.mapType = "roadmap";
                break;
            case 2:
                this.mapType = "hybrid";
                break;
            case 3:
                this.mapType = "terrain";
                break;

        }
        load();
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


    private void initVariables() {
        if (!init){
            init=true;
            latitude = GoogleMapViewConfigs.latitude;
            longitude = GoogleMapViewConfigs.longitude;
            mapZoom = GoogleMapViewConfigs.mapZoom;
            mapHeight = GoogleMapViewConfigs.mapHeight;
            mapWidth = GoogleMapViewConfigs.mapWidth;
            mapBlur = GoogleMapViewConfigs.mapBlur;
            cacheMap = GoogleMapViewConfigs.cacheMap;
            mapScale = GoogleMapViewConfigs.mapScale;
            mapType = GoogleMapViewConfigs.mapType;
        }

    }

    private void init(Context context, AttributeSet attributeSet) {
        initVariables();
        if (attributeSet != null) {

            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.GoogleMapView);
            this.latitude = typedArray.getFloat(R.styleable.GoogleMapView_setLatitude, this.latitude);
            this.longitude = typedArray.getFloat(R.styleable.GoogleMapView_setLongitude, this.longitude);
            this.mapZoom = typedArray.getInt(R.styleable.GoogleMapView_setMapZoom, this.mapZoom);
            this.mapHeight = typedArray.getInt(R.styleable.GoogleMapView_setMapHeight, this.mapHeight);
            this.mapWidth = typedArray.getInt(R.styleable.GoogleMapView_setMapWidth, this.mapWidth);
            this.mapBlur = typedArray.getInt(R.styleable.GoogleMapView_setMapBlur, this.mapBlur);
            this.cacheMap = typedArray.getBoolean(R.styleable.GoogleMapView_setCacheMap, this.cacheMap);
            this.mapScale = typedArray.getInt(R.styleable.GoogleMapView_setMapScale, this.mapScale);
            int mapTypeCode = typedArray.getInt(R.styleable.GoogleMapView_setMapType, 0);


            try {
                setMapType(mapTypeCode);
            } finally {
                invalidate();
                requestLayout();
                typedArray.recycle();
            }
        }
    }

    private void load() {
        load(this.mapZoom
                , this.mapBlur
                , this.latitude
                , this.longitude
                , this.mapType
                , this.mapWidth
                , this.mapHeight
                , this.cacheMap
                , this.mapScale);
    }

    private void load(int zoom, int blur, float latitude, float longitude, final String maptype, int width, int height, boolean cache, int scale) {

        Log.i(TAG, "load: " + cache + "   " + maptype);
        List<Get> gets = new ArrayList<>();
        gets.add(new Get().setKey("center").setValue(String.valueOf(latitude) + "," + String.valueOf(longitude)));
        gets.add(new Get().setKey("zoom").setValue(zoom));
        gets.add(new Get().setKey("size").setValue(String.valueOf(width) + "x" + String.valueOf(height)));
        gets.add(new Get().setKey("mapType").setValue(maptype));
        gets.add(new Get().setKey("scale").setValue(scale));
        gets.add(new Get().setKey("format").setValue("jpg"));

        String link = buildURI("https://maps.googleapis.com/maps/api/staticmap", gets);
        if (cache) {
            Pico.with(getContext()).from(link).smartCache().setBlur(blur).into(new OnBitmapLoad() {
                @Override
                public void bitmap(Bitmap bitmap) {

                    Log.i(TAG, "bitmap: 222  " + GoogleMapView.this.mapType + "   " + maptype);
                    if (GoogleMapView.this.mapType.equals(maptype)) {
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

                    Log.i(TAG, "bitmap: 223  " + GoogleMapView.this.mapType + "   " + maptype);

                    if (GoogleMapView.this.mapType.equals(maptype)) {
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
