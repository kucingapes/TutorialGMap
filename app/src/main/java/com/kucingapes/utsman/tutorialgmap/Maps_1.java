package com.kucingapes.utsman.tutorialgmap;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;

public class Maps_1 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @BindView(R.id.codemap1)
    ScrollView layoutCode_1;

    @BindView(R.id.bmap1)
    Button bMap1;

    @BindView(R.id.code_view_dua)
    CodeView codeView;

    @BindView(R.id.code_view_satu)
    CodeView codeViewXML;

    @BindView(R.id.textSatu)
    TextView textSatu;

    @BindView(R.id.textDua)
    TextView textDua;

    @BindView(R.id.card_satu)
    CardView cardSatu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        textSatu.setText(getString(R.string.penjelasan_xml));
        textDua.setText(getString(R.string.penjelasan_java));

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("public class Maps extends AppCompatActivity implements OnMapReadyCallback {\n" +
                        "\n" +
                        "    private GoogleMap mMap;\n" +
                        "\n" +
                        "    @Override\n" +
                        "    protected void onCreate(Bundle savedInstanceState) {\n" +
                        "        super.onCreate(savedInstanceState);\n" +
                        "        setContentView(R.layout.activity_maps);\n" +
                        "    \n" +
                        "       /* Menambahkan map fragment pada onCreate */\n" +
                        "        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()\n" +
                        "                .findFragmentById(R.id.map1);\n" +
                        "        mapFragment.getMapAsync(this);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /* Memanggil google map pada fragment */\n" +
                        "    @Override\n" +
                        "    public void onMapReady(GoogleMap googleMap) {\n" +
                        "        mMap = googleMap;\n" +
                        "    }\n" +
                        "\n" +
                        "}"));

        codeViewXML.setOptions(Options.Default.get(this)
                .withLanguage("xml")
                .withCode("<fragment xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "  xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                        "  android:layout_width=\"match_parent\"\n" +
                        "  android:layout_height=\"0dp\"\n" +
                        "  android:id=\"@+id/maps\"\n" +
                        "  tools:context=\".Maps\"\n" +
                        "  android:layout_weight=\"2\"\n" +
                        "  class=\"com.google.android.gms.maps.SupportMapFragment\" />"));
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void Map1code(View view) {
        layoutCode_1.setVisibility(View.VISIBLE);
        bMap1.setVisibility(View.GONE);
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


