package com.mertcaneren.beykentmobilapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ogrenciDersProgrami extends AppCompatActivity {

    TextView dp1,dp2,dp3,dp4,dp5,dps1,dps2,dps3,dps4,dps5;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_ders_programi);

        dp1=(TextView)findViewById(R.id.dp1);
        dp2=(TextView)findViewById(R.id.dp2);
        dp3=(TextView)findViewById(R.id.dp3);
        dp4=(TextView)findViewById(R.id.dp4);
        dp5=(TextView)findViewById(R.id.dp5);
        dps1=(TextView)findViewById(R.id.dps1);
        dps2=(TextView)findViewById(R.id.dps2);
        dps3=(TextView)findViewById(R.id.dps3);
        dps4=(TextView)findViewById(R.id.dps4);
        dps5=(TextView)findViewById(R.id.dps5);

        yetki =FirebaseAuth.getInstance();
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();
        String id = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(id);
        yol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String dep1 = dataSnapshot.getValue(Post.class).ders1();
                dp1.setText(dep1);

                String dep2 = dataSnapshot.getValue(Post.class).ders2();
                dp2.setText(dep2);

                String dep3 = dataSnapshot.getValue(Post.class).ders3();
                dp3.setText(dep3);

                String dep4 = dataSnapshot.getValue(Post.class).ders4();
                dp4.setText(dep4);

                String dep5 = dataSnapshot.getValue(Post.class).ders5();
                dp5.setText(dep5);

                String seders1sinav = dataSnapshot.getValue(Post.class).ders1sinif();
                dps1.setText(seders1sinav);

                String seders2sinav = dataSnapshot.getValue(Post.class).ders2sinif();
                dps2.setText(seders2sinav);

                String seders3sinav = dataSnapshot.getValue(Post.class).ders3sinif();
                dps3.setText(seders3sinav);

                String seders4sinav = dataSnapshot.getValue(Post.class).ders4sinif();
                dps4.setText(seders4sinav);

                String seders5sinav = dataSnapshot.getValue(Post.class).ders5sinif();
                dps5.setText(seders5sinav);


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
