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

public class ogrenciGirisLogin extends AppCompatActivity {

    private Button studentGiris;
    private EditText edt_email_Giris, edt_sifre_Giris;

    FirebaseAuth girisYetkisi;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_giris_login);

        edt_email_Giris = (EditText) findViewById(R.id.edt_email_Giris);
        edt_sifre_Giris = (EditText) findViewById(R.id.edt_sifre_Giris);
        studentGiris = (Button) findViewById(R.id.studentGiris);



        girisYetkisi = FirebaseAuth.getInstance();


    }


    public void oanasayfa(View view) {

        studentGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(ogrenciGirisLogin.this);
                pd.setMessage("Lütfen Bekleyiniz");
                pd.show();

                String str_emailGiris = edt_email_Giris.getText().toString();
                String str_sifreGiris = edt_sifre_Giris.getText().toString();

                if(TextUtils.isEmpty(str_emailGiris)||TextUtils.isEmpty(str_sifreGiris))
                {
                    Toast.makeText(ogrenciGirisLogin.this,"Bütün alanları doldur",Toast.LENGTH_LONG).show();

                }
                else {
                    girisYetkisi.signInWithEmailAndPassword(str_emailGiris,str_sifreGiris)
                            .addOnCompleteListener(ogrenciGirisLogin.this, new OnCompleteListener<AuthResult>() {
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

                                                Intent intent = new Intent(ogrenciGirisLogin.this,ogrenciAnaSayfa.class);
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
                                        Toast.makeText(ogrenciGirisLogin.this,"giriş başarısız",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }
            }
        });


    }
}
