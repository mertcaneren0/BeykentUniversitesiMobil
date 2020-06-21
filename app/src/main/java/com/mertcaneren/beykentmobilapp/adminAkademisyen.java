package com.mertcaneren.beykentmobilapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class adminAkademisyen extends AppCompatActivity {

    EditText akaAd,akaSoyad,akaSifre,akaEmail;
    Button akaKayit;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_akademisyen);

        akaAd=(EditText)findViewById(R.id.akaAd);
        akaSoyad=(EditText)findViewById(R.id.akaSoyad);
        akaSifre=(EditText)findViewById(R.id.akaSifre);
        akaEmail=(EditText)findViewById(R.id.akaEmail);

        akaKayit=(Button) findViewById(R.id.akaKayit);

        yetki =FirebaseAuth.getInstance();

        akaKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String akademisyenAd = akaAd.getText().toString();
                String akademisyenSoyad = akaSoyad.getText().toString();
                String akademisyenSifre = akaSifre.getText().toString();
                String akademisyenEmail = akaEmail.getText().toString();

                if(TextUtils.isEmpty(akademisyenAd))
                {
                    Toast.makeText(adminAkademisyen.this,"boş bırakma",Toast.LENGTH_LONG).show();
                }
                else
                {
                    kaydet(akademisyenAd,akademisyenSoyad,akademisyenSifre,akademisyenEmail);
                }

            }
        });

    }
    private void kaydet (final String akademisyenAd, final String akademisyenSoyad ,final String akademisyenSifre, final String akademisyenEmail)
    {
        yetki.createUserWithEmailAndPassword(akademisyenEmail,akademisyenSifre).addOnCompleteListener(adminAkademisyen.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                FirebaseUser firebaseKullanici = yetki.getCurrentUser();

                String kullaniciId = firebaseKullanici.getUid();

                yol = FirebaseDatabase.getInstance().getReference().child("Akademisyenler").child("akademisyen_bilgileri").child(kullaniciId);


                HashMap<String,Object> hashMap = new HashMap<>();

                hashMap.put("id",kullaniciId);
                hashMap.put("akademisyen_ad",akademisyenAd);
                hashMap.put("akademisyen_soyad",akademisyenSoyad);
                hashMap.put("resimurl","");

                yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful())
                        {
                            Intent intent =new Intent(adminAkademisyen.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });

            }
        });
    }
}





















