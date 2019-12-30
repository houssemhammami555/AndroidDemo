package com.example.myApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class EtudiantHandler extends SQLiteOpenHelper {
    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "StudentsManager";
    private static final String TABLE_Etudiants = "Etudiants";
    private static final String COLONNE_ID = "id";
    private static final String COLONNE_NOM = "nom";
    private static final String COLONNE_PRENOM = "prenom";
    private static final String COLONNE_PASSWORD = "password";
    private static final String REQUETE_CREATION_BD = "create table "+ TABLE_Etudiants + " (" + COLONNE_ID+ " integer primary key autoincrement, "  + COLONNE_NOM + " TEXT , " + COLONNE_PRENOM +" TEXT ,"+ COLONNE_PASSWORD + " TEXT );";


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
                valeurs.put(COLONNE_PASSWORD, etudiant.getPassword());
                madb.insert(TABLE_Etudiants,null,valeurs);
                madb.close();

        }

        Etudiant getEtudiant(int id){
        SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor=db.query(TABLE_Etudiants, new String[]{
                    COLONNE_ID,COLONNE_NOM,COLONNE_PRENOM,COLONNE_PASSWORD},COLONNE_ID+"=?",new String[]
                    {String.valueOf(id)},null,null,null );
            return cursorToEtudiant(cursor);

        }
        public  Boolean verif(String nom , String password){

        SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor =db.query(TABLE_Etudiants , new String[]{ COLONNE_ID,COLONNE_NOM,COLONNE_PRENOM,COLONNE_PASSWORD},COLONNE_NOM+"=? AND "+COLONNE_PASSWORD+"=?",new String[]
                    {nom,password},null,null,null );

            if (cursor!=null && cursor.getCount()!=0){
                cursor.moveToFirst();
                return true;

            }else{
                return false;

            }

        }
    private Etudiant cursorToEtudiant(Cursor c) {

      if (c==null || c.getCount() == 0)
            return null;
        c.moveToFirst();
        Etudiant etudiant= new Etudiant();
        etudiant.setId(c.getInt(0));
        etudiant.setNom(c.getString(1));
        etudiant.setPrenom(c.getString(2));

        etudiant.setPassword(c.getString(4));

        return etudiant;

    }

public ArrayList<Etudiant>getAllEtudiants(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c =db.query(TABLE_Etudiants,new String[]{COLONNE_ID,COLONNE_NOM,COLONNE_PRENOM,COLONNE_PASSWORD},null,null,null,null,null);
        return  cursorToEtudiants(c);
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
            etudiant.setPassword(c.getString(3));
            allEtudiants.add(etudiant);
        }while (c.moveToNext());

    c.close();
    return  allEtudiants;
}

    //-----------------------------------------//
}
