package com.mertcaneren.beykentmobilapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ogrenciDevamsizlik extends AppCompatActivity {


    TextView d1ad,d2ad,d3ad,d4ad,d5ad,ders1devamsizlik,ders2devamsizlik,ders3devamsizlik,ders4devamsizlik,ders5devamsizlik;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_devamsizlik);

        d1ad=(TextView)findViewById(R.id.d1ad);
        d2ad=(TextView)findViewById(R.id.d2ad);
        d3ad=(TextView)findViewById(R.id.d3ad);
        d4ad=(TextView)findViewById(R.id.d4ad);
        d5ad=(TextView)findViewById(R.id.d5ad);
        ders1devamsizlik=(TextView)findViewById(R.id.ders1devamsizlik);
        ders2devamsizlik=(TextView)findViewById(R.id.ders2devamsizlik);
        ders3devamsizlik=(TextView)findViewById(R.id.ders3devamsizlik);
        ders4devamsizlik=(TextView)findViewById(R.id.ders4devamsizlik);
        ders5devamsizlik=(TextView)findViewById(R.id.ders5devamsizlik);

        yetki =FirebaseAuth.getInstance();
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();
        String id = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(id);
        yol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String sders1 = dataSnapshot.getValue(Post.class).ders1();
                d1ad.setText(sders1);

                String sders2 = dataSnapshot.getValue(Post.class).ders2();
                d2ad.setText(sders2);

                String sders3 = dataSnapshot.getValue(Post.class).ders3();
                d3ad.setText(sders3);

                String sders4 = dataSnapshot.getValue(Post.class).ders4();
                d4ad.setText(sders4);

                String sders5 = dataSnapshot.getValue(Post.class).ders5();
                d5ad.setText(sders5);

                String sders1devamsizlik = dataSnapshot.getValue(Post.class).ders1devamsizlik();
                ders1devamsizlik.setText(sders1devamsizlik);

                String sders2devamsizlik = dataSnapshot.getValue(Post.class).ders2devamsizlik();
                ders2devamsizlik.setText(sders2devamsizlik);

                String sders3devamsizlik = dataSnapshot.getValue(Post.class).ders3devamsizlik();
                ders3devamsizlik.setText(sders3devamsizlik);

                String sders4devamsizlik = dataSnapshot.getValue(Post.class).ders4devamsizlik();
                ders4devamsizlik.setText(sders4devamsizlik);

                String sders5devamsizlik = dataSnapshot.getValue(Post.class).ders5devamsizlik();
                ders5devamsizlik.setText(sders5devamsizlik);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                System.out.println("The read failed: " + databaseError.getCode());
            }

        });


    }

    public void oA(View view){

        Intent ıntent = new Intent(getApplicationContext(),ogrenciAnaSayfa.class);
        startActivity(ıntent);
    }
}
