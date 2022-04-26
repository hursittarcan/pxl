package Project0;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Wijn {
    private static final double ALCOHOL_STANDAARDWAARDE = 12.5;
    private static final int MIN_JAARGANG = 1950;
    private static final double MIN_ALCOHOLPERCENTAGE = 0;
    private static final double MAX_ALCOHOLPERCENTAGE = 17;
    private String naam;
    private String omschrijving;
    private String druivenras;
    private String kleur;
    private String land;
    private String regio;
    private int jaargang;
    private double alcoholpercentage;
    private String serveertip;

    private static ArrayList<String> landen = new ArrayList<>(Arrays.asList("Frankrijk", "Chili", "Italie", "Spanje"));
    private static ArrayList<Double> prijzen = new ArrayList<>(Arrays.asList(7.5, 8.25, 9.30, 6.45));
    private static ArrayList<String> kleuren = new ArrayList<>(Arrays.asList("Wit", "Rood", "Rose"));

    public Wijn(String naam, String kleur, String land, int jaargang, double alcoholpercentage) {
        this.naam = naam;
        this.kleur = kleur;
        this.land = land;
        this.jaargang = jaargang;
        this.alcoholpercentage = alcoholpercentage;
    }

    public Wijn(String naam, String kleur, String land) {
        this(naam, kleur, land, LocalDate.now().getYear() - 1, ALCOHOL_STANDAARDWAARDE);
    }

    public static double getAlcoholStandaardwaarde() {
        return ALCOHOL_STANDAARDWAARDE;
    }

    public static int getMinJaargang() {
        return MIN_JAARGANG;
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
        this.kleur = kleur;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        if (landen.contains(land)) {
            this.land = land;
        }
        else {
            this.land = "Onbekend";
        }
        this.land = land;
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
        if (jaargang < MIN_JAARGANG) {
            jaargang = MIN_JAARGANG;
        }
        if (jaargang > LocalDate.now().getYear()) {
            jaargang = LocalDate.now().getYear();
        }
        this.jaargang = jaargang;
    }

    public double getAlcoholpercentage() {
        return alcoholpercentage;
    }

    public void setAlcoholpercentage(double alcoholpercentage) {
        if (alcoholpercentage < MIN_ALCOHOLPERCENTAGE) {
            alcoholpercentage = MIN_ALCOHOLPERCENTAGE;
        }
        if (alcoholpercentage > MAX_ALCOHOLPERCENTAGE) {
            alcoholpercentage = MAX_ALCOHOLPERCENTAGE;
        }
        this.alcoholpercentage = alcoholpercentage;
    }

    public String getServeertip() {
        return serveertip;
    }

    public void setServeertip(String serveertip) {
        this.serveertip = serveertip;
    }

    public static ArrayList<String> getLanden() {
        return landen;
    }

    public static void setLanden(ArrayList<String> landen) {
        Wijn.landen = landen;
    }

}
