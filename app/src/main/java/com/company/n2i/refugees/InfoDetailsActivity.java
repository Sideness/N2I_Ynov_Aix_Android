package com.company.n2i.refugees;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Topic myTopic = (Topic)getIntent().getExtras().getSerializable("topic");

        TextView tvTitre = (TextView) findViewById(R.id.tvTitreDetail);
        TextView tvDesc = (TextView) findViewById(R.id.tvDescDetail);
        TextView tvAdresse = (TextView) findViewById(R.id.tvAdresseDetail);
        TextView tvNumero = (TextView) findViewById(R.id.tvNumeroDetail);
        TextView tvDate = (TextView) findViewById(R.id.tvDateDetail);
        TextView tvMail = (TextView) findViewById(R.id.tvMailDetail);
        Button btGoToMap = (Button) findViewById(R.id.btGoToMap);

        tvTitre.setText(myTopic.getTitre());
        tvDesc.setText(myTopic.getContenu());
        tvAdresse.setText(myTopic.getAdresse());
        tvNumero.setText(myTopic.getContactTel());
        if(myTopic.getDateEvent() != null){
            tvDate.setText(myTopic.getDateEvent().toString());
        }else{
            tvDate.setText(R.string.noDate);
        }

        tvMail.setText(myTopic.getContactMail());
        btGoToMap.setText(R.string.goToMap);
        btGoToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?f=d&hl=en&daddr=" + myTopic.getLat() + "," + myTopic.getLng();

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(Intent.createChooser(intent, "Select an application"));
            }
        });

        tvTitre.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextToSpeechHelper.getInstance().say(myTopic.getTitre(), getApplicationContext());
                return false;
            }
        });
        tvDesc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextToSpeechHelper.getInstance().say(myTopic.getContenu(), getApplicationContext());
                return false;
            }
        });

        tvAdresse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextToSpeechHelper.getInstance().say(myTopic.getAdresse(), getApplicationContext());
                return false;
            }
        });

        tvNumero.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextToSpeechHelper.getInstance().say(myTopic.getContactTel(), getApplicationContext());
                return false;
            }
        });

        tvDate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(myTopic.getDateEvent() != null){
                    TextToSpeechHelper.getInstance().say(myTopic.getDateEvent().toString(), getApplicationContext());
                }else{
                    TextToSpeechHelper.getInstance().say(getString(R.string.noDate), getApplicationContext());
                }

                return false;
            }
        });

        tvMail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextToSpeechHelper.getInstance().say(myTopic.getContactMail(), getApplicationContext());
                return false;
            }
        });

        btGoToMap.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextToSpeechHelper.getInstance().say(getString(R.string.goToMap), getApplicationContext());
                return false;
            }
        });

    }

}
