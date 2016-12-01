package com.company.n2i.refugees;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int IS_BLIND_REQUEST = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btMap = (Button)findViewById(R.id.btMap);
        Button btInfos = (Button)findViewById(R.id.btInfos);
        Button btTranslation = (Button)findViewById(R.id.btTranslation);

        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication().getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        btInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication().getApplicationContext(), InformationActivity.class);
                startActivity(intent);
            }
        });

        btTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication().getApplicationContext(), TranslationActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences runCheck = getSharedPreferences("hasRunBefore", 0); // charge les pr�f�rences
        Boolean hasRun = runCheck.getBoolean("hasRun", false); // r�cup�re la valeur de hasRun
        if (!hasRun) {
            // L'application n'a pas �t� lanc�e, ou il n'y a plus de donn�es
            SharedPreferences settings = getSharedPreferences("hasRunBefore", 0);
            SharedPreferences.Editor edit = settings.edit();
            edit.putBoolean("hasRun", true); // maintenant, elle a �t� lanc�e
            edit.commit();

            Intent intent = new Intent(getApplicationContext(), IsBlindActivity.class);
            startActivityForResult(intent, IS_BLIND_REQUEST);
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_french_flag) {
            // fucntion();
            /*Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);*/
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IS_BLIND_REQUEST) {
            if (resultCode == RESULT_OK) {
                //TODO On set le theme en plus gros pour les maloyants
                boolean result = data.getBooleanExtra("result", false);
                Toast.makeText(getApplicationContext(), result ? "blind" : "normal", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
