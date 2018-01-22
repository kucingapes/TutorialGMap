package com.kucingapes.utsman.tutorialgmap;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;

import java.net.MalformedURLException;
import java.net.URL;

import javax.sql.RowSet;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Maps_1 extends AppCompatActivity implements OnMapReadyCallback, HighlightJsView.OnThemeChangedListener {

    private GoogleMap mMap;

    @BindView(R.id.codemap1)
    RelativeLayout layoutCode_1;

    @BindView(R.id.bmap1)
    Button bMap1;

    @BindView(R.id.code)
    HighlightJsView highlightJsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_1);
        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

        highlightJsView.setOnThemeChangedListener(this);
        //change theme and set language to auto detect
        highlightJsView.setTheme(Theme.ANDROID_STUDIO);
        highlightJsView.setHighlightLanguage(Language.AUTO_DETECT);
        //load the source (can be loaded by String, File or URL)
       // highlightJsView.setSource(getString(R.string.listing_java));

        URL filenya = null;
        try {
            filenya = new URL("https://rawgit.com/kucingapes/CilacapIntegrateTourism/master/app/src/main/java/com/kucingapes/utsman/cilacaptourism/About.java");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

       highlightJsView.setSource(filenya);
    }

    @Override
    public void onBackPressed() {
        if (layoutCode_1.getVisibility() == View.VISIBLE) {
            layoutCode_1.setVisibility(View.GONE);
            bMap1.setVisibility(View.VISIBLE);
        } else if (layoutCode_1.getVisibility() == View.GONE) {
            super.onBackPressed();
        }
        //finish();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void Map1code(View view) {
        layoutCode_1.setVisibility(View.VISIBLE);
        bMap1.setVisibility(View.GONE);
    }

    @Override
    public void onThemeChanged(@NonNull Theme theme) {

    }
}
