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

public class ogrenciSinav extends AppCompatActivity {

    TextView de1,de2,de3,de4,de5,ders1sinav1,ders1sinav2,ders1sinav5,ders1sinav4,ders1sinav3;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_sinav);

        de1=(TextView)findViewById(R.id.de1);
        de2=(TextView)findViewById(R.id.de2);
        de3=(TextView)findViewById(R.id.der3);
        de4=(TextView)findViewById(R.id.de4);
        de5=(TextView)findViewById(R.id.de5);
        ders1sinav1=(TextView)findViewById(R.id.ders1sinav1);
        ders1sinav2=(TextView)findViewById(R.id.ders1sinav2);
        ders1sinav3=(TextView)findViewById(R.id.ders1sinav3);
        ders1sinav4=(TextView)findViewById(R.id.ders1sinav4);
        ders1sinav5=(TextView)findViewById(R.id.ders1sinav5);

        yetki =FirebaseAuth.getInstance();
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();
        String id = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(id);
        yol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String der1 = dataSnapshot.getValue(Post.class).ders1();
                de1.setText(der1);

                String der2 = dataSnapshot.getValue(Post.class).ders2();
                de2.setText(der2);

                String der3 = dataSnapshot.getValue(Post.class).ders3();
                de3.setText(der3);

                String der4 = dataSnapshot.getValue(Post.class).ders4();
                de4.setText(der4);

                String der5 = dataSnapshot.getValue(Post.class).ders5();
                de5.setText(der5);

                String sders1sinav = dataSnapshot.getValue(Post.class).ders1sinav();
                ders1sinav1.setText(sders1sinav);

                String sders2sinav = dataSnapshot.getValue(Post.class).ders2sinav();
                ders1sinav2.setText(sders2sinav);

                String sders3sinav = dataSnapshot.getValue(Post.class).ders3sinav();
                ders1sinav3.setText(sders3sinav);

                String sders4sinav = dataSnapshot.getValue(Post.class).ders4sinav();
                ders1sinav4.setText(sders4sinav);

                String sders5sinav = dataSnapshot.getValue(Post.class).ders5sinav();
                ders1sinav5.setText(sders5sinav);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                System.out.println("The read failed: " + databaseError.getCode());
            }

        });
    }
    public void oAn(View view){

        Intent ıntent = new Intent(getApplicationContext(),ogrenciAnaSayfa.class);
        startActivity(ıntent);
    }
}
