package be.pxl.h5.oefening1;

public class Adres {
    private String straat;
    private String huisNummer;
    private Gemeente gemeente;

    public Adres(String straat, String huisNummer, Gemeente gemeente) {
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.gemeente = gemeente;
    }

    public Adres(String straat, String huisNummer, int postcode, String gemeente) {
        this(straat, huisNummer, new Gemeente(postcode, gemeente));
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisNummer() {
        return huisNummer;
    }

    public void setHuisNummer(String huisNummer) {
        this.huisNummer = huisNummer;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }

    @Override
    public String toString() {
        return straat + " " + huisNummer + System.lineSeparator() + gemeente;
    }
}
