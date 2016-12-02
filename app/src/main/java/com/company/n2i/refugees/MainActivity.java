package com.company.n2i.refugees;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static final int IS_BLIND_REQUEST = 1;  // The request code

    private Boolean isBlind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout btMap = (RelativeLayout)findViewById(R.id.btMap);
        RelativeLayout btInfos = (RelativeLayout)findViewById(R.id.btInfos);
        RelativeLayout btTranslation = (RelativeLayout)findViewById(R.id.btTranslation);

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

        SharedPreferences isBlindPref = getSharedPreferences("isBlindPref", 0); // charge les pr�f�rences
        isBlind = isBlindPref.getBoolean("isBlind", false);

        btMap.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(isBlind){
                    TextView tvBtMap = (TextView) findViewById(R.id.tvMap);
                    String toSay = new String(tvBtMap.getText().toString());
                    TextToSpeechHelper.getInstance().say(toSay, getApplicationContext());
                }
                return true;
            }
        });

        btInfos.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(isBlind){
                    TextView tvBtInfos = (TextView) findViewById(R.id.tvInfos);
                    String toSay = new String(tvBtInfos.getText().toString());
                    TextToSpeechHelper.getInstance().say(toSay, getApplicationContext());
                }
                return true;
            }
        });

        btTranslation.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(isBlind){
                    TextView tvBtTranslation = (TextView) findViewById(R.id.tvTranslations);
                    String toSay = new String(tvBtTranslation.getText().toString());
                    TextToSpeechHelper.getInstance().say(toSay, getApplicationContext());
                }
                return true;
            }
        });
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
            if(isBlind){
                TextToSpeechHelper.getInstance().say(getString(R.string.languageFrench), getApplicationContext());
            }
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
            if(isBlind){
                TextToSpeechHelper.getInstance().say(getString(R.string.languagePersan), getApplicationContext());
            }
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
            if(isBlind){
                TextToSpeechHelper.getInstance().say(getString(R.string.languageArabic), getApplicationContext());
            }
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
            if(isBlind){
                TextToSpeechHelper.getInstance().say(getString(R.string.languageEnglish), getApplicationContext());
            }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IS_BLIND_REQUEST) {
            if (resultCode == RESULT_OK) {
                //TODO On set le theme en plus gros pour les maloyants
                boolean result = data.getBooleanExtra("result", false);
                SharedPreferences isBlindPref = getSharedPreferences("isBlindPref", 0); // charge les pr�f�rences
                SharedPreferences.Editor edit = isBlindPref.edit();
                edit.putBoolean("isBlind", result); // maintenant, elle a �t� lanc�e
                edit.commit();

                isBlind = result;
            }
        }
    }

}
