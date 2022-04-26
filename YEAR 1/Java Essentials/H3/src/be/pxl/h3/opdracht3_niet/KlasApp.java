package be.pxl.h3.opdracht3_niet;
//import static be.pxl.h2.opdracht10.Klas.*; //Moet niet mag!

public class KlasApp {
    public static void main(String[] args) {
        Klas klas1 = new Klas();
        klas1.setAantalStudenten(30);
        System.out.println(klas1.getAantalStudenten());
        Klas klas2 = new Klas();
        Klas klas3 = new Klas("1TINH", 45);
        System.out.println(klas3.getAantalStudenten());
        System.out.println("Aantal klassen: " + Klas.getTeller());
        Klas[] klassen = new Klas[3];
        klassen[0] = klas1;
        // klassen[1] = klas2;
        klassen[2] = klas3;
        for(Klas klas : klassen) {
            if(klas != null) {
                System.out.println(klas.getNaamKlas() + " " + klas.getAantalStudenten());
            }
        }
        System.out.println("Totaal aantal studenten: " + Klas.getTotaalAantalStudenten());
        System.out.println("Gem. aantal studenten per klas: " + Klas.getGemiddeldAantalStudentenPerKlas());
        klas1.voegStudentToe();
        System.out.println("Klas 1: " + klas1.getAantalStudenten());
    }
}
