package com.example.houssemha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Connect extends AppCompatActivity implements View.OnClickListener {
    Button connexion,annuler;
    EditText loginInput,passInput;
    EtudiantHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_connect);
        loginInput=findViewById(R.id.login);
        passInput=findViewById(R.id.pass);
        connexion = findViewById(R.id.connexion);
        connexion.setOnClickListener(this);
        annuler=findViewById(R.id.annuler);
        //  inscrire.setOnClickListener(this);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        connexion.startAnimation(myAnim);
        annuler.startAnimation(myAnim);
        loginInput.startAnimation(fadeIn);
        passInput.startAnimation(fadeIn);
        db = new EtudiantHandler(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.connexion){
            if (!loginInput.getText().toString().isEmpty() && !passInput.getText().toString().isEmpty()){
            if (db.checkEtudiant(loginInput.getText().toString(), passInput.getText().toString())){
                Toast.makeText(this, loginInput.getText().toString()+" est existe!",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Cet utilisateur n'existe pas !",Toast.LENGTH_SHORT).show();
            }
        }else  {
                Toast.makeText(this, "il faut remplir tous les champs",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
