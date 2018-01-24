package com.kucingapes.utsman.tutorialgmap;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;

public class API extends AppCompatActivity {

    @BindView(R.id.codeview_api_string)
    CodeView apiString;

    @BindView(R.id.codeview_api_meta)
    CodeView apiMeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        isiCode();
    }

    private void isiCode() {

        apiString.setOptions(Options.Default.get(this)
                .withLanguage("xml")
                .withCode("<string name=\"google_maps_key\" templateMergeStrategy=\"preserve\" translatable=\"false\">\n" +
                        "    <!-- Paste di Sini API Key nya -->\n" +
                        "</string>"));

        apiMeta.setOptions(Options.Default.get(this)
                .withLanguage("xml")
                .withCode("<!-- Taruh sebelum activity -->\n" +
                        "\n" +
                        "<meta-data \n" +
                        "\tandroid:name=\"com.google.android.maps.v2.API_KEY\" \n" +
                        "\tandroid:value=\"@string/google_maps_key\" />"));
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
