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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ogrenciPanel1 extends AppCompatActivity {

    EditText ders1,ders1not1,ders1not2,ders2,ders2not1,ders2not2,ders3,ders3not1,ders3not2,ders4,ders4not1,ders4not2,ders5,ders5not1,ders5not2,ders1sinav,ders2sinav,ders3sinav,ders4sinav,ders5sinav;
    Button ogrkayitson;

    FirebaseAuth yetki;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_panel1);

        ders1=(EditText)findViewById(R.id.ders1);
        ders1not1=(EditText)findViewById(R.id.ders1not1);
        ders1not2=(EditText)findViewById(R.id.ders1not2);
        ders2=(EditText)findViewById(R.id.ders2);
        ders2not1=(EditText)findViewById(R.id.ders2not1);
        ders2not2=(EditText)findViewById(R.id.ders2not2);
        ders3=(EditText)findViewById(R.id.ders3);
        ders3not1=(EditText)findViewById(R.id.ders3not1);
        ders3not2=(EditText)findViewById(R.id.ders3not2);
        ders4=(EditText)findViewById(R.id.ders4);
        ders4not1=(EditText)findViewById(R.id.ders4not1);
        ders4not2=(EditText)findViewById(R.id.ders4not2);
        ders5=(EditText)findViewById(R.id.ders5);
        ders5not1=(EditText)findViewById(R.id.ders5not1);
        ders5not2=(EditText)findViewById(R.id.ders5not2);
        ders1sinav=(EditText)findViewById(R.id.ders1sinav1);
        ders2sinav=(EditText)findViewById(R.id.ders2sinav);
        ders3sinav=(EditText)findViewById(R.id.ders3sinav);
        ders4sinav=(EditText)findViewById(R.id.ders4sinav);
        ders5sinav=(EditText)findViewById(R.id.ders5sinav);

        ogrkayitson=(Button)findViewById(R.id.ogrkayitson);

        yetki =FirebaseAuth.getInstance();

        ogrkayitson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_ders1 = ders1.getText().toString();
                String str_ders1not1 = ders1not1.getText().toString();
                String str_ders1not2 = ders1not2.getText().toString();
                String str_ders2 = ders2.getText().toString();
                String str_ders2not1 = ders2not1.getText().toString();
                String str_ders2not2 = ders2not2.getText().toString();
                String str_ders3 = ders3.getText().toString();
                String str_ders3not1 = ders3not1.getText().toString();
                String str_ders3not2 = ders3not2.getText().toString();
                String str_ders4 = ders4.getText().toString();
                String str_ders4not1 = ders4not1.getText().toString();
                String str_ders4not2 = ders4not2.getText().toString();
                String str_ders5 = ders5.getText().toString();
                String str_ders5not1 = ders5not1.getText().toString();
                String str_ders5not2 = ders5not2.getText().toString();
                String str_ders1sinav = ders1sinav.getText().toString();
                String str_ders2sinav = ders2sinav.getText().toString();
                String str_ders3sinav = ders3sinav.getText().toString();
                String str_ders4sinav = ders4sinav.getText().toString();
                String str_ders5sinav = ders5sinav.getText().toString();

                if(TextUtils.isEmpty((str_ders1)))
                {
                    Toast.makeText(ogrenciPanel1.this,"boş bırakma",Toast.LENGTH_LONG).show();
                }
                else
                {
                    kaydet(str_ders1,str_ders1not1,str_ders1not2,str_ders2,str_ders2not1,str_ders2not2,str_ders3,str_ders3not1,str_ders3not2,str_ders4,str_ders4not1,str_ders4not2,str_ders5,
                            str_ders5not1,str_ders5not2,str_ders1sinav,str_ders2sinav,str_ders3sinav,str_ders4sinav,str_ders5sinav);
                }
            }
        });
    }
    private void kaydet (final String str_ders1, final String str_ders1not1, final String str_ders1not2, final String str_ders2, final String str_ders2not1, final String str_ders2not2,
                         final String str_ders3, final String str_ders3not1, final String str_ders3not2, final String str_ders4, final String str_ders4not1,
                         final String str_ders4not2, final String str_ders5, final String str_ders5not1, final String str_ders5not2, final String str_ders1sinav, final String str_ders2sinav,
                         final String str_ders3sinav, final String str_ders4sinav, final String str_ders5sinav)
    {
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();

        String kullaniciId = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(kullaniciId);

        HashMap<String,Object> hashMap = new HashMap<>();


        hashMap.put("ders1",str_ders1);
        hashMap.put("ders1not1",str_ders1not1);
        hashMap.put("ders1not2",str_ders1not2);
        hashMap.put("ders2",str_ders2);
        hashMap.put("ders2not1",str_ders2not1);
        hashMap.put("ders2not2",str_ders2not2);
        hashMap.put("ders3",str_ders3);
        hashMap.put("ders3not1",str_ders3not1);
        hashMap.put("ders3not2",str_ders3not2);
        hashMap.put("ders4",str_ders4);
        hashMap.put("ders4not1",str_ders4not1);
        hashMap.put("ders4not2",str_ders4not2);
        hashMap.put("ders5",str_ders5);
        hashMap.put("ders5not1",str_ders5not1);
        hashMap.put("ders5not2",str_ders5not2);
        hashMap.put("ders1sinav",str_ders1sinav);
        hashMap.put("ders2sinav",str_ders2sinav);
        hashMap.put("ders3sinav",str_ders3sinav);
        hashMap.put("ders4sinav",str_ders4sinav);
        hashMap.put("ders5sinav",str_ders5sinav);



        yol.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if (task.isSuccessful())
                {
                    Intent intent =new Intent(ogrenciPanel1.this,ogrenciPanel2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}







































