package com.company.n2i.refugees;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class TranslationActivity extends AppCompatActivity {


    ImageButton native_flag_button;
    ImageButton destination_flag_button;
    AlertDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        addListenerOnFlagButton();
        new ListTraduction( );
    }

    public void french(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.french_flag);
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();

    }
    public void uk(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.uk_flag);
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void iran(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.iran_flag);
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void saudi(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.native_language_flag);
        imagebutton.setImageResource(R.drawable.saudi_flag);
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }

    public void frenchRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.french_flag);
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();

    }
    public void ukRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.uk_flag);
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void iranRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.iran_flag);
        imagebutton.setAdjustViewBounds(true);
        this.dialog.dismiss();
    }
    public void saudiRight(View v){
        ImageButton imagebutton = (ImageButton)findViewById(R.id.destination_language_flag);
        imagebutton.setImageResource(R.drawable.saudi_flag);
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