package be.pxl.h6.Opdracht8;

public class FigurenApp {
    public static void main(String[] args) {
       /* Cirkel cirkel = new Cirkel(50, 60, 50.5);
        System.out.println(cirkel.getOmtrek());
        System.out.println(cirkel.getOppervlakte());
        System.out.println("Aantal figuren: " + GrafischElement.getAantal());
        Cirkel cirkel2 = new Cirkel(50, 60, 50.5);
        System.out.println(cirkel.equals(cirkel2));
        System.out.println("Aantal figuren: " + GrafischElement.getAantal());*/
        GrafischElement[] elementen = new GrafischElement[5];
        elementen[0] = new Vierkant(10, 12, 30);
        elementen[1] = new Driehoek(12, 14, 52.6, 45.6, 18.1);
        elementen[2] = new Driehoek((Driehoek) elementen[1]);
        elementen[3] = new Rechthoek(15, 17);
        elementen[4] = new Cirkel(12, 22, 80.6);
        for (GrafischElement elt : elementen) {
            System.out.printf("Oppervlakte: %15.0f Omtrek: %15.0f %s%n", elt.getOppervlakte(), elt.getOmtrek(), elt.getClass().getSimpleName().toUpperCase());
            /*if (elt instanceof Cirkel) {
                System.out.printf("Oppervlakte: %15.0f Omtrek: %15.0f %s%n", elt.getOppervlakte(), elt.getOmtrek(), elt.getClass().getSimpleName(), "CIRKEL");
            } else {
                System.out.printf("Oppervlakte: %15.0f Omtrek: %15.0f %s%n", elt.getOppervlakte(), elt.getOmtrek(), "IETS ANDERS");
            }*/
        }
    }
}
