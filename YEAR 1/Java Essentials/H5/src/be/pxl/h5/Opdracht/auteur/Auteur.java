package be.pxl.h5.Opdracht.auteur;

public class Auteur {
    // EIGENSCHAPPEN (ENCAPSULATION!)
    private String naam;
    private String achternaam;


    // CONSTRUCTORS (GENEREREN)
    public Auteur(String naam, String achternaam) {
        this.naam = naam;
        this.achternaam = achternaam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getAchternaam() {
        return achternaam;
    }
    // toString

    @Override
    public String toString() {
        return "Auteur: " + naam + " " + achternaam;
    }
}
