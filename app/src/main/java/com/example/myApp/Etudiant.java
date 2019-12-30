package com.example.myApp;

public class Etudiant {

    int id;
    String nom,prenom,password;

    public Etudiant(int id, String nom, String prenom,String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;

    }

    public Etudiant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
