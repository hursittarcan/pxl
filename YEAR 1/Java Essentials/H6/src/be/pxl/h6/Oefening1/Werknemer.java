package be.pxl.h6.Oefening1;

import be.pxl.h6.Opgave1.Persoon;

public class Werknemer extends Persoon {
    public static final int MINIMUM_SALARIS = 1000;
    private static int aantal = 0;
    private String functie;
    private double salaris;

    {
        aantal++;
    }

    public Werknemer(String naam, String voornaam, String functie, double salaris) {
        super(naam, voornaam);
        this.functie = functie;
        setSalaris(salaris);  //Omdat salaris niet kleiner dan MINSAL mag zijn.
    }

    public Werknemer(String naam, String voornaam) {
        super(naam, voornaam);
        setFunctie("algemeen bediende");
        setSalaris(1800);
    }

    public Werknemer() {
    }

    public static int getAantal() {
        return aantal;
    }

    public static void setAantal(int aantal) {
        Werknemer.aantal = aantal;
    }

    public static int getMinimumSalaris() {
        return MINIMUM_SALARIS;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public double getSalaris() {
        return salaris;
    }

    public void setSalaris(double salaris) {
        if (salaris < MINIMUM_SALARIS)
            salaris = MINIMUM_SALARIS;
        this.salaris = salaris;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Functie: " + functie);
        System.out.println("Salaris: " + salaris);
    }
}
