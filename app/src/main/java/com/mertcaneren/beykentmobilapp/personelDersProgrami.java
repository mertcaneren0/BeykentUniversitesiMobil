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

public class personelDersProgrami extends AppCompatActivity {

    EditText deeger1,deeger2,deeger3,deeger4,deeger5;
    TextView deers1,deers2,deers3,deers4,deers5,siinif1,siinif2,siinif3,siinif4,siinif5;
    Button derslikguncelle;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel_ders_programi);

        deeger1 = (EditText) findViewById(R.id.deeger1);
        deeger2 = (EditText) findViewById(R.id.deeger2);
        deeger3 = (EditText) findViewById(R.id.deeger3);
        deeger4 = (EditText) findViewById(R.id.deeger4);
        deeger5 = (EditText) findViewById(R.id.deeger5);
        deers1 = (TextView) findViewById(R.id.deers1);
        deers2 = (TextView) findViewById(R.id.deers2);
        deers3 = (TextView) findViewById(R.id.deers3);
        deers4 = (TextView) findViewById(R.id.deers4);
        deers5 = (TextView) findViewById(R.id.deers5);
        siinif1 = (TextView) findViewById(R.id.siinif1);
        siinif2 = (TextView) findViewById(R.id.siinif2);
        siinif3 = (TextView) findViewById(R.id.siinif3);
        siinif4 = (TextView) findViewById(R.id.siinif4);
        siinif5 = (TextView) findViewById(R.id.siinif5);
        derslikguncelle = (Button) findViewById(R.id.derslikguncelle);

        yetki = FirebaseAuth.getInstance();
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();
        String id = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(id);
        yol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String dersss1 = dataSnapshot.getValue(Post.class).ders1();
                deers1.setText(dersss1);

                String dersss2 = dataSnapshot.getValue(Post.class).ders2();
                deers2.setText(dersss2);

                String dersss3 = dataSnapshot.getValue(Post.class).ders3();
                deers3.setText(dersss3);

                String dersss4 = dataSnapshot.getValue(Post.class).ders4();
                deers4.setText(dersss4);

                String dersss5 = dataSnapshot.getValue(Post.class).ders5();
                siinif1.setText(dersss5);

                String ssders1sinav = dataSnapshot.getValue(Post.class).ders1sinif();
                siinif1.setText(ssders1sinav);

                String ssders2sinav = dataSnapshot.getValue(Post.class).ders2sinif();
                siinif2.setText(ssders2sinav);

                String ssders3sinav = dataSnapshot.getValue(Post.class).ders3sinif();
                siinif3.setText(ssders3sinav);

                String ssders4sinav = dataSnapshot.getValue(Post.class).ders4sinif();
                siinif4.setText(ssders4sinav);

                String ssders5sinav = dataSnapshot.getValue(Post.class).ders5sinif();
                siinif5.setText(ssders5sinav);


                derslikguncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str_deeger1 = deeger1.getText().toString();
                        String str_deeger2 = deeger2.getText().toString();
                        String str_deeger3 = deeger3.getText().toString();
                        String str_deeger4 = deeger4.getText().toString();
                        String str_deeger5 = deeger5.getText().toString();

                        if (TextUtils.isEmpty((str_deeger1))) {
                            Toast.makeText(personelDersProgrami.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();

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
                            kaydet(str_deeger1, str_deeger2, str_deeger3, str_deeger4, str_deeger5);
                        }
                    }
                });
            }

            private void kaydet (final String str_deeger1,final String str_deeger2,final String str_deeger3,final String str_deeger4,final String str_deeger5)
            {
                FirebaseUser firebaseKullanici = yetki.getCurrentUser();

                String kullaniciId = firebaseKullanici.getUid();

                yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(kullaniciId);

                HashMap<String,Object> hashMap = new HashMap<>();


                hashMap.put("ders1sinif",str_deeger1);
                    /*hashMap.put("ders2sinif",str_deeger2);
                    hashMap.put("ders3sinif",str_deeger3);
                    hashMap.put("ders4sinif",str_deeger4);
                    hashMap.put("ders5sinif",str_deeger5);*/

                yol.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Intent intent =new Intent(personelDersProgrami.this,personelDersProgrami.class);
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
    public void pAn(View view){

        Intent ıntent = new Intent(getApplicationContext(),personelAnaSayfa.class);
        startActivity(ıntent);
    }
}
