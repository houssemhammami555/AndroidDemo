package com.example.myApp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class liste extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);
        EtudiantHandler db = new EtudiantHandler(this);

    }



}
