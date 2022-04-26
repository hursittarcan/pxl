package be.pxl.h3.Munt;

public class munt {
    private static final int AFRONDING = 3;
    private static int aantal;
    private String naam;
    private double koers;

    public munt() {
        this("euro", 1);
    }

    public munt(String naam, double koers) {
        setNaam(naam);
        setKoers(koers);
        aantal++;
    }

    public static int getAantal() {
        return aantal;
    }

    public static void setAantal(int aantal) {
        munt.aantal = aantal;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getKoers() {
        return koers;
    }

    public void setKoers(double koers) {
        double afronder = Math.pow(10, AFRONDING);
        this.koers = Math.round(koers * afronder) / afronder;
    }


}
