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

public class ogrenciBilgiGirisi extends AppCompatActivity {

    EditText ogrAd, ogrSoyad, ogrEmail, ogrSifre;
    Button ogrKaydet;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_bilgi_girisi);

        ogrAd=(EditText)findViewById(R.id.ogrAd);
        ogrSoyad=(EditText)findViewById(R.id.ogrSoyad);
        ogrEmail=(EditText)findViewById(R.id.ogrEmail);
        ogrSifre=(EditText)findViewById(R.id.ogrSifre);

        ogrKaydet=(Button) findViewById(R.id.ogrKaydet);

        yetki =FirebaseAuth.getInstance();

        ogrKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_ogrenciAd = ogrAd.getText().toString();
                String str_ogrenciSoyad = ogrSoyad.getText().toString();
                String str_Email = ogrEmail.getText().toString();
                String str_Sifre = ogrSifre.getText().toString();

                if(TextUtils.isEmpty((str_ogrenciAd)))
                {
                    Toast.makeText(ogrenciBilgiGirisi.this,"boş bırakma",Toast.LENGTH_LONG).show();
                }
                else
                {
                    kaydet(str_ogrenciAd,str_ogrenciSoyad,str_Email,str_Sifre);
                }

            }
        });
    }
    private void kaydet (final String ogrenciAd, final String ogrenciSoyad ,final String Email, final String Sifre)
    {
        yetki.createUserWithEmailAndPassword(Email,Sifre).addOnCompleteListener(ogrenciBilgiGirisi.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    FirebaseUser firebaseKullanici = yetki.getCurrentUser();

                    String kullaniciId = firebaseKullanici.getUid();

                    yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(kullaniciId);


                    HashMap<String,Object> hashMap = new HashMap<>();

                    hashMap.put("id",kullaniciId);
                    hashMap.put("ogrenci_ad",ogrenciAd);
                    hashMap.put("ogrenci_soyad",ogrenciSoyad);
                    hashMap.put("resimurl","");
                    hashMap.put("ders1","");
                    hashMap.put("ders1not1","");
                    hashMap.put("ders1not2","");

                    hashMap.put("ders2","");
                    hashMap.put("ders2not1","");
                    hashMap.put("ders2not2","");

                    hashMap.put("ders3","");
                    hashMap.put("ders3not1","");
                    hashMap.put("ders3not2","");

                    hashMap.put("ders4","");
                    hashMap.put("ders4not1","");
                    hashMap.put("ders4not2","");

                    hashMap.put("ders5","");
                    hashMap.put("ders5not1","");
                    hashMap.put("ders5not2","");

                    hashMap.put("ders1sinav","");
                    hashMap.put("ders2sinav","");
                    hashMap.put("ders3sinav","");
                    hashMap.put("ders4sinav","");
                    hashMap.put("ders5sinav","");

                    hashMap.put("ders1devamsizlik","");
                    hashMap.put("ders2devamsizlik","");
                    hashMap.put("ders3devamsizlik","");
                    hashMap.put("ders4devamsizlik","");
                    hashMap.put("ders5devamsizlik","");

                    hashMap.put("ders1sinif","");
                    hashMap.put("ders2sinif","");
                    hashMap.put("ders3sinif","");
                    hashMap.put("ders4sinif","");
                    hashMap.put("ders5sinif","");

                    yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful())
                            {
                                Intent intent =new Intent(ogrenciBilgiGirisi.this,adminOgrenciGiris.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
    }
}


































