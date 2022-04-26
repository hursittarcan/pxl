package be.pxl.h6.Oefening2;

public class Reis {
    public static final int MIN_PRIJS = 5;
    private String bestemming;
    private double prijs;

    public Reis(String bestemming, double prijs) {
        setBestemming(bestemming);
        this.prijs = prijs;
    }

    public Reis(String bestemming) {
        this(bestemming, MIN_PRIJS);
    }

    public Reis() {

    }

    public String getBestemming() {
        return bestemming;
    }

    public void setBestemming(String bestemming) {
        char eerste_letter = bestemming.charAt(0);
        String cijfers = "0123456789";
        if (cijfers.indexOf(eerste_letter) > 0) {
            bestemming = bestemming.substring(1);
        }
        this.bestemming = bestemming;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        prijs *= 100;
        prijs = Math.round(prijs);
        prijs /= 100;
        this.prijs = prijs;
    }

    public static int getMinPrijs() {
        return MIN_PRIJS;
    }

    public void print() {
        System.out.println("Reis met bestemming " + bestemming + " " + "kost " + prijs + " euro.") ;
    }

}
