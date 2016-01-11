package com.bignerdranch.android.addfeatureservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISDynamicMapServiceLayer;
import com.esri.android.map.ags.ArcGISFeatureLayer;

public class MainActivity extends AppCompatActivity {

    MapView mMapView;
    ArcGISFeatureLayer mFeatureLayer;
    ArcGISDynamicMapServiceLayer mMapService;
    GraphicsLayer mGraphicsLayer;
    boolean mIsMapLoaded;
    String mFeatureServiceURL;
    String mMapServiceURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inflate the mapview
        mMapView = (MapView)findViewById(R.id.map);

        //Get the feature service URL from values->strings.xml
        mFeatureServiceURL = this.getResources().getString(R.string.featureServiceURL);

        //Get the map service URL from values->strings.xml
        mMapServiceURL = this.getResources().getString(R.string.mapServiceURL);

        //Add feature layer to the MapView
        mFeatureLayer = new ArcGISFeatureLayer(mFeatureServiceURL, ArcGISFeatureLayer.MODE.ONDEMAND);
        //mMapView.addLayer(mFeatureLayer);

        //Add map service to MapView
        mMapService = new ArcGISDynamicMapServiceLayer(mMapServiceURL);
        mMapView.addLayer(mMapService);
    }
}
