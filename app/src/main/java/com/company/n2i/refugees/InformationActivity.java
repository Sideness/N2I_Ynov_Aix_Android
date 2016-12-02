package com.company.n2i.refugees;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.company.n2i.refugees.MainActivity.isBlind;

public class InformationActivity extends AppCompatActivity {

    ArrayList<Topic> list = new ArrayList<>();
    ListView listView = null;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.arg1 == 1){
                CustomAdapter adapter = new CustomAdapter(InformationActivity.this, 0, list);
                listView.setAdapter(adapter);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        listView = (ListView) findViewById(R.id.listInformation);

        new Thread(new Runnable() {
            public void run() {
                try{
                    String language = Locale.getDefault().getLanguage();
                    JSONArray json = getJSONObjectFromURL("http://dailyveryapp.fr:36978/Api?languageCode=" + language);
                    for(int i = 0 ; i < json.length() ; i++){
                        JSONObject obj = json.getJSONObject(i);
                        Topic tmp = new Topic();
                        tmp.setId(obj.getString("id"));
                        tmp.setCategorieName(obj.getString("CategorieName"));
                        tmp.setCategorieFrench(obj.getString("CategorieFrench"));
                        tmp.setTitre(obj.getString("Titre"));
                        tmp.setContenu(obj.getString("Contenu"));
                        tmp.setLat(Double.parseDouble(obj.getString("lat").replace(",", ".")));
                        tmp.setLng(Double.parseDouble(obj.getString("lng").replace(",", ".")));
                        tmp.setDateEvent(obj.getString("DateEvent"));
                        tmp.setAdresse(obj.getString("Adresse"));
                        tmp.setContactTel(obj.getString("ContactTel"));
                        tmp.setContactMail(obj.getString("ContactMail"));
                        list.add(tmp);
                    }
                    Message msg = new Message();
                    msg.arg1 = 1;
                    handler.sendMessage(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Topic myTopic = list.get(pos);
                Intent intent = new Intent(getApplicationContext(), InfoDetailsActivity.class);
                intent.putExtra("topic", myTopic);
                startActivity(intent);
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

    public static JSONArray getJSONObjectFromURL(String urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        System.out.println("JSON: " + jsonString);

        return new JSONArray(jsonString);
    }
}
