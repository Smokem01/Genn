package app;

import java.util.ArrayList;

public class Client 
{
    String prenom;
    String nom;
    String MF;
    String adresse;
    double total;
    ArrayList<Record> details;
    
    public Client(String a, String b, String c, String d)
    {
        prenom = a;
        nom = b;
        adresse = c;
        MF = d;
        total = 0;
        details = new ArrayList<Record>();
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMF(String MF) {
        this.MF = MF;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDetails(ArrayList<Record> details) {
        this.details = details;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public double getTotal()
    {
        return this.total;
    }

    public ArrayList<Record> getDetails() {
        return details;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getMF() {
        return MF;
    }

    public String getAdresse() {
        return adresse;
    }
    
    
}
