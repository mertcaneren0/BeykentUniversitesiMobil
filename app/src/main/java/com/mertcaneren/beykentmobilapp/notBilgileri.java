package com.mertcaneren.beykentmobilapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class notBilgileri extends AppCompatActivity {


    TextView tvdersadi,tvnot1,tvnot2,ders1,ders1not1,ders1not2,ders2,ders2not1,ders2not2,ders3,ders3not1,ders3not2,ders4,ders4not1,ders4not2,ders5,ders5not1,ders5not2,devamsizlik,ders1sinav,ders2sinav,ders3sinav,ders4sinav,ders5sinav;
    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_bilgileri);
        tvdersadi=(TextView)findViewById(R.id.tvdersadi);
        tvnot1=(TextView)findViewById(R.id.tvnot1);
        tvnot2=(TextView)findViewById(R.id.tvnot2);


        ders1=(TextView)findViewById(R.id.oders1);
        ders1not1=(TextView) findViewById(R.id.oders1not1);
        ders1not2=(TextView) findViewById(R.id.oders1not2);
        ders2=(TextView)findViewById(R.id.oders2);
        ders2not1=(TextView)findViewById(R.id.oders2not1);
        ders2not2=(TextView)findViewById(R.id.oders2not2);
        ders3=(TextView)findViewById(R.id.oders3);
        ders3not1=(TextView)findViewById(R.id.oders3not1);
        ders3not2=(TextView)findViewById(R.id.oders3not2);
        ders4=(TextView)findViewById(R.id.oders4);
        ders4not1=(TextView)findViewById(R.id.oders4not1);
        ders4not2=(TextView)findViewById(R.id.oders4not2);
        ders5=(TextView)findViewById(R.id.oders5);
        ders5not1=(TextView)findViewById(R.id.oders5not1);
        ders5not2=(TextView)findViewById(R.id.oders5not2);

        yetki =FirebaseAuth.getInstance();
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();
        String id = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(id);
        yol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                String sders1 = dataSnapshot.getValue(Post.class).ders1();
                ders1.setText(sders1);

                String sders1not1 = dataSnapshot.getValue(Post.class).ders1not1();
                ders1not1.setText(sders1not1);

                String sders1not2 = dataSnapshot.getValue(Post.class).ders1not2();
                ders1not2.setText(sders1not2);

                String sders2 = dataSnapshot.getValue(Post.class).ders2();
                ders2.setText(sders2);

                String sders2not1 = dataSnapshot.getValue(Post.class).ders2not1();
                ders2not1.setText(sders2not1);

                String sders2not2 = dataSnapshot.getValue(Post.class).ders2not2();
                ders2not2.setText(sders2not2);

                String sders3 = dataSnapshot.getValue(Post.class).ders3();
                ders3.setText(sders3);

                String sders3not1 = dataSnapshot.getValue(Post.class).ders3not1();
                ders3not1.setText(sders3not1);

                String sders3not2 = dataSnapshot.getValue(Post.class).ders3not2();
                ders3not2.setText(sders3not2);

                String sders4 = dataSnapshot.getValue(Post.class).ders4();
                ders4.setText(sders4);

                String sders4not1 = dataSnapshot.getValue(Post.class).ders4not1();
                ders4not1.setText(sders4not1);

                String sders4not2 = dataSnapshot.getValue(Post.class).ders4not2();
                ders4not2.setText(sders4not2);

                String sders5 = dataSnapshot.getValue(Post.class).ders5();
                ders5.setText(sders5);

                String sders5not1 = dataSnapshot.getValue(Post.class).ders5not1();
                ders5not1.setText(sders5not1);

                String sders5not2 = dataSnapshot.getValue(Post.class).ders5not2();
                ders5not2.setText(sders5not2);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                System.out.println("The read failed: " + databaseError.getCode());
            }

    });

    }

    public void ogrenci (View view){

        Intent ıntent = new Intent(getApplicationContext(),ogrenciAnaSayfa.class);
        startActivity(ıntent);
    }
}
