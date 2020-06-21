package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ogrenciAnaSayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_ana_sayfa);
    }

    public void oAna(View view){

        Intent ıntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(ıntent);
    }

    public void ogrenciNot (View view){

        Intent ıntent = new Intent(getApplicationContext(),notBilgileri.class);
        startActivity(ıntent);
    }

    public void ogrenciDevams(View view){

        Intent ıntent = new Intent(getApplicationContext(),ogrenciDevamsizlik.class);
        startActivity(ıntent);
    }

    public void oSinav(View view){

        Intent ıntent = new Intent(getApplicationContext(),ogrenciSinav.class);
        startActivity(ıntent);
    }
    public void oAka(View view){

        Intent ıntent = new Intent(getApplicationContext(),ogrenciAkademisyen.class);
        startActivity(ıntent);
    }

    public void oTrans(View view){

        Intent ıntent = new Intent(getApplicationContext(),ogrenciKutuphane.class);
        startActivity(ıntent);
    }

    public void radyos(View view){

        Intent ıntent = new Intent(getApplicationContext(),radyoOgrenci.class);
        startActivity(ıntent);
    }

    public void akRanAlm(View view){

        Intent ıntent = new Intent(getApplicationContext(),akademisyenRandevuAl.class);
        startActivity(ıntent);
    }
    public void oDersi(View view){

        Intent ıntent =new Intent(getApplicationContext(),ogrenciDersProgrami.class);
        startActivity(ıntent);
    }
}
