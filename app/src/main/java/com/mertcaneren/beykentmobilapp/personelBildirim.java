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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class personelBildirim extends AppCompatActivity {

    EditText bildirim;
    Button bildirimkayit;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel_bildirim);

        bildirim=(EditText)findViewById(R.id.etbildirim);
        bildirimkayit=(Button)findViewById(R.id.button2);



        bildirimkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_bildirim = bildirim.getText().toString();
                if(TextUtils.isEmpty((str_bildirim)))
                {
                    Toast.makeText(personelBildirim.this,"boş bırakma",Toast.LENGTH_LONG).show();
                }
                else
                {
                    kaydet(str_bildirim);
                }
            }
        });
    }
    private void kaydet(final String str_bildirim)
    {

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child("bildirim");

        HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("bildirim",str_bildirim);




        yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if (task.isSuccessful())
                {
                    Intent intent =new Intent(personelBildirim.this,personelAnaSayfa.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }




    public void pAn(View view){

        Intent ıntent = new Intent(getApplicationContext(),personelAnaSayfa.class);
        startActivity(ıntent);
    }
}
