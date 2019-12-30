package com.example.myApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity implements View.OnClickListener {
    Button connexion,annuler;
    EditText login,pass;
    EtudiantHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        pass=findViewById(R.id.pass);
        connexion = findViewById(R.id.connexion);
        connexion.setOnClickListener(this);
        annuler=findViewById(R.id.annuler);
        annuler.setOnClickListener(this);

        db = new EtudiantHandler(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.connexion){


                Intent accueil = new Intent(this, Accueil.class);
                startActivity(accueil);

        }
        if (v.getId() == R.id.annuler) {
            Intent annuler = new Intent(this, Accueil.class);
            annuler.putExtra("cancel", " annuler ");
            startActivity(annuler);

        }
    }


}
