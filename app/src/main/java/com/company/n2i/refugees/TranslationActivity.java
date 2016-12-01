package com.company.n2i.refugees;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class TranslationActivity extends AppCompatActivity {


    ImageButton native_flag_button;
    ImageButton destination_flag_button;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        addListenerOnFlagButton();
        //inflateAlertDialog();
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
                /*alertadd.setNeutralButton("Here!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                });*/
                alertadd.show();
            }
        });

        destination_flag_button = (ImageButton) findViewById(R.id.destination_language_flag);
        destination_flag_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(TranslationActivity.this,
                        "Destination is clicked!", Toast.LENGTH_SHORT).show();
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