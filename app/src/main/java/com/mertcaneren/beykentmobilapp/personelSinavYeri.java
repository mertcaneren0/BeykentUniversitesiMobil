package com.mertcaneren.beykentmobilapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class personelSinavYeri extends AppCompatActivity {

    EditText dyr1,dyr2,dyr3,dyr4,dyr5;
    TextView der1,der2,der3,der4,der5,yr1,yr2,yr3,yr4,yr5;
    Button sinavguncelle;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel_sinav_yeri);

        dyr1 = (EditText) findViewById(R.id.dyr1);
        dyr2 = (EditText) findViewById(R.id.dyr2);
        dyr3 = (EditText) findViewById(R.id.dyr3);
        dyr4 = (EditText) findViewById(R.id.dyr4);
        dyr5 = (EditText) findViewById(R.id.dyr5);
        der1 = (TextView) findViewById(R.id.der1);
        der2 = (TextView) findViewById(R.id.der2);
        der3 = (TextView) findViewById(R.id.der3);
        der4 = (TextView) findViewById(R.id.der4);
        der5 = (TextView) findViewById(R.id.der5);
        yr1 = (TextView) findViewById(R.id.yr1);
        yr2 = (TextView) findViewById(R.id.yr2);
        yr3 = (TextView) findViewById(R.id.yr3);
        yr4 = (TextView) findViewById(R.id.yr4);
        yr5 = (TextView) findViewById(R.id.yr5);
        sinavguncelle = (Button) findViewById(R.id.sinavguncelle);

        yetki = FirebaseAuth.getInstance();
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();
        String id = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(id);
        yol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String derss1 = dataSnapshot.getValue(Post.class).ders1();
                der1.setText(derss1);

                String derss2 = dataSnapshot.getValue(Post.class).ders2();
                der2.setText(derss2);

                String derss3 = dataSnapshot.getValue(Post.class).ders3();
                der3.setText(derss3);

                String derss4 = dataSnapshot.getValue(Post.class).ders4();
                der4.setText(derss4);

                String derss5 = dataSnapshot.getValue(Post.class).ders5();
                der5.setText(derss5);

                String ssders1sinav = dataSnapshot.getValue(Post.class).ders1sinav();
                yr1.setText(ssders1sinav);

                String ssders2sinav = dataSnapshot.getValue(Post.class).ders2sinav();
                yr2.setText(ssders2sinav);

                String ssders3sinav = dataSnapshot.getValue(Post.class).ders3sinav();
                yr3.setText(ssders3sinav);

                String ssders4sinav = dataSnapshot.getValue(Post.class).ders4sinav();
                yr4.setText(ssders4sinav);

                String ssders5sinav = dataSnapshot.getValue(Post.class).ders5sinav();
                yr5.setText(ssders5sinav);


                sinavguncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str_ssinavbilgi1 = dyr1.getText().toString();
                        String str_ssinavbilgi2 = dyr2.getText().toString();
                        String str_ssinavbilgi3 = dyr3.getText().toString();
                        String str_ssinavbilgi4 = dyr4.getText().toString();
                        String str_ssinavbilgi5 = dyr5.getText().toString();

                        if (TextUtils.isEmpty((str_ssinavbilgi1))) {
                            Toast.makeText(personelSinavYeri.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();

                        }
                        /*else if (TextUtils.isEmpty((str_ssinavbilgi2 ))) {
                            Toast.makeText(personelSinavYeri.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_ssinavbilgi3 ))) {
                            Toast.makeText(personelSinavYeri.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_ssinavbilgi4 ))) {
                            Toast.makeText(personelSinavYeri.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_ssinavbilgi5 ))) {
                            Toast.makeText(personelSinavYeri.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }*/

                        else
                            {
                            kaydet(str_ssinavbilgi1, str_ssinavbilgi2, str_ssinavbilgi3, str_ssinavbilgi4, str_ssinavbilgi5);
                            }
                    }
                });
            }

                private void kaydet (final String str_ssinavbilgi1,final String str_ssinavbilgi2,final String str_ssinavbilgi3,final String str_ssinavbilgi4,final String str_ssinavbilgi5)
                {
                    FirebaseUser firebaseKullanici = yetki.getCurrentUser();

                    String kullaniciId = firebaseKullanici.getUid();

                    yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(kullaniciId);

                    HashMap<String,Object> hashMap = new HashMap<>();


                    hashMap.put("ders1sinav",str_ssinavbilgi1);
                    /*hashMap.put("ders2sinav",str_ssinavbilgi2);
                    hashMap.put("ders3sinav",str_ssinavbilgi3);
                    hashMap.put("ders4sinav",str_ssinavbilgi4);
                    hashMap.put("ders5sinav",str_ssinavbilgi5);*/

                    yol.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if (task.isSuccessful())
                            {
                                Intent intent =new Intent(personelSinavYeri.this,personelSinavYeri.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }


    public void peAn(View view){

        Intent ıntent = new Intent(getApplicationContext(),personelAnaSayfa.class);
        startActivity(ıntent);
    }
}
