package be.pxl.h6.Oefening1;

public class Oefening1App {
    public static void main(String[] args) {
        Werknemer hursit = new Werknemer("Tarcan", "Hursit");
        hursit.print();
        System.out.println();
        Werknemer sinan = new Werknemer("Tarcan", "Sinan");
        Werknemer sinan1 = new Werknemer("Tarcan", "Ferhat");
        sinan.print();
        System.out.println();
        sinan.setFunctie("voetballer");
        sinan.setSalaris(800);
        sinan.print();
        System.out.println();
        System.out.println(Werknemer.getMinimumSalaris());
        System.out.println();
        System.out.println(Werknemer.getAantal());
    }
}
