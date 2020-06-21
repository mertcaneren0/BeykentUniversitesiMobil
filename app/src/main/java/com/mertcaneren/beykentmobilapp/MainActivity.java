package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ImageView adminview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminview =(ImageView)findViewById(R.id.adminview);

    }

    public void adminegit(View view){
        Intent ıntent = new Intent(getApplicationContext(),adminGiris.class);
        startActivity(ıntent);
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
