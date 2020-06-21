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

public class adminPersonel extends AppCompatActivity {

    EditText perAd, perSoyad, perEmail, perSifre;
    Button perKayit;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_personel);

        perAd=(EditText)findViewById(R.id.perAd);
        perSoyad=(EditText)findViewById(R.id.perSoyad);
        perEmail=(EditText)findViewById(R.id.perEmail);
        perSifre=(EditText)findViewById(R.id.perSifre);

        perKayit=(Button) findViewById(R.id.perKayit);

        yetki = FirebaseAuth.getInstance();

        perKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String personelAd = perAd.getText().toString();
                String personelSoyad = perSoyad.getText().toString();
                String personelSifre = perEmail.getText().toString();
                String personelEmail = perSifre.getText().toString();

                if(TextUtils.isEmpty(personelAd))
                {
                    Toast.makeText(adminPersonel.this,"boş bırakma",Toast.LENGTH_LONG).show();
                }
                else
                {
                    kaydet(personelAd, personelSoyad, personelSifre, personelEmail);
                }

            }
        });
    }

    private void kaydet (final String personelAd, final String personelSoyad ,final String personelEmail, final String personelSifre)
    {
        yetki.createUserWithEmailAndPassword(personelEmail,personelSifre).addOnCompleteListener(adminPersonel.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                FirebaseUser firebaseKullanici = yetki.getCurrentUser();

                String kullaniciId = firebaseKullanici.getUid();

                yol = FirebaseDatabase.getInstance().getReference().child("Personeller").child("personel_bilgileri").child(kullaniciId);


                HashMap<String,Object> hashMap = new HashMap<>();

                hashMap.put("id",kullaniciId);
                hashMap.put("personel_ad",personelAd);
                hashMap.put("personel_soyad",personelSoyad);
                hashMap.put("resimurl","");

                yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful())
                        {
                            Intent intent =new Intent(adminPersonel.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });

            }
        });
    }

}



























