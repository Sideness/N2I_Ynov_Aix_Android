package com.company.n2i.refugees;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.StringTokenizer;

public class TranslationActivity extends AppCompatActivity {


    ImageButton native_flag_button;
    ImageButton destination_flag_button;
    AlertDialog dialog;
    public static String nativeLanguage = Locale.getDefault().getLanguage();
    public static String destLanguage = "en";
    public static boolean[] isTranslated = {false,false,false,false,false};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        addListenerOnFlagButton();
        //new ListTraduction( )
        Resources res = getApplicationContext().getResources();
        android.content.res.Configuration conf = res.getConfiguration();
        Locale bufferLocale = conf.locale;
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Resources resources = new Resources(getAssets(), metrics, conf);
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        switch (TranslationActivity.nativeLanguage){
            case ("fr"):
                imagebutton.setImageResource(R.drawable.french_flag);
                break;
            case ("en"):
                imagebutton.setImageResource(R.drawable.uk_flag);
                break;
            case ("fa"):
                imagebutton.setImageResource(R.drawable.iran_flag);
                break;
            case  ("ar"):
                imagebutton.setImageResource(R.drawable.saudi_flag);
                break;
        }
        imagebutton.setAdjustViewBounds(true);
        imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.uk_flag);
        imagebutton.setAdjustViewBounds(true);
        final String[] valuesDefault = new String[] {
                resources.getString(R.string.baseHelp),
                resources.getString(R.string.baseTransportation),
                resources.getString(R.string.baseHurt),
                resources.getString(R.string.baseFamilly),
                resources.getString(R.string.baseHallal),
        };

        conf.locale = new Locale("fr");
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        resources = new Resources(getAssets(), metrics, conf);
        final String[] valuesFr = new String[] {
                resources.getString(R.string.baseHelp),
                resources.getString(R.string.baseTransportation),
                resources.getString(R.string.baseHurt),
                resources.getString(R.string.baseFamilly),
                resources.getString(R.string.baseHallal),
        };
        conf.locale = new Locale("fa");
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        resources = new Resources(getAssets(), metrics, conf);
        final String[] valuesFa = new String[] {
                resources.getString(R.string.baseHelp),
                resources.getString(R.string.baseTransportation),
                resources.getString(R.string.baseHurt),
                resources.getString(R.string.baseFamilly),
                resources.getString(R.string.baseHallal),
        };
        conf.locale = new Locale("ar");
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        resources = new Resources(getAssets(), metrics, conf);
        final String[] valuesAr = new String[] {
                resources.getString(R.string.baseHelp),
                resources.getString(R.string.baseTransportation),
                resources.getString(R.string.baseHurt),
                resources.getString(R.string.baseFamilly),
                resources.getString(R.string.baseHallal),
        };
        conf.locale = new Locale("en");
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        resources = new Resources(getAssets(), metrics, conf);
        final String[] valuesUk = new String[] {
                getResources().getString(R.string.baseHelp),
                getResources().getString(R.string.baseTransportation),
                getResources().getString(R.string.baseHurt),
                getResources().getString(R.string.baseFamilly),
                getResources().getString(R.string.baseHallal),
        };
        conf.locale = bufferLocale;
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valuesDefault);
        final ListView list = (ListView) findViewById(R.id.traductionList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String item = ((TextView)view).getText().toString();
                String Traduction = "";
                switch (TranslationActivity.destLanguage){
                    case("fr"):
                        Traduction = valuesFr[position];
                        break;
                    case("en"):
                        Traduction = valuesUk[position];
                        break;
                    case("fa"):
                        Traduction = valuesFa[position];
                        break;
                    case("ar"):
                        Traduction = valuesAr[position];
                        break;
                }
                if (isTranslated[position]){
                    switch (TranslationActivity.nativeLanguage){
                        case("fr"):
                            Traduction = valuesFr[position];
                            break;
                        case("en"):
                            Traduction = valuesUk[position];
                            break;
                        case("fa"):
                            Traduction = valuesFa[position];
                            break;
                        case("ar"):
                            Traduction = valuesAr[position];
                            break;
                    }
                }
                TranslationActivity.isTranslated[position] = !TranslationActivity.isTranslated[position];

                valuesDefault[position] = Traduction;
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), Traduction , Toast.LENGTH_LONG).show();
            }
        });
        list.setOnLongClickListener(new android.view.View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String item = ((TextView)v).getText().toString();
                TextToSpeechHelper.getInstance().say(item, getApplicationContext());
                return false;
            }

        });
    }

    public void french(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.french_flag);
        TranslationActivity.nativeLanguage = "fr";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();

    }
    public void uk(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.uk_flag);
        TranslationActivity.nativeLanguage = "en";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void iran(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.iran_flag);
        TranslationActivity.nativeLanguage = "fa";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void saudi(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.saudi_flag);
        TranslationActivity.nativeLanguage = "ar";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }

    public void frenchRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.french_flag);
        TranslationActivity.destLanguage = "fr";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();

    }
    public void ukRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.uk_flag);
        TranslationActivity.destLanguage = "en";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void iranRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.iran_flag);
        TranslationActivity.destLanguage = "fa";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void saudiRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.saudi_flag);
        TranslationActivity.destLanguage = "ar";
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }



    protected void addListenerOnFlagButton() {

        native_flag_button = (ImageButton) findViewById(R.id.native_language_flag);
        native_flag_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(TranslationActivity.this);
                LayoutInflater factory = LayoutInflater.from(TranslationActivity.this);
                final View view = factory.inflate(R.layout.alert_dialog_choice_flag, null);
                alertadd.setView(view);
                dialog = alertadd.create();
                /*alertadd.setNeutralButton("Here!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                });*/
                dialog.show();
            }
        });

        destination_flag_button = (ImageButton) findViewById(R.id.destination_language_flag);
        destination_flag_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(TranslationActivity.this);
                LayoutInflater factory = LayoutInflater.from(TranslationActivity.this);
                final View view = factory.inflate(R.layout.alert_dialog_choice_flag_right, null);
                alertadd.setView(view);
                dialog = alertadd.create();
                /*alertadd.setNeutralButton("Here!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                });*/
                dialog.show();
            }
        });

    }
/*
    Integer[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7

    };

    @Override
    protected void inflateAlertDialog() {
        CustomList adapter = new
                CustomList(MainActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    } */
}