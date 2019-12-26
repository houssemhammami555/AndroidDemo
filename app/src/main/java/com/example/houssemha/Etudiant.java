package com.example.houssemha;

public class Etudiant {

    int id;
    String nom,prenom,password, phoneNumber;

    public Etudiant(int id, String nom, String prenom, String phoneNumber, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
