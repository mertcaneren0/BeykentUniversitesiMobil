package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class adminPanel extends AppCompatActivity {

    Button ogrbilgigrs,akabilgigrs,prsbilgigrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        ogrbilgigrs =(Button)findViewById(R.id.ogrbilgigrs);
        akabilgigrs =(Button)findViewById(R.id.akabilgigrs);
        prsbilgigrs =(Button)findViewById(R.id.prsbilgigrs);
    }
    public void ogrenciBilgiGiris(View view){
        Intent ıntent = new Intent(getApplicationContext(),ogrenciBilgiGirisi.class);
        startActivity(ıntent);
    }
    public void akademisyenBilgiGiris(View view){
        Intent ıntent = new Intent(getApplicationContext(),adminAkademisyen.class);
        startActivity(ıntent);
    }
    public void personelBilgiGiris(View view){
        Intent ıntent = new Intent(getApplicationContext(),adminPersonel.class);
        startActivity(ıntent);
    }
}
