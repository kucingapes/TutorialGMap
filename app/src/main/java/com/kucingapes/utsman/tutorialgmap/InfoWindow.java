package com.kucingapes.utsman.tutorialgmap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;

/**
 * Created by user on 1/23/2018.
 */

public class InfoWindow extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng JKT = new LatLng(-6.3042725, 106.8713965);
    private static final LatLng BDG = new LatLng(-6.9034482, 107.6081381);
    private static final LatLng SBY = new LatLng(-7.256883, 112.6251649);

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

    @BindView(R.id.textTiga)
    TextView textTiga;

    @BindView(R.id.card_satu)
    CardView cardSatu;

    @BindView(R.id.card_tiga)
    CardView cardTiga;

    @BindView(R.id.code_view_tiga)
    CodeView codeViewTiga;


    private class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        private final View infoWindowView;

        InfoWindowAdapter() {
            infoWindowView = getLayoutInflater().inflate(R.layout.info_window, null);
        }

        @Override
        public View getInfoContents(Marker marker) {

            TextView infTitle = ((TextView) infoWindowView.findViewById(R.id.title));
            infTitle.setText(marker.getTitle());

            TextView infSnippet = ((TextView) infoWindowView.findViewById(R.id.snippet));
            infSnippet.setText(marker.getSnippet());

            return infoWindowView;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }
    }


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

        textTiga.setVisibility(View.VISIBLE);
        cardTiga.setVisibility(View.VISIBLE);
        textSatu.setText("Untuk membuat custom info window dibutuhkan layout xml sebagai layout info window");

        codeViewSatu.setOptions(Options.Default.get(this)
                    .withLanguage("xml")
                    .withCode("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                            "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                            "    android:layout_width=\"wrap_content\"\n" +
                            "    android:layout_height=\"wrap_content\"\n" +
                            "    android:orientation=\"vertical\"\n" +
                            "    android:padding=\"2dp\"\n" +
                            "    android:layout_centerHorizontal=\"true\">\n" +
                            "\n" +
                            "    <TextView\n" +
                            "        android:layout_width=\"wrap_content\"\n" +
                            "        android:layout_height=\"wrap_content\"\n" +
                            "        android:id=\"@+id/title\"\n" +
                            "        android:textStyle=\"bold\"/>\n" +
                            "\n" +
                            "    <TextView\n" +
                            "        android:layout_width=\"wrap_content\"\n" +
                            "        android:layout_height=\"wrap_content\"\n" +
                            "        android:id=\"@+id/snippet\"/>\n" +
                            "\n" +
                            "</LinearLayout>"));

        textDua.setText("Kemudian buat inner class untuk adapter pada MainActivity");
        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("private class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {\n" +
                        "    private final View infoWindowView;\n" +
                        "\n" +
                        "    InfoWindowAdapter() {\n" +
                        "        infoWindowView = getLayoutInflater().inflate(R.layout.info_window, null);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public View getInfoContents(Marker marker) {\n" +
                        "\n" +
                        "        TextView infTitle = ((TextView) infoWindowView.findViewById(R.id.title));\n" +
                        "        infTitle.setText(marker.getTitle());\n" +
                        "        \n" +
                        "        TextView infSnippet = ((TextView) infoWindowView.findViewById(R.id.snippet));\n" +
                        "        infSnippet.setText(marker.getSnippet());\n" +
                        "\n" +
                        "        return infoWindowView;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public View getInfoWindow(Marker marker) {\n" +
                        "        return null;\n" +
                        "    }\n" +
                        "}"));

        textTiga.setText("Memanggil adapter pada onMapReady kemudian atur title dan snippet");
        codeViewTiga.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode("@Override\n" +
                        "public void onMapReady(GoogleMap googleMap) {\n" +
                        "    mMap = googleMap;\n" +
                        "    mMap.setInfoWindowAdapter(new InfoWindowAdapter());\n" +
                        "\n" +
                        "    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BDG, 5));\n" +
                        "    mJkt = mMap.addMarker(new MarkerOptions()\n" +
                        "            .position(JKT)\n" +
                        "            .title(\"Jakarta\")\n" +
                        "            .snippet(\"ini custom info window\"));\n" +
                        "\n" +
                        "    mBdg = mMap.addMarker(new MarkerOptions()\n" +
                        "            .position(BDG)\n" +
                        "            .title(\"Bandung\")\n" +
                        "            .snippet(\"ini custom info window\"));\n" +
                        "\n" +
                        "    mSby = mMap.addMarker(new MarkerOptions()\n" +
                        "            .position(SBY)\n" +
                        "            .title(\"Surabaya\")\n" +
                        "            .snippet(\"ini custom info window\"));\n" +
                        "\n" +
                        "}"));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new InfoWindowAdapter());

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BDG, 5));
        mJkt = mMap.addMarker(new MarkerOptions()
                .position(JKT)
                .title("Jakarta")
                .snippet("ini custom info window"));

        mBdg = mMap.addMarker(new MarkerOptions()
                .position(BDG)
                .title("Bandung")
                .snippet("ini custom info window"));

        mSby = mMap.addMarker(new MarkerOptions()
                .position(SBY)
                .title("Surabaya")
                .snippet("ini custom info window"));

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
