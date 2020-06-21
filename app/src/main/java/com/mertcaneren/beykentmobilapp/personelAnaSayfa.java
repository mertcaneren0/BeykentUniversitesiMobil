package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class personelAnaSayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel_ana_sayfa);
    }

    public void pSinav(View view){

        Intent ıntent = new Intent(getApplicationContext(),personelSinavYeri.class);
        startActivity(ıntent);
    }

    public void pNot(View view){

        Intent ıntent = new Intent(getApplicationContext(),personelNotDuzenleme.class);
        startActivity(ıntent);

    }

    public void pDers(View view){

        Intent ıntent = new Intent(getApplicationContext(),personelDersProgrami.class);
        startActivity(ıntent);
    }

    public void pBildirim(View view){
        Intent ıntent = new Intent(getApplicationContext(),personelBildirim.class);
        startActivity(ıntent);
    }

    public void aN(View view){

        Intent ıntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(ıntent);
    }
}
