package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminGiris extends AppCompatActivity {

    private Button admingiris;
    private EditText adminid, adminsifre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_giris);

        adminid = (EditText) findViewById(R.id.adminid);
        adminsifre = (EditText) findViewById(R.id.adminsifre);
        admingiris = (Button) findViewById(R.id.admingiris);
    }
    public void admingirisyap(View view){

        if(adminid.getText().toString().equals("admin")&&adminsifre.getText().toString().equals("123"))
        {

            Intent ıntent = new Intent(getApplicationContext(), adminPanel.class);
            startActivity(ıntent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"GİRİŞ HATALI",Toast.LENGTH_SHORT).show();
        }
    }
}

