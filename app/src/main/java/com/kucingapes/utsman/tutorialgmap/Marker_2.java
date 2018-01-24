package com.kucingapes.utsman.tutorialgmap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;

/**
 * Created by user on 1/23/2018.
 * Multi Marker
 */

public class Marker_2 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng JKT = new LatLng(-6.3042725, 106.8713965);
    private static final LatLng BDG = new LatLng(-6.9034482,107.6081381);
    private static final LatLng SBY = new LatLng(-7.256883,112.6251649);

    private Marker mJkt;
    private Marker mBdg;
    private Marker mSby;

    @BindView(R.id.codemap1)
    ScrollView layoutCode_1;

    @BindView(R.id.bmap1)
    Button bMap1;

    @BindView(R.id.code_view_dua)
    CodeView codeView;

    @BindView(R.id.code_view_satu)
    CodeView codeViewSatu;

    @BindView(R.id.textSatu)
    TextView textSatu;

    @BindView(R.id.textDua)
    TextView textDua;

    @BindView(R.id.card_dua)
    CardView cardXML;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

        isiCode();
    }

    private void isiCode() {
        textSatu.setText("Latitude dan Langitude di deklarasi di luar bersamaan dengan deklarasi marker");

        codeViewSatu.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("/* Deklarasi posisi kota */\n" +
                        "private static final LatLng JKT = new LatLng(-6.3042725, 106.8713965);\n" +
                        "private static final LatLng BDG = new LatLng(-6.9034482,107.6081381);\n" +
                        "private static final LatLng SBY = new LatLng(-7.256883,112.6251649);\n" +
                        "\n" +
                        "/* Deklarasi marker */\n" +
                        "private Marker mJkt;\n" +
                        "private Marker mBdg;\n" +
                        "private Marker mSby;"));

        textDua.setText("Kemudian panggil marker ke dalam onMapReady dengan kode berikut");

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("@Override\n" +
                        "public void onMapReady(GoogleMap googleMap) {\n" +
                        "    mMap = googleMap;\n" +
                        "\n" +
                        "    /* Arahkan kamera ke BDG dengan zoom level 5 */\n" +
                        "    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BDG, 5));\n" +
                        "    \n" +
                        "   /* Menambah marker */\n" +
                        "    mJkt = mMap.addMarker(new MarkerOptions()\n" +
                        "            .position(JKT)\n" +
                        "            .title(\"Jakarta\"));\n" +
                        "\n" +
                        "    mBdg = mMap.addMarker(new MarkerOptions()\n" +
                        "            .position(BDG)\n" +
                        "            .title(\"Bandung\"));\n" +
                        "\n" +
                        "    mSby = mMap.addMarker(new MarkerOptions()\n" +
                        "            .position(SBY)\n" +
                        "            .title(\"Surabaya\"));\n" +
                        "}"));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /* Arahkan kamera ke BDG dengan zoom level 5 */
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BDG, 5));

       /* Menambah marker */
        mJkt = mMap.addMarker(new MarkerOptions()
                .position(JKT)
                .title("Jakarta"));

        mBdg = mMap.addMarker(new MarkerOptions()
                .position(BDG)
                .title("Bandung"));

        mSby = mMap.addMarker(new MarkerOptions()
                .position(SBY)
                .title("Surabaya"));
    }

    public void Map1code(View view) {
        layoutCode_1.setVisibility(View.VISIBLE);
        bMap1.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if (layoutCode_1.getVisibility() == View.VISIBLE) {
            layoutCode_1.setVisibility(View.GONE);
            bMap1.setVisibility(View.VISIBLE);
        } else if (layoutCode_1.getVisibility() == View.GONE) {
            super.onBackPressed();
            recreate();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
