package be.pxl.h9.Opgave1;

import java.util.ArrayList;

public class Opdracht {
    public static void main(String[] args) {
        ArrayList<Schaalbaar> schaalbareObjecten = new ArrayList<>();
        schaalbareObjecten.add(new Cirkel(120, 100, 150));
        schaalbareObjecten.add(new Rechthoek(150, 250));
        schaalbareObjecten.add(new Driehoek(40, 50, 80, 120, 70));
        schaalbareObjecten.add(new Vierkant(70, 60, 80));

        for (Schaalbaar elt : schaalbareObjecten) {
            System.out.println(elt.getClass().getSimpleName());
            System.out.println(((GrafischElement) elt).getOppervlakte());
            elt.herschaal(Schaalbaar.DUBBEL);
            System.out.println(((GrafischElement) elt).getOppervlakte());
            System.out.println();
        }
    }
}
