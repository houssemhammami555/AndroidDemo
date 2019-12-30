package com.example.myApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    Button inscrire,annuler;
    EditText nom,prenom,pass;
    EtudiantHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inscription);
        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        pass=findViewById(R.id.password);
        inscrire = findViewById(R.id.inscrire);
        annuler=findViewById(R.id.annI);
        inscrire.setOnClickListener(this);
        annuler.setOnClickListener(this);

         db = new EtudiantHandler(this);






    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inscrire:{

                    db.insertEtudiant(new Etudiant(1,nom.getText().toString(),prenom.getText().toString(),pass.getText().toString()));
                    //Toast.makeText(this, nomInput.getText().toString()+"ajout avec success!",Toast.LENGTH_SHORT).show();
                    Intent accueil = new Intent(this, Accueil.class);

                    startActivity(accueil);

                    break;



                //thread.start();
                }


          case R.id.annI:{
              Intent annuler = new Intent(this, Accueil.class);

              startActivity(annuler);
              break;
          }
        }
        }



}
