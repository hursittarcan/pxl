package be.pxl.h6.Opgave1;

public class Persoon {
    private String naam;
    private String voornaam;
    private static int aantal = 0;

    // INITIALISATIE-BLOCK
    {
        aantal++;
    }

    public Persoon() {                       /*Deze moet er zeker staan anders probleem bij Klasse Student*/
    }

    public Persoon(String naam, String voornaam) {
        this.naam = naam;
        this.voornaam = voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void print() {
        System.out.println("Naam: " + voornaam + ", Achternaam: " + naam);
    }

    public static int getAantal() {
        return aantal;
    }
}
