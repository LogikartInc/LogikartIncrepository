package com.example.chinmay.logikartinc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(1*1000);
                    Intent i= new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                }
                catch (Exception e)
                {

                }
            }
        };
        thread.start();


    }
}
