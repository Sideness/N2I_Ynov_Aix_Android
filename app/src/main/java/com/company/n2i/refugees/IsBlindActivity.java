package com.company.n2i.refugees;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class IsBlindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_blind);

        RelativeLayout lnBlindMode = (RelativeLayout) findViewById(R.id.rlBlindMode);
        RelativeLayout lnNormalMode = (RelativeLayout) findViewById(R.id.rlNormalMode);

        lnBlindMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO setglobal variable for blind mode
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        lnNormalMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO setglobal variable for blind mode
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
