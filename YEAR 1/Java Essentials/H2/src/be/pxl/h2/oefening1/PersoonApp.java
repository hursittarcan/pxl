package be.pxl.h2.oefening1;

public class PersoonApp {
    public static void main(String[] args) {
        Persoon hursit = new Persoon();
        // hursit.voornaam = "Hursit";
        // System.out.println(hursit.voornaam);
        hursit.setVoornaam("Hursit");
        hursit.setNaam("Tarcan");
        hursit.setGewicht(60);
        hursit.setLengte(1.62);
        hursit.setGeboortejaar(1999);
        hursit.voegVoornamenToe("1234");
        String[] voornamen = {"Erik", "Sam", "Rubbe"};
        hursit.voegVoornamenToe(voornamen);
        System.out.println(hursit.berekenBMI());
        System.out.println(hursit.geefOmschrijving());
        System.out.println(hursit.getVoornaam());
        System.out.println(hursit.getLeeftijd());
        System.out.println(hursit.getLengte());
        hursit.groei();
        System.out.println(hursit.getLengte());
        hursit.groei(3);
        System.out.println(hursit.getLengte());
        Persoon sinan = new Persoon(hursit);
        sinan.setVoornaam("Sinan");
        System.out.println(Persoon.getTeller());
    }
}
