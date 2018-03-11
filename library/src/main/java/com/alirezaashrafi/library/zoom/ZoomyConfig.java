package com.alirezaashrafi.library.zoom;


public class ZoomyConfig {

    private boolean zoomAnimationEnabled = true;
    private boolean immersiveModeEnabled = true;

    public boolean isZoomAnimationEnabled() {
        return zoomAnimationEnabled;
    }

    public void setZoomAnimationEnabled(boolean zoomAnimationEnabled) {
        this.zoomAnimationEnabled = zoomAnimationEnabled;
    }

    public boolean isImmersiveModeEnabled() {
        return immersiveModeEnabled;
    }

    public void setImmersiveModeEnabled(boolean immersiveModeEnabled) {
        this.immersiveModeEnabled = immersiveModeEnabled;
    }
}
