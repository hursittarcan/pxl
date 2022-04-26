package be.pxl.h2.oefening1;

public class Persoon {
    private static final double max_lengte = 2.4;
    private static int teller;
    //INSTANTIE VARIABELEN = EIGENSCHAPPEN
    private String voornaam;
    private String naam;
    private double lengte;
    private double gewicht;
    private int geboortejaar;

    // INITIALISATIEBLOK = AANGEROEPEN SAMEN MET DE CONSTRUCTOR!
    {
        teller++;
    }
    public Persoon(String voornaam, String naam) {
        this.voornaam = voornaam;
        this.naam = naam;
    }

    public Persoon() { this("onbekend", "onbekend");}

    public Persoon(Persoon anderepersoon) { //Copy constructor
        setVoornaam(anderepersoon.voornaam);
        setNaam(anderepersoon.naam);
        setGeboortejaar(anderepersoon.geboortejaar);
        setLengte(anderepersoon.lengte);
        setGewicht(anderepersoon.gewicht);
    }

    public double berekenBMI() {
        double BMI = gewicht/(lengte * lengte);
        return BMI;
    }

    public void voegVoornamenToe(String... voornamen) { //Als ge ... hebt kunt ge later nog meer toevoegen en maakt java achterliggend de array's --> Bij [] gaat dit niet!
        for (String voornaam : voornamen) {
            this.voornaam += " " + voornaam;
        }
    }

    public String geefOmschrijving() {
        double BMI = this.berekenBMI();
        String omschrijving = "";
        if (BMI < 18) {
            omschrijving = "Ondergewicht";
        }
        else if (BMI < 25){
            omschrijving = "Normaal";
        }
        else if (BMI < 30){
            omschrijving = "Ondergewicht";
        }
        else if (BMI < 40) {
            omschrijving = "Obestitas";
        }
        else {
            omschrijving = "Morbide obesitas";
        }
        return omschrijving;
    }

    public void groei() {
        setLengte(lengte + 0.01);
    }

    public void groei(int groeiLengte) {
        double groeiInM = groeiLengte / 100.0;
        setLengte(lengte + groeiInM);

    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        if (lengte > 2.40) {
            lengte = 2.40;
        }
        this.lengte = lengte;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public int getLeeftijd() {
        int leeftijd = 2019 - geboortejaar;
        return leeftijd;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }

    public static int getTeller() {
        return teller;
    }

    @Override
    public String toString() {
        String tekst = String.format("Deze persoon is %s %s%n", voornaam, naam);
        tekst += String.format("%-15s : %.2f%n", "gewicht", gewicht);
        tekst += String.format("%-15s : %.2f%n", "lengte", lengte);
        tekst += String.format("%-15s : %d%n", "geboortejaar", geboortejaar);
        return tekst;
    }
}
