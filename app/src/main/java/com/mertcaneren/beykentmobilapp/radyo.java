package com.mertcaneren.beykentmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class radyo extends AppCompatActivity {

    ImageButton linkButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radyo);

        linkButton =(ImageButton)findViewById(R.id.linkButton);

        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse("https://www.radyobeykent.com/%22");
                        Intent intent = new Intent(Intent.ACTION_VIEW,link);
                startActivity(intent);
            }
        });

    }

    public void akademisyenA(View view){

        Intent ıntent = new Intent(getApplicationContext(),akademisyenAnaSayfa.class);
        startActivity(ıntent);
    }
}
