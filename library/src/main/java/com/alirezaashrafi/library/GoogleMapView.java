package com.alirezaashrafi.library;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.alirezaashrafi.library.zoom.Zoomy;
import com.alirezaashrafi.library.zoom.ZoomyConfig;
import com.squareup.picasso.Picasso;

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
    private int mapScale;
    private String mapType;

    public GoogleMapView(Context context) {
        super(context);
        init(context, null);

    }

    public GoogleMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public GoogleMapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    public GoogleMapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
            latitude = (float) location.getLatitude();
            longitude = (float) location.getLongitude();
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


    public void setMapType(MapType mapType) {
        this.mapType = (mapType.getValue());
        load();
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


    private void initVariables() {
        if (!init) {
            init = true;
            latitude = GoogleMapViewConfigs.latitude;
            longitude = GoogleMapViewConfigs.longitude;
            mapZoom = GoogleMapViewConfigs.mapZoom;
            mapHeight = GoogleMapViewConfigs.mapHeight;
            mapWidth = GoogleMapViewConfigs.mapWidth;
            mapScale = GoogleMapViewConfigs.mapScale;
            mapType = GoogleMapViewConfigs.mapType;
        }

    }

    public void setZoomable(Activity activity) {
        Zoomy.Builder builder = new Zoomy.Builder(activity)
                .target(this)
                .enableImmersiveMode(false)
                .animateZooming(false);
        builder.register();
    }

    private void init(Context context, AttributeSet attributeSet) {
        initVariables();
        if (attributeSet != null) {

            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.GoogleMapView);
            try {
                this.latitude = typedArray.getFloat(R.styleable.GoogleMapView_setLatitude, this.latitude);
                this.longitude = typedArray.getFloat(R.styleable.GoogleMapView_setLongitude, this.longitude);
                this.mapZoom = typedArray.getInt(R.styleable.GoogleMapView_setMapZoom, this.mapZoom);
                this.mapHeight = typedArray.getInt(R.styleable.GoogleMapView_setMapHeight, this.mapHeight);
                this.mapWidth = typedArray.getInt(R.styleable.GoogleMapView_setMapWidth, this.mapWidth);
                this.mapScale = typedArray.getInt(R.styleable.GoogleMapView_setMapScale, this.mapScale);
                switch (typedArray.getInt(R.styleable.GoogleMapView_setMapType, -1)) {
                    case 0:
                        mapType = "satellite";
                        break;
                    case 1:
                        mapType = "roadmap";
                        break;
                    case 2:
                        mapType = "hybrid";
                        break;
                    case 3:
                        mapType = "terrain";
                        break;
                }
            } finally {
                load();
                invalidate();
                requestLayout();
                typedArray.recycle();
            }
        }
    }

    private void load() {
        load(this.mapZoom
                , this.latitude
                , this.longitude
                , this.mapType
                , this.mapWidth
                , this.mapHeight
                , this.mapScale);
    }

    private void load(int zoom, float latitude, float longitude, final String maptype, int width, int height, int scale) {

        List<Get> gets = new ArrayList<>();
        gets.add(new Get().setKey("center").setValue(String.valueOf(latitude) + "," + String.valueOf(longitude)));
        gets.add(new Get().setKey("zoom").setValue(zoom));
        gets.add(new Get().setKey("size").setValue(String.valueOf(width) + "x" + String.valueOf(height)));
        gets.add(new Get().setKey("maptype").setValue(maptype));
        gets.add(new Get().setKey("scale").setValue(scale));
        gets.add(new Get().setKey("format").setValue("jpg"));

        String link = buildURI("https://maps.googleapis.com/maps/api/staticmap", gets);

        Picasso.with(getContext()).load(link).into(this);

    }


    private String buildURI(String url, List<Get> gets) {
        Uri.Builder builder = Uri.parse(url).buildUpon();
        for (int i = 0; i < gets.size(); i++) {
            builder.appendQueryParameter(gets.get(i).getKey(), gets.get(i).getValue());
        }
        return builder.toString();
    }

}
