package com.company.n2i.refugees;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class TranslationActivity extends AppCompatActivity {


    ImageButton native_flag_button;
    ImageButton destination_flag_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        addListenerOnFlagButton();
    }


    public void addListenerOnFlagButton() {

        native_flag_button = (ImageButton) findViewById(R.id.native_language_flag);
        native_flag_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(TranslationActivity.this,
                        "ImageButton is clicked!", Toast.LENGTH_SHORT).show();
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
}