package com.kucingapes.utsman.tutorialgmap;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
import io.github.kbiakov.codeview.adapters.Options;

/**
 * Created by user on 1/23/2018.
 */

public class Marker_1 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

    @BindView(R.id.card_satu)
    CardView cardSatu;

    @BindView(R.id.card_dua)
    CardView cardDua;

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
        textDua.setVisibility(View.GONE);
        cardDua.setVisibility(View.GONE);
        textSatu.setText("Untuk memuncukan marker dibutuhkan latitude dan longitude sebuah lokasi yang akan di marker. Contohnya kota Jakarta mempunyai latitude -6.3042725 dan longitude 106.8713965, maka kode nya sebagai berikut");
        codeViewSatu.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("@Override\n" +
                        "public void onMapReady(GoogleMap googleMap) {\n" +
                        "    mMap = googleMap;\n" +
                        "\n" +
                        "    /* Atur lokasi */\n" +
                        "    LatLng jkt = new LatLng(-6.3042725, 106.8713965);\n" +
                        "\n" +
                        "    /* Menambah marker */\n" +
                        "    mMap.addMarker(new MarkerOptions()\n" +
                        "            .position(jkt)\n" +
                        "            .title(\"Jakarta\"));\n" +
                        "\n" +
                        "    /* Arahkan kamera ke marker dengan zoom level 10 */\n" +
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Map1code(View view) {
        layoutCode_1.setVisibility(View.VISIBLE);
        bMap1.setVisibility(View.GONE);
    }

}
