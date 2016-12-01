package com.company.n2i.refugees;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_flag, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

// Réalisation une action en fonction du drapeau cliqué
        if (id == R.id.action_french_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("fr");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "fr", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        else if (id == R.id.action_iran_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("fa");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "fa", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);

        }
        else if (id == R.id.action_saudi_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("ar");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "ar", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        else if (id == R.id.action_uk_flag) {
            Resources res = getApplicationContext().getResources();
            // Change locale settings in the app.
            DisplayMetrics dm = res.getDisplayMetrics();
            android.content.res.Configuration conf = res.getConfiguration();
            conf.locale = new Locale("en");
            res.updateConfiguration(conf, dm);
            Toast.makeText(getApplicationContext(), "en", Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
