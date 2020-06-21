package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ogrenciGrs(View view){
        Intent ıntent = new Intent(getApplicationContext(),ogrenciGirisLogin.class);
        startActivity(ıntent);
    }

    public void aGrs(View view){
        Intent ıntent = new Intent(getApplicationContext(),akademisyenGirisLogin.class);
        startActivity(ıntent);
    }

    public void pGrs(View view){
        Intent ıntent = new Intent(getApplicationContext(),personelGirisLogin.class);
        startActivity(ıntent);
    }
}
