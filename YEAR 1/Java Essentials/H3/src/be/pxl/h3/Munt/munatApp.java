package be.pxl.h3.Munt;

public class munatApp {
    public static void main(String[] args) {
        munt[] munts = new munt[3];
        munts[0] = new munt();
        munts[1] = new munt("USD", 0.8822);
        munts[2] = new munt("EUR", 1.1050);

        System.out.print("Overzicht koersen tov " + munts[0].getNaam() + ":");
        System.out.println(" " + munts[0].getKoers() + " " + munts[0].getNaam());

        for (int i = 1; i < munts.length; i++) {
            System.out.printf("%.3f %s%n", munts[i].getKoers(), munts[i].getNaam());
        }

        System.out.println("Aantal munten: " + munt.getAantal());
    }
}
