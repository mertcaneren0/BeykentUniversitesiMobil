package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class akademisyenAnaSayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akademisyen_ana_sayfa);
    }

    public void akran(View view){

        Intent ıntent = new Intent(getApplicationContext(),akademisyenRandevu.class);
        startActivity(ıntent);

    }

    public void akbilgon(View view){

        Intent ıntent = new Intent(getApplicationContext(),akademisyenBildirimGonder.class);
        startActivity(ıntent);
    }

    public void kutuphanea(View view){

        Intent ıntent = new Intent(getApplicationContext(),kutuphane.class);
        startActivity(ıntent);
    }

    public void radyo(View view){

        Intent ıntent = new Intent(getApplicationContext(),radyo.class);
        startActivity(ıntent);
    }

    public void agrslgn(View view){

        Intent ıntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(ıntent);
    }
}
