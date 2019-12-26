package com.example.houssemha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends Activity implements View.OnClickListener {

        Button btn1,btn2,btn3;
    String msg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1=findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2=findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3=findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        EtudiantHandler db= new EtudiantHandler(this);


        Intent intent = getIntent();
        if (intent.hasExtra("new")) {
            msg = intent.getExtras().getString("new");
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        if (intent.hasExtra("cancel")) {
            msg = intent.getExtras().getString("cancel");
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:{
                Intent inscription = new Intent(this,Inscription.class);
                startActivity(inscription);break;
            }
            case R.id.button2:{
                Intent connect = new Intent(this, Connect.class);
                startActivity(connect);break;
            }
            case R.id.button3:{
                Intent contact= new Intent(this, Contact.class);
                startActivity(contact);break;
            }
        }
    }
}
