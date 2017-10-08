package com.example.chinmay.logikartinc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Billing extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        TextView nme = (TextView) findViewById(R.id.name_text);
        TextView pckup = (TextView) findViewById(R.id.textView19);
        TextView dest = (TextView) findViewById(R.id.textView7);
        TextView dte = (TextView) findViewById(R.id.textView13);
        TextView cell = (TextView) findViewById(R.id.textView15);
        TextView email = (TextView) findViewById(R.id.textView16);
        TextView dist = (TextView) findViewById(R.id.textView17);
        TextView items = (TextView) findViewById(R.id.textView14);
        TextView cost = (TextView) findViewById(R.id.textView18);

        //pckup.setText(getIntent().getExtras().getString("source_loc"));


        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("source_loc");
        pckup.setText(message);
    }
}
