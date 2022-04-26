package be.pxl.h2.opdracht10;

public class Klas {
    private static final int MAXIMUMAANTALSTUDENTEN = 40; //Moet in hoofdletters - Als dit gewijzigd wordt wordt dit ook geweizigd in de klasse getAantalStudenten!
    private static int teller = 0;
    private static int totaalAantalStudenten = 0;
    private String naamKlas;
    private int aantalStudenten;

    public Klas() {
        this("1TINx", 0);
    }

    public Klas(String naamKlas, int aantalStudenten) {
        teller ++;
        this.naamKlas = naamKlas;
        setAantalStudenten(aantalStudenten);
    }

    public static int getTeller() {
        return teller;
    }

    public static int getTotaalAantalStudenten() {
        return totaalAantalStudenten;
    }

    public static int getmaxLeerlingen() {
        return MAXIMUMAANTALSTUDENTEN;
    }

    public String getNaamKlas() {
        return naamKlas;
    }

    public static double getGemiddeldAantalStudentenPerKlas() {
        if(teller == 0) {
            return 0;
        }
        return (double) totaalAantalStudenten / teller;
    }

    public void setNaamKlas(String naamKlas) {
        this.naamKlas = naamKlas;
    }

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public void setAantalStudenten(int aantalStudenten) {
        if (aantalStudenten > MAXIMUMAANTALSTUDENTEN) {
            aantalStudenten = MAXIMUMAANTALSTUDENTEN;
        }
        totaalAantalStudenten += aantalStudenten;
        totaalAantalStudenten -= this.aantalStudenten;
        this.aantalStudenten = aantalStudenten;
    }

    public void voegStudentToe() {
        setAantalStudenten(this.aantalStudenten + 1);
    }
}
