package com.mertcaneren.beykentmobilapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminOgrenciGiris extends AppCompatActivity {

    private Button adminOgrenciGiris;
    private EditText adminOgrenciSifre, adminOgrenciEmail;

    FirebaseAuth girisYetkisi;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ogrenci_giris);

        adminOgrenciSifre = (EditText) findViewById(R.id.adminOgrenciSifre);
        adminOgrenciEmail = (EditText) findViewById(R.id.adminOgrenciEmail);
        adminOgrenciGiris = (Button) findViewById(R.id.adminOgrenciGiris);

        girisYetkisi = FirebaseAuth.getInstance();

    }
    public void adminOgrenciGir(View view) {

        adminOgrenciGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd = new ProgressDialog(adminOgrenciGiris.this);
                pd.setMessage("Lütfen Bekleyiniz");
                pd.show();

                String str_emailGiris = adminOgrenciEmail.getText().toString();
                String str_sifreGiris = adminOgrenciSifre.getText().toString();

                if(TextUtils.isEmpty(str_emailGiris)||TextUtils.isEmpty(str_sifreGiris))
                {
                    Toast.makeText(adminOgrenciGiris.this,"Bütün alanları doldur",Toast.LENGTH_LONG).show();
                }
                else {
                    girisYetkisi.signInWithEmailAndPassword(str_emailGiris,str_sifreGiris)
                            .addOnCompleteListener(adminOgrenciGiris.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        pd.dismiss();

                                        DatabaseReference yolGiris = FirebaseDatabase.getInstance().getReference().
                                                child("Öğrenciler").child(girisYetkisi.getCurrentUser().getUid());

                                        yolGiris.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                Intent intent = new Intent(adminOgrenciGiris.this,ogrenciPanel1.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                                finish();
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                    else
                                    {
                                        pd.dismiss();
                                        Toast.makeText(adminOgrenciGiris.this,"giriş başarısız",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
