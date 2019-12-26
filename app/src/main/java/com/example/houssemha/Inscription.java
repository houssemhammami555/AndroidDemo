package com.example.houssemha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    Button inscrire,annuler;
    EditText nomInput,prenomInput,passInput,phoneInput;
    EtudiantHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_inscription);
        nomInput=findViewById(R.id.nom);
        prenomInput=findViewById(R.id.prenom);
        phoneInput=findViewById(R.id.pnum);
        passInput=findViewById(R.id.password);
        inscrire = findViewById(R.id.inscrire);
        annuler=findViewById(R.id.annI);
        inscrire.setOnClickListener(this);
        annuler.setOnClickListener(this);
      //  inscrire.setOnClickListener(this);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        inscrire.startAnimation(myAnim);
        annuler.startAnimation(myAnim);
        nomInput.startAnimation(fadeIn);
        passInput.startAnimation(fadeIn);
        prenomInput.startAnimation(fadeIn);
        phoneInput.startAnimation(fadeIn);
        System.out.println("*********************************************************** \n ******** \n **************************************************");
         db = new EtudiantHandler(this);


      /*  List<Etudiant> etdz = db.getAllEtudiants();
        String mess ="";
        for (Etudiant et :etdz){
            mess+="id:"+et.getId()+"Nom:"+et.getNom()+"Prenom"+et.getPrenom();
        }
     Log.d("mylist",mess);*/



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inscrire:{
                if(nomInput.getText().toString().isEmpty()||prenomInput.getText().toString().isEmpty() || phoneInput.getText().toString().isEmpty()||passInput.getText().toString().isEmpty()){

                  Toast.makeText(this, "il faut remplir tout les champs!",Toast.LENGTH_SHORT).show();break;}
                else {
                    db.insertEtudiant(new Etudiant(1,nomInput.getText().toString(),prenomInput.getText().toString(),phoneInput.getText().toString(),passInput.getText().toString()));
                    Toast.makeText(this, nomInput.getText().toString()+"ajout avec success!",Toast.LENGTH_SHORT).show(); break;
                }

                }


          case R.id.annI:{
              Intent in = new Intent(this, Home.class);
              startActivity(in);
            Toast.makeText(this, "ANNULER !",Toast.LENGTH_SHORT).show();break; }
        }
        }



}
