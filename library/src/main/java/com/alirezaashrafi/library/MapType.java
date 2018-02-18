package com.alirezaashrafi.library;

public enum MapType {
        SATELLITE("satellite"),
        ROADMAP("roadmap"),
        HYBRID("hybrid"),
        TERRAIN("terrain");
        private String value;

        MapType(String value) {
            this.value = value;
        }


        String getValue() {
            return value;
        }
    }