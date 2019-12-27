package com.example.houssemha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static android.Manifest.permission.CALL_PHONE;

public class Contact extends AppCompatActivity {

    TextView txt;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contact);
        EtudiantHandler db = new EtudiantHandler(this);
        ArrayList<HashMap<String, String>> Etudiants_list = db.getEtudiants();
        ListView lv = (ListView) findViewById(R.id.list);
        ListAdapter adapter = new SimpleAdapter(this, Etudiants_list, R.layout.list_row, new String[]{"nom", "prenom", "pnumber"}, new int[]{R.id.nom, R.id.prenom, R.id.phone});

        lv.setAdapter(adapter);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        lv.startAnimation(fadeIn);
        txt = findViewById(R.id.textView);
        txt.startAnimation(myAnim);
        back = findViewById(R.id.backtohome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gohome = new Intent(getApplicationContext(), Home.class);
                startActivity(gohome);

            }
        });
    }



}
