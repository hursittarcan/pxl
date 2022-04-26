package be.pxl.h3.oefening2;

public class PersoonApp {
    public static void main(String[] args) {
        Persoon persoon = new Persoon();
        persoon.setAchternaam("Tarcan");
        persoon.setVoornaam("Hursit");
        persoon.setLengte(1.62);
        persoon.setGewicht(60);
        persoon.setGeboortejaar(1999);
        System.out.println(persoon.naarString());
        System.out.println();
        System.out.println("BMI: " + persoon.berekenBMI());
        System.out.println();
        System.out.println(persoon.geefOmschrijving());
        System.out.println();
        // Vraag 4 niet kunnen doen!
        String[] voornamen = {"Erik", "Sam", "Rubbe"};
        persoon.voegVoornamenToe(voornamen);
        System.out.println(persoon.naarString());
        System.out.println();
        System.out.println("Leeftijd: " + persoon.getLeeftijd());
        System.out.println();
        persoon.groei();
        System.out.println("Methode groei zonder parameters: " + persoon.getLengte());
        persoon.groei(5);
        System.out.println("Methode groei met parameter: " + persoon.getLengte());
        // Vraag 8 niet kunnen doen!
        // Vraag 9 niet kunnen doen!
        System.out.println();

        Persoon tweelingsbroer = new Persoon(persoon);
        tweelingsbroer.setVoornaam("Gert");
        System.out.println(tweelingsbroer);
        System.out.println(persoon.berekenBMI());
        System.out.println(persoon.geefOmschrijving());

    }
}


