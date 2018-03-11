# Android google map view Library by static map

#### A library to make the map display process easier by entering latitude and longitude only


<img src="https://raw.githubusercontent.com/alirezaashrafi/GoogleMapView/master/IMAGES/header.png" />

 #### Do not forget the star:)⭐️


### [GoogleMapView APK Demo](https://github.com/alirezaashrafi/GoogleMapView/blob/master/DEMO/GoogleMapView.apk)

## <i class="icon-file"></i> How to download
#### Gradle
###### Add it in your root build.gradle at the end of repositories:
```java
    allprojects {
         repositories {
             ...
             maven { url 'https://jitpack.io' }
         }
    }
```
###### add this line to your module build.gradle dependecies block:
```java
    compile 'com.github.alirezaashrafi:GoogleMapView:1.0.4'
```

### Maven
###### Add the JitPack repository to your build file
```xml
  <repositories>
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
    </repository>
  </repositories>
```

###### Add the dependency

```xml
    <dependency>
      <groupId>com.github.alirezaashrafi</groupId>
      <artifactId>GoogleMapView</artifactId>
      <version>1.0.4</version>
    </dependency>
```
---

# how to use GoogleMapView

### **Attributes**

|        Attribute Name        | Type    | Default Value |
|:----------------------------:|---------|---------------|
| setLatitude    | float | 35.744920          |
| setLongitude    | float | 51.376303         |
| setMapType     | enum  |  satellite             |
| setMapScale    | enum  | high |
| setMapZoom     | int   | 17   |
| setMapWidth   | int   | 640px    |
| setMapHeight   | int   | 640px    |

### **XML**
```xml
  <com.alirezaashrafi.library.GoogleMapView
      android:id="@+id/googleMapView"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      app:setLatitude="35.744920"
      app:setLongitude="51.376303"
      app:setMapType="satellite"
      app:setMapScale="high"
      app:setMapZoom="15"
      app:setMapWidth="350"
      app:setMapHeight="350"/>

```

### JAVA
```java
  GoogleMapView googleMapView = (GoogleMapView) findViewById(R.id.googleMapView);
  googleMapView.setLatitude(35.744920f);
  googleMapView.setLongitude(51.376303f);
  googleMapView.setMapType(MapType.SATELLITE);
  googleMapView.setMapScale(MapScale.HIGH);
  googleMapView.setMapZoom(15);
  googleMapView.setMapWidth(350);
  googleMapView.setMapHeight(350);
  googleMapView.setLocation(location);
  googleMapView.setZoomable(activity);


```

---

# custom style GoogleMapView
```XML
  <style name="googleViewStyle" parent="GoogleMapView">
      <item name="android:layout_width">match_parent</item>
      <item name="android:layout_height">match_parent</item>
      <item name="setMapType">roadmap</item>
      <item name="setMapScale">low</item>
      <item name="setLatitude">35.744920</item>
      <item name="setLongitude">51.376303</item>
      <item name="setMapZoom">17</item>
      <item name="setMapWidth">640</item>
      <item name="setMapHeight">640</item>
  </style>
```
---

# how to change GoogleMapView default values?
#### note: for better performance change default values in the Application class onCreate method
```JAVA
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
```
---
## Pinch to zoom in JAVA
```JAVA
    googleMapView.setZoomable(this);
```
<img src="https://raw.githubusercontent.com/alirezaashrafi/GoogleMapView/master/IMAGES/zoom.gif"/>

---
## Licence
Copyright 2018 Alireza Ashrafi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


---
## Author
 - [Alireza Ashrafi](https://github.com/alirezaashrafi)
 - [web site : alirezaashrafi.ir](http://alirezaashrafi.ir)
 - [email : alirezaashrafi.pv@gmail.com](alirezaashrafi.pv@gmail.com)
 - Phone & Whatsapp +98 901 396 2648
 - [telegram : @dr_khaki](http://t.me/dr_khaki)

 ---
#### If you liked this library, do not forget to star and follow me ⭐️❤️️💙
#### [Eventually see my other libraries and projects](https://github.com/alirezaashrafi/)
