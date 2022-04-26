package be.pxl.h3.oefening2;

import java.util.Locale;

public class Persoon {
    private static final double max_lengte = 2.4; //vanboven omdat het niet hetzelfde is als de andere! (final is een constante geen variabele --> python drukletters!
    private static int teller;
    //INSTANTIE VARIABELEN = EIGENSCHAPPEN
    private String voornaam;
    private String achternaam;
    private double lengte;
    private double gewicht;
    private int geboortejaar;
    private double groeiLengte;

    // INITIALISATIEBLOK = AANGEROEPEN SAMEN MET DE CONSTRUCTOR!
    {
        teller++;
    }
    public double berekenBMI() {
        double BMI = gewicht / (lengte * lengte);
        return Math.round(BMI * 10) / 10.0; //resultaat afronden op 1 decimaal
    }

    public static int getTeller() {
        return teller;
    }

    public void voegVoornamenToe(String... voornamen) { //Als ge ... hebt kunt ge later nog meer toevoegen en maakt java achterliggend de array's --> Bij [] gaat dit niet!
        StringBuilder builder = new StringBuilder(this.voornaam);
        for (String voornaam : voornamen) {
            builder.append(" ");
            builder.append(voornaam);
        }
        this.voornaam = builder.toString();
    }

    public Persoon(Persoon anderepersoon) { //Copy constructor
        setVoornaam(anderepersoon.voornaam);
        setAchternaam(anderepersoon.achternaam);
        setGeboortejaar(anderepersoon.geboortejaar);
        setLengte(anderepersoon.lengte);
        setGewicht(anderepersoon.gewicht);
    }

    public Persoon() {
        this("onbekend", "onbekend");
    }

    public Persoon(String naam, String voornaam) {
        setVoornaam(voornaam); //this.voornaam
        setAchternaam(achternaam);
    }

    public double getGroeiLengte() {
        return groeiLengte;
    }

    public void setGroeiLengte(double groeiLengte) {
        this.groeiLengte = groeiLengte;
    }

    public void groei() {
        setLengte(lengte + 0.01);
    }

    public void groei(int groeiLengteCm) {
        double aantalM = groeiLengteCm / 100.0;
        setLengte(lengte + groeiLengte);

    }

    public String geefOmschrijving() {
        String omschrijving = "BMI lager dan 18 --> ondergewicht \n" +
                "BMI vanaf 18 tot 25 --> normaal \n" +
                "BMI vanaf 25 tot 30 --> overgewicht \n" +
                "BMI vanaf 30 tot 40 --> obesitas \n" +
                "BMI vanaf 40 --> morbide obesitas";
        return omschrijving;
    }

    /*Public String geefOmschrijving() {
     * double BMI = (this.)berekenBMI();  --> This. verwijst naar de persoon! Maar omdat er geen andere persoon is is er geen verwarring dus this mag weg!
     * String omschrijving = "";
     * if (BMI < 18) {
     * omschrijving = "ondergewicht"}
     * else if
     * else if
     * .....
     * return omschrijving;*/

    public int getLeeftijd() {
        int leeftijd = 2018 - geboortejaar;
        return leeftijd;
    }

    public String naarString() {
        String gewicht2 = Double.toString(gewicht);
        String lengte2 = Double.toString(lengte);
        String geboortejaar2 = Integer.toString(geboortejaar);
        String totaal = "Deze persoon is " + voornaam + " " + achternaam + System.lineSeparator() + "Gewicht         : " + gewicht2 + System.lineSeparator()
                + "Lengte          : " + lengte2 + System.lineSeparator() + "Geboortejaar    : " + geboortejaar2;
        return totaal;
    }

    /* Sting tekst = String.format("Deze persoon is %s %s%n, voornaam, naam);
    * buisze.append(String.format("%-15s : %.2f%n", "gewicht", gewicht);
    * overal builder.append String.format("%-15s : %.2f%n", "lengte", lengte);
    * tekst += String.format("%-15s : %d%n", "geboortejaar", geboortejaar);
    * return builder.tostring();
    * (OP DEZE MANIER MOET HET GEDAAN WORDEN!)
    * */

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
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

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }
}
