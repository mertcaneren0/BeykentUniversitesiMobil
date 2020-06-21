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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class akademisyenBildirimGonder extends AppCompatActivity {

    EditText akabildirim;
    Button akabildir;
    DatabaseReference yol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akademisyen_bildirim_gonder);

        akabildirim=(EditText)findViewById(R.id.akabildirim);
        akabildir=(Button)findViewById(R.id.akabildir);



        akabildir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_bildirimm = akabildirim.getText().toString();
                if(TextUtils.isEmpty((str_bildirimm)))
                {
                    Toast.makeText(akademisyenBildirimGonder.this,"boş bırakma",Toast.LENGTH_LONG).show();
                }
                else
                {
                    kaydet(str_bildirimm);
                }
            }
        });

    }

    private void kaydet(final String str_bildirimm)
    {

        yol = FirebaseDatabase.getInstance().getReference().child("Öğrenciler").child("öğrenci_bilgileri").child("bildirim");

        HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("bildirim",str_bildirimm);




        yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if (task.isSuccessful())
                {
                    Intent intent =new Intent(akademisyenBildirimGonder.this,akademisyenAnaSayfa.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }

    public void akrann(View view){

        Intent ıntent = new Intent(getApplicationContext(),akademisyenAnaSayfa.class);
        startActivity(ıntent);
    }
}
