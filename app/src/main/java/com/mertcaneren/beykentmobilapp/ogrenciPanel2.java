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

public class ogrenciPanel2 extends AppCompatActivity {


    EditText ders1devamsizlik,ders2devamsizlik,ders3devamsizlik,ders4devamsizlik,ders5devamsizlik,ders1sinif,ders2sinif,ders3sinif,ders4sinif,ders5sinif;
    Button kayditamamla;

    FirebaseAuth yetki;
    DatabaseReference yol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_panel2);

        ders1devamsizlik=(EditText)findViewById(R.id.ders1dev);
        ders2devamsizlik=(EditText)findViewById(R.id.ders2dev);
        ders3devamsizlik=(EditText)findViewById(R.id.ders3dev);
        ders4devamsizlik=(EditText)findViewById(R.id.ders4dev);
        ders5devamsizlik=(EditText)findViewById(R.id.ders5dev);
        ders1sinif=(EditText)findViewById(R.id.ders1sinif);
        ders2sinif=(EditText)findViewById(R.id.ders2sinif);
        ders3sinif=(EditText)findViewById(R.id.ders3sinif);
        ders4sinif=(EditText)findViewById(R.id.ders4sinif);
        ders5sinif=(EditText)findViewById(R.id.ders5sinif);


        kayditamamla=(Button)findViewById(R.id.kayditamamla);

        yetki =FirebaseAuth.getInstance();

        kayditamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_ders1devamsizlik = ders1devamsizlik.getText().toString();
                String str_ders2devamsizlik = ders2devamsizlik.getText().toString();
                String str_ders3devamsizlik = ders3devamsizlik.getText().toString();
                String str_ders4devamsizlik = ders4devamsizlik.getText().toString();
                String str_ders5devamsizlik = ders5devamsizlik.getText().toString();
                String str_ders1sinif = ders1sinif.getText().toString();
                String str_ders2sinif = ders2sinif.getText().toString();
                String str_ders3sinif = ders3sinif.getText().toString();
                String str_ders4sinif = ders4sinif.getText().toString();
                String str_ders5sinif = ders5sinif.getText().toString();

                if(TextUtils.isEmpty((str_ders1devamsizlik)))
                {
                    Toast.makeText(ogrenciPanel2.this,"boş bırakma",Toast.LENGTH_LONG).show();
                }
                else
                {
                    kaydet(str_ders1devamsizlik,str_ders2devamsizlik,str_ders3devamsizlik,str_ders4devamsizlik,str_ders5devamsizlik,str_ders1sinif,str_ders2sinif,
                            str_ders3sinif,str_ders4sinif,str_ders5sinif);
                }

            }
        });

    }
    private void kaydet (final String str_ders1devamsizlik, final String str_ders2devamsizlik, final String str_ders3devamsizlik, final String str_ders4devamsizlik, final String str_ders5devamsizlik,
                         final String str_ders1sinif, final String str_ders2sinif, final String str_ders3sinif, final String str_ders4sinif, final String str_ders5sinif)
    {
        FirebaseUser firebaseKullanici = yetki.getCurrentUser();

        String kullaniciId = firebaseKullanici.getUid();

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child(kullaniciId);

        HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("ders1devamsizlik",str_ders1devamsizlik);
        hashMap.put("ders2devamsizlik",str_ders2devamsizlik);
        hashMap.put("ders3devamsizlik",str_ders3devamsizlik);
        hashMap.put("ders4devamsizlik",str_ders4devamsizlik);
        hashMap.put("ders5devamsizlik",str_ders5devamsizlik);
        hashMap.put("ders1sinif",str_ders1sinif);
        hashMap.put("ders2sinif",str_ders2sinif);
        hashMap.put("ders3sinif",str_ders3sinif);
        hashMap.put("ders4sinif",str_ders4sinif);
        hashMap.put("ders5sinif",str_ders5sinif);

        yol.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if (task.isSuccessful())
                {
                    Intent intent =new Intent(ogrenciPanel2.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}


























