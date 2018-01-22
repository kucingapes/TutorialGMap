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
    HighlightJsView hl;
    //private boolean enableLineNumbers;

    @BindView(R.id.code_xml)
    HighlightJsView hlXML;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_1);
        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

        configHl();



        URL java1 = null;
        try {
            java1 = new URL("https://rawgit.com/kucingapes/TutorialGMap/master/code_file/maps_1.java");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        hl.setSource(java1);


        URL codexml = null;
        try {
            codexml = new URL("https://rawgit.com/kucingapes/TutorialGMap/master/code_file/maps_1.xml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        hlXML.setSource(codexml);
    }

    private void configHl() {
        hl.setOnThemeChangedListener(this);
        hl.setTheme(Theme.ANDROID_STUDIO);
        hl.setHighlightLanguage(Language.AUTO_DETECT);
        hlXML.setOnThemeChangedListener(this);
        hlXML.setTheme(Theme.ANDROID_STUDIO);
        hlXML.setHighlightLanguage(Language.AUTO_DETECT);
        onShowLineNumbersToggled(true);
    }


    @Override
    public void onBackPressed() {
        if (layoutCode_1.getVisibility() == View.VISIBLE) {
            layoutCode_1.setVisibility(View.GONE);
            bMap1.setVisibility(View.VISIBLE);
        } else if (layoutCode_1.getVisibility() == View.GONE) {
            super.onBackPressed();
        }
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

    private void onShowLineNumbersToggled(boolean enableLineNumbers) {
        hl.setShowLineNumbers(enableLineNumbers);
        hl.refresh();
        hlXML.setShowLineNumbers(enableLineNumbers);
        hlXML.refresh();
    }

}
