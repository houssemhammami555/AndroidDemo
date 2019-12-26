package com.example.houssemha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

public class Contact extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contact);
        EtudiantHandler db = new EtudiantHandler(this);
        ArrayList<HashMap<String, String>> Etudiants_list=db.getEtudiants();
        ListView lv =(ListView)findViewById(R.id.list);
        ListAdapter adapter= new SimpleAdapter(this,Etudiants_list, R.layout.list_row, new String[]{"nom","prenom","pnumber"},new int[]{R.id.nom, R.id.prenom, R.id.phone});

        lv.setAdapter(adapter);
    }
}
