package be.pxl.h5.oefening1;

public class Datum {
    private static final String MAANDNAMEN [] = {"Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December"};
    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) {
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    public Datum() {
        dag = 1;
        maand = 1;
        jaar = 2018;
    }

    public static String[] getMAANDNAMEN() {
        return MAANDNAMEN;
    }

    public int getDag() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }

    public int getMaand() {
        return maand;
    }

    public void setMaand(int maand) {
        this.maand = maand;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    @Override
    public String toString() {
        return dag + " " + maand + " " + jaar;
    }
}
