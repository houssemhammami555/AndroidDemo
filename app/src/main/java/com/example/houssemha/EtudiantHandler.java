package com.example.houssemha;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class EtudiantHandler extends SQLiteOpenHelper {
    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "StudentsManager";
    private static final String TABLE_Etudiants = "table_Etudiants";
    private static final String COLONNE_ID = "id";
    private static final String COLONNE_NOM = "nom";
    private static final String COLONNE_PRENOM = "prenom";
    private static final String COLONNE_PNUMBER = "pnumber";
    private static final String COLONNE_PASSWORD = "password";
    private static final String REQUETE_CREATION_BD = "create table "+ TABLE_Etudiants + " (" + COLONNE_ID+ " integer primary key autoincrement, "  + COLONNE_NOM + " TEXT not null, " + COLONNE_PRENOM +" TEXT not null,"+ COLONNE_PNUMBER+ " TEXT not null UNIQUE," + COLONNE_PASSWORD + " TEXT not null);";


    public EtudiantHandler( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public EtudiantHandler(Context context) {
        super(context, DATABASE_NAME ,null, DATABASE_VERSION
        ); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQUETE_CREATION_BD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Etudiants);
        onCreate(db);
    }


        public void  insertEtudiant(Etudiant etudiant ){
            SQLiteDatabase madb= this.getWritableDatabase();
            ContentValues valeurs = new ContentValues();

                valeurs.put(COLONNE_NOM, etudiant.getNom());
                valeurs.put(COLONNE_PRENOM, etudiant.getPrenom());
                valeurs.put(COLONNE_PNUMBER, etudiant.getPhoneNumber());
                valeurs.put(COLONNE_PASSWORD, etudiant.getPassword());
                madb.insert(TABLE_Etudiants,null,valeurs);
                madb.close();

        }

        Etudiant getEtudiant(int id){
        SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor=db.query(TABLE_Etudiants, new String[]{
                    COLONNE_ID,COLONNE_NOM,COLONNE_PRENOM,COLONNE_PNUMBER,COLONNE_PASSWORD},COLONNE_ID+"=?",new String[]
                    {String.valueOf(id)},null,null,null );
            return cursorToEtudiant(cursor);

        }
        public  Boolean checkEtudiant(String phoneNumber , String password){

        SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor =db.query(TABLE_Etudiants , new String[]{ COLONNE_ID,COLONNE_NOM,COLONNE_PRENOM,COLONNE_PNUMBER,COLONNE_PASSWORD},COLONNE_PNUMBER+"=? AND "+COLONNE_PASSWORD+"=?",new String[]
                    {phoneNumber,password},null,null,null );

            if (cursor!=null && cursor.getCount()!=0){
                cursor.moveToFirst();
                return true;

            }else{
                return false;

            }
       // return exist;
        }
    private Etudiant cursorToEtudiant(Cursor c) {

      if (c==null || c.getCount() == 0)
            return null;
        c.moveToFirst();
        Etudiant etudiant= new Etudiant();
        etudiant.setId(c.getInt(0));
        etudiant.setNom(c.getString(1));
        etudiant.setPrenom(c.getString(2));
        etudiant.setPhoneNumber(c.getString(3));
        etudiant.setPassword(c.getString(4));

        return etudiant;

    }
    //this is the default method , like the cours in the class !
public ArrayList<Etudiant>getAllEtudiants(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c =db.query(TABLE_Etudiants,new String[]{COLONNE_ID,COLONNE_NOM,COLONNE_PRENOM,COLONNE_PNUMBER,COLONNE_PASSWORD},null,null,null,null,null);
        return  cursorToEtudiants(c);
}

    // and this method used in other activity to show data in list ! -- i created it ^^ !
public  ArrayList<HashMap<String,String>> getEtudiants(){
        SQLiteDatabase db= this.getWritableDatabase();
        ArrayList<HashMap<String, String>> Etudiant_list = new ArrayList<>();
        String query= "SELECT nom, prenom, pnumber FROM "+TABLE_Etudiants;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> etudiant = new HashMap<>();
            etudiant.put("nom",cursor.getString(cursor.getColumnIndex(COLONNE_NOM)));
            etudiant.put("prenom",cursor.getString(cursor.getColumnIndex(COLONNE_PRENOM)));
            etudiant.put("pnumber",cursor.getString(cursor.getColumnIndex(COLONNE_PNUMBER)));
            Etudiant_list.add(etudiant);

        }
        return  Etudiant_list;
}

private  ArrayList<Etudiant> cursorToEtudiants(Cursor c){
        if(c.getCount()==0)
            return  new ArrayList<Etudiant>(0);
        ArrayList<Etudiant> allEtudiants=new ArrayList<Etudiant>(c.getCount());

        c.moveToFirst();
        do {
            Etudiant etudiant= new Etudiant();
            etudiant.setId(c.getInt(0));
            etudiant.setNom(c.getString(1));
            etudiant.setPrenom(c.getString(2));
            etudiant.setPhoneNumber(c.getString(3));
            etudiant.setPassword(c.getString(4));
            allEtudiants.add(etudiant);
        }while (c.moveToNext());

    c.close();
    return  allEtudiants;
}

    //-----------------------------------------//
}
