package com.kucingapes.utsman.tutorialgmap;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.AbstractCodeAdapter;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.highlight.ColorTheme;
import io.github.kbiakov.codeview.highlight.Font;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * Created by user on 1/23/2018.
 */

public class Maps_2 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @BindView(R.id.codemap1)
    ScrollView layoutCode_1;

    @BindView(R.id.bmap1)
    Button bMap1;

    @BindView(R.id.code_view)
    CodeView codeView;

    @BindView(R.id.code_view_xml)
    CodeView codeViewXML;

    @BindView(R.id.textXML)
    TextView textXML;

    @BindView(R.id.textJava)
    TextView textJava;

    @BindView(R.id.card_xml)
    CardView cardXML;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_1);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

/*        RelativeLayout.LayoutParams card = (RelativeLayout.LayoutParams) cardXML.getLayoutParams();
        //card.setMargins(0,0,0,3);
        card.addRule(RelativeLayout.BELOW);
        cardXML.setLayoutParams(card);*/

        cardXML.setVisibility(View.GONE);
        textXML.setVisibility(View.GONE);
        textJava.setText(getString(R.string.penjelasan_java));

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("@Override\n" +
                        "public void onMapReady(GoogleMap googleMap) {\n" +
                        "    mMap = googleMap;\n" +
                        "\n" +
                        "    LatLng jkt = new LatLng(-6.3042725, 106.8713965);\n" +
                        "    mMap.addMarker(new MarkerOptions()\n" +
                        "        .position(jkt)\n" +
                        "        .title(\"Jakarta\"));\n" +
                        "\n" +
                        "    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jkt, 10));\n" +
                        "}"));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng jkt = new LatLng(-6.3042725, 106.8713965);
        mMap.addMarker(new MarkerOptions()
                .position(jkt)
                .title("Jakarta"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jkt, 10));
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

    public void Map1code(View view) {
        layoutCode_1.setVisibility(View.VISIBLE);
        bMap1.setVisibility(View.GONE);
    }

}
