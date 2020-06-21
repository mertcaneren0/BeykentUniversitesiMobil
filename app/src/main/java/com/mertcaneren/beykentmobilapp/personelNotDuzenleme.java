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

public class personelNotDuzenleme extends AppCompatActivity {

    TextView pnde1,pnde2,pnde3,pnde4,pnde5,pnn1,pnn2,pnn3,pnn4,pnn5,pnn6,pnn7,pnn8,pnn9,pnn10;
    EditText etn,etn1,etn2,etn3,etn4,etn5,etn6,etn7,etn8,etn9;
    Button notguncelle;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel_not_duzenleme);

        etn = (EditText) findViewById(R.id.etn);
        etn1 = (EditText) findViewById(R.id.etn1);
        etn2 = (EditText) findViewById(R.id.etn2);
        etn3 = (EditText) findViewById(R.id.etn3);
        etn4 = (EditText) findViewById(R.id.etn4);
        etn5 = (EditText) findViewById(R.id.etn5);
        etn6 = (EditText) findViewById(R.id.etn6);
        etn7 = (EditText) findViewById(R.id.etn7);
        etn8 = (EditText) findViewById(R.id.etn8);
        etn9 = (EditText) findViewById(R.id.etn9);

        pnde1 = (TextView) findViewById(R.id.pnde1);
        pnde2 = (TextView) findViewById(R.id.pnde2);
        pnde3 = (TextView) findViewById(R.id.pnde3);
        pnde4 = (TextView) findViewById(R.id.pnde4);
        pnde5 = (TextView) findViewById(R.id.pnde5);

        pnn1 = (TextView) findViewById(R.id.pnn1);
        pnn2 = (TextView) findViewById(R.id.pnn2);
        pnn3 = (TextView) findViewById(R.id.pnn3);
        pnn4 = (TextView) findViewById(R.id.pnn4);
        pnn5 = (TextView) findViewById(R.id.pnn5);
        pnn6 = (TextView) findViewById(R.id.pnn6);
        pnn7 = (TextView) findViewById(R.id.pnn7);
        pnn8 = (TextView) findViewById(R.id.pnn8);
        pnn9 = (TextView) findViewById(R.id.pnn9);
        pnn10 = (TextView) findViewById(R.id.pnn10);


        notguncelle = (Button) findViewById(R.id.notguncelle);

        yetki = FirebaseAuth.getInstance();
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();
        String id = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(id);
        yol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String dersss1 = dataSnapshot.getValue(Post.class).ders1();
                pnde1.setText(dersss1);

                String dersss2 = dataSnapshot.getValue(Post.class).ders2();
                pnde2.setText(dersss2);

                String dersss3 = dataSnapshot.getValue(Post.class).ders3();
                pnde3.setText(dersss3);

                String dersss4 = dataSnapshot.getValue(Post.class).ders4();
                pnde4.setText(dersss4);

                String dersss5 = dataSnapshot.getValue(Post.class).ders5();
                pnde5.setText(dersss5);

                String d1n1 = dataSnapshot.getValue(Post.class).ders1not1();
                pnn1.setText(d1n1);

                String d1n2 = dataSnapshot.getValue(Post.class).ders1not2();
                pnn2.setText(d1n2);

                String d2n1 = dataSnapshot.getValue(Post.class).ders2not1();
                pnn3.setText(d2n1);

                String d2n2 = dataSnapshot.getValue(Post.class).ders2not2();
                pnn4.setText(d2n2);

                String d3n1 = dataSnapshot.getValue(Post.class).ders3not1();
                pnn5.setText(d3n1);

                String d3n2 = dataSnapshot.getValue(Post.class).ders3not2();
                pnn6.setText(d3n2);

                String d4n1 = dataSnapshot.getValue(Post.class).ders4not1();
                pnn7.setText(d4n1);

                String d4n2 = dataSnapshot.getValue(Post.class).ders4not2();
                pnn8.setText(d4n2);

                String d5n1 = dataSnapshot.getValue(Post.class).ders5not1();
                pnn9.setText(d5n1);

                String d5n2 = dataSnapshot.getValue(Post.class).ders5not2();
                pnn10.setText(d5n2);


                notguncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str_notbilgi1 = etn.getText().toString();
                        String str_notbilgi2 = etn1.getText().toString();
                        String str_notbilgi3 = etn2.getText().toString();
                        String str_notbilgi4 = etn3.getText().toString();
                        String str_notbilgi5 = etn4.getText().toString();
                        String str_notbilgi6 = etn5.getText().toString();
                        String str_notbilgi7 = etn6.getText().toString();
                        String str_notbilgi8 = etn7.getText().toString();
                        String str_notbilgi9 = etn8.getText().toString();
                        String str_notbilgi10 = etn9.getText().toString();

                        if (TextUtils.isEmpty((str_notbilgi1))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();

                        }
                        /*else if (TextUtils.isEmpty((str_notbilgi2 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi3 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi4 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi5 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi6 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi7 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi8 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi9 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                        else if (TextUtils.isEmpty((str_notbilgi10 ))) {
                            Toast.makeText(personelNotDuzenleme.this, "Boş alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }

                        */

                        else
                        {
                            kaydet(str_notbilgi1, str_notbilgi2, str_notbilgi3, str_notbilgi4, str_notbilgi5,str_notbilgi6,str_notbilgi7,str_notbilgi8,str_notbilgi9,str_notbilgi10);
                        }
                    }
                });
            }

            private void kaydet (final String str_notbilgi1,final String str_notbilgi2,final String str_notbilgi3,final String str_notbilgi4,
                                 final String str_notbilgi5,final String str_notbilgi6,final String str_notbilgi7,final String str_notbilgi8,
                                 final String str_notbilgi9,final String str_notbilgi10)
            {
                FirebaseUser firebaseKullanici = yetki.getCurrentUser();

                String kullaniciId = firebaseKullanici.getUid();

                yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(kullaniciId);

                HashMap<String,Object> hashMap = new HashMap<>();


                hashMap.put("ders1not1",str_notbilgi1);
                hashMap.put("ders1not2",str_notbilgi2);
                /*hashMap.put("ders2not1",str_notbilgi3);
                hashMap.put("ders2not2",str_notbilgi4);
                hashMap.put("ders3not1",str_notbilgi5);
                hashMap.put("ders3not2",str_notbilgi6);
                hashMap.put("ders4not1",str_notbilgi7);
                hashMap.put("ders4not2",str_notbilgi8);
                hashMap.put("ders5not1",str_notbilgi9);
                hashMap.put("ders5not2",str_notbilgi10);*/

                yol.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Intent intent =new Intent(personelNotDuzenleme.this,personelNotDuzenleme.class);
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
