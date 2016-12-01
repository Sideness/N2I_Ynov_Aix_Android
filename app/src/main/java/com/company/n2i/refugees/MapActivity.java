package com.company.n2i.refugees;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
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
            // fucntion();
        }
        else if (id == R.id.action_iran_flag) {
            // fucntion();
        }
        else if (id == R.id.action_saudi_flag) {
            // fucntion();
        }

        return super.onOptionsItemSelected(item);
    }
}
