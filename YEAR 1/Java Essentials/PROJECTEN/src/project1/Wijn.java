package project1;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Wijn {
    private static final int STANDAARDWAARDE_JAARGANG = LocalDate.now().getYear() - 1; //LocalDate nooit van boven als een static --> Static verandert nooit!
    private static final double STANDAARDWAARDE_ALCOHOLPERCENTAGE = 12.5;
    private static final String STANDAARDWAARDE_KLEUR = "Rood";
    private static final String STANDAARDWAARDE_LAND = "Onbekend";
    private static final int MAXIMUM_JAARGANG = LocalDate.now().getYear();
    private static final int MINIMUM_JAARGANG = 1950;
    private static final double MAX_ALCOHOL_PERCENTAGE = 17;
    private static final double MIN_ALCOHOL_PERCENTAGE = 0;
    private static final double EXTRA_PER_JAARGANG = 0.10;
    private static final int LAATSTE_CIJFER_JAARGANG = 7;

    private static ArrayList<String> landen = new ArrayList<>(Arrays.asList("Frankrijk", "Chili", "Italie", "Spanje"));
    private static ArrayList<String> kleuren = new ArrayList<>(Arrays.asList("Wit", "Rood", "Rose"));
    private static ArrayList<Double> prijzen = new ArrayList<>(Arrays.asList(7.5, 8.25, 9.30, 6.45));

    private String naam;
    private String omschrijving;
    private String druivenras;
    private String kleur;
    private String land;
    private String regio;
    private int jaargang;
    private double alcoholpercentage;
    private String serveertip;

    public Wijn(String naam, String kleur, String land) {
        this(naam, land, kleur, STANDAARDWAARDE_JAARGANG, STANDAARDWAARDE_ALCOHOLPERCENTAGE);
    }

    public Wijn(String naam, String land, String kleur, int jaargang, double alcoholpercentage) {
        setNaam(naam);
        setLand(land);
        setKleur(kleur);
        setJaargang(jaargang);
        setAlcoholpercentage(alcoholpercentage);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getDruivenras() {
        return druivenras;
    }

    public void setDruivenras(String druivenras) {
        this.druivenras = druivenras;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if (kleuren.contains(kleur)) {
            this.kleur = kleur;
        }
        else {
            this.kleur = STANDAARDWAARDE_KLEUR;
        }
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        if (landen.contains(land)) {
            this.land = land;
        }
        else {
            this.land = STANDAARDWAARDE_LAND;
        }
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
    }

    public int getJaargang() {
        return jaargang;
    }

    public void setJaargang(int jaargang) {
        if (jaargang < MINIMUM_JAARGANG) {
            jaargang = MINIMUM_JAARGANG;
        }
        if (jaargang > MAXIMUM_JAARGANG) {
            jaargang = MAXIMUM_JAARGANG;
        }
        this.jaargang = jaargang;
    }

    public double getAlcoholpercentage() {
        return alcoholpercentage;
    }

    public void setAlcoholpercentage(double alcoholpercentage) {
        if (alcoholpercentage < MIN_ALCOHOL_PERCENTAGE) {
            alcoholpercentage = MIN_ALCOHOL_PERCENTAGE;
        }
        if (alcoholpercentage > MAX_ALCOHOL_PERCENTAGE) {
            alcoholpercentage = MAX_ALCOHOL_PERCENTAGE;
        }
        this.alcoholpercentage = alcoholpercentage;
    }

    public String getServeertip() {
        return serveertip;
    }

    public void setServeertip(String serveertip) {
        this.serveertip = serveertip;
    }

    public static int getStandaardwaardeJaargang() {
        return STANDAARDWAARDE_JAARGANG;
    }

    public static double getStandaardwaardeAlcoholpercentage() {
        return STANDAARDWAARDE_ALCOHOLPERCENTAGE;
    }

    public static int getMinimumJaargang() {
        return MINIMUM_JAARGANG;
    }

    public static double getMaxAlcoholPercentage() {
        return MAX_ALCOHOL_PERCENTAGE;
    }

    public static double getMinAlcoholPercentage() {
        return MIN_ALCOHOL_PERCENTAGE;
    }

    public static ArrayList<String> getLanden() {
        return landen;
    }

    public static String getStandaardwaardeKleur() {
        return STANDAARDWAARDE_KLEUR;
    }

    public static String getStandaardwaardeLand() {
        return STANDAARDWAARDE_LAND;
    }

    public static ArrayList<Double> getPrijzen() {
        return prijzen;
    }

    public static ArrayList<String> getKleuren() {
        return kleuren;
    }

    public double getAdviesprijs() {
        double adviesprijs;
        int positie = landen.indexOf(land);
        if (positie == -1) {
            adviesprijs = Collections.max(prijzen);
        }
        else {
            adviesprijs = prijzen.get(positie);
        }
        int jaarOuderdom = LocalDate.now().getYear() - jaargang;
        double adviesprijs2 = adviesprijs + (jaarOuderdom * EXTRA_PER_JAARGANG);

        if ((jaargang % 10) == LAATSTE_CIJFER_JAARGANG) {
            adviesprijs2 = adviesprijs;
        }
        return adviesprijs2;
    }

    public String getLabel() {
        String label = naam + ", " + druivenras + ", " + regio + ", " + jaargang;
        return label;
    }

    @Override
    public String toString() {
        String tekst = "naam: " + naam + " Omschrijving: " + omschrijving +
                " Druivenras: " + druivenras + " Kleur: " + kleur + " Land: " +
                land + " Regio: " + regio + " Jaargang: " + jaargang + " Alcoholpercentage: " +
                alcoholpercentage + " Serveertip: " + serveertip + " Prijs: " + getAdviesprijs();
        return tekst;
    }
}
