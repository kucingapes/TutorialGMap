package com.kucingapes.utsman.tutorialgmap;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import org.w3c.dom.Text;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_1);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

////        TextView.LayoutParams card = (RelativeLayout.LayoutParams) cardJava.getLayoutParams();
////        //card.setMargins(0,0,0,3);
////        card.addRule(RelativeLayout.BELOW, R.id.card_xml);
//        cardJava.setLayoutParams(card);



        textXML.setText(getString(R.string.penjelasan_xml));
        textJava.setText(getString(R.string.penjelasan_java));

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("public class Maps_1 extends AppCompatActivity implements OnMapReadyCallback {\n" +
                        "\n" +
                        "    private GoogleMap mMap;\n" +
                        "\n" +
                        "    @Override\n" +
                        "    protected void onCreate(Bundle savedInstanceState) {\n" +
                        "        super.onCreate(savedInstanceState);\n" +
                        "        setContentView(R.layout.activity_maps_1);\n" +
                        "    \n" +
                        "       /* menambahkan map fragment pada onCreate*/\n" +
                        "        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()\n" +
                        "                .findFragmentById(R.id.map1);\n" +
                        "        mapFragment.getMapAsync(this);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /*memanggil google map pada fragment*/\n" +
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

}
