package com.example.myApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends Activity implements View.OnClickListener {

        Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        b1=findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.button3);
        b3.setOnClickListener(this);
        EtudiantHandler db= new EtudiantHandler(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:{
                Intent inscription = new Intent(this,Inscription.class);
                startActivity(inscription);break;
            }
            case R.id.button2:{
                Intent connect = new Intent(this, login.class);
                startActivity(connect);break;
            }
            case R.id.button3:{
                Intent contact= new Intent(this, liste.class);
                startActivity(contact);break;
            }
        }
    }
}
