package com.company.n2i.refugees;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
    }
}
