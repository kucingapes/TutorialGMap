package com.kucingapes.utsman.tutorialgmap;

import android.app.ActionBar;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_maps_1) {
            // Handle the camera action
            Intent maps1 = new Intent(MainActivity.this, Maps_1.class);
            startActivity(maps1);
        } else if (id == R.id.nav_marker1) {
            Intent marker1 = new Intent(MainActivity.this, Marker_1.class);
            startActivity(marker1);

        } else if (id == R.id.nav_marker2) {
            Intent marker2 = new Intent(MainActivity.this, Marker_2.class);
            startActivity(marker2);

        } else if (id == R.id.nav_marker3) {
            Intent marker3 = new Intent(MainActivity.this, Marker_3.class);
            startActivity(marker3);

        } else if (id == R.id.nav_marker4) {
            Intent marker4 = new Intent(MainActivity.this, Marker_4.class);
            startActivity(marker4);
            Toast.makeText(getApplicationContext(), "Sentuh markernya", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_info1) {
            Intent infowindow1 = new Intent(MainActivity.this, InfoWindow.class);
            startActivity(infowindow1);
            Toast.makeText(getApplicationContext(), "Sentuh marker untuk menampilkan info window", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_info2) {
            Intent infowindow2 = new Intent(MainActivity.this, InfoWindow_2.class);
            startActivity(infowindow2);
            Toast.makeText(getApplicationContext(), "Sentuh marker untuk menampilkan info window", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_api) {
            Intent api = new Intent(MainActivity.this, API.class);
            startActivity(api);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fabWa(View view) {
        Intent sendWA = new Intent("android.intent.action.MAIN");
        sendWA.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        sendWA.putExtra("jid",PhoneNumberUtils.stripSeparators("6281287903894")+"@s.whatsapp.net");
        startActivity(sendWA);
    }

    public void fabGit(View view) {
        String url = "https://github.com/kucingapes/TutorialGMap";
        Intent urlGit = new Intent(Intent.ACTION_VIEW);
        urlGit.setData(Uri.parse(url));
        startActivity(urlGit);
    }

    public void fabInsta(View view) {
        String url = "https://instagram.com/kucingapes";
        Intent urlInsta = new Intent(Intent.ACTION_VIEW);
        urlInsta.setData(Uri.parse(url));
        startActivity(urlInsta);
    }
}
