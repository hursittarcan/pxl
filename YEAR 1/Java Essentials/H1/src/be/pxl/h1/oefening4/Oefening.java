package be.pxl.h1.oefening4;

import java.util.Scanner;

public class Oefening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("U vertegenwoordigernummer: ");
        String vertegenwoordigernummer = scanner.next();
        String eersteNummer = vertegenwoordigernummer.substring(0,1);
        int vastGedeelte = 25000;
        int loon;
        double meerDan75000 = 0.0;
        double totaal = 0.0;

        while (!"9".equals(eersteNummer)) {
            totaal ++;
            System.out.print("Verkochte bedrag van vorig jaar: ");
            int verkochtBedrag = scanner.nextInt();
            if (verkochtBedrag < 50000) {
                loon = vastGedeelte + (verkochtBedrag / 100 * 5);
            }
            else if (verkochtBedrag < 75001) {
                loon = vastGedeelte  + (verkochtBedrag / 100 * 10);
            }
            else {
                loon = vastGedeelte + (verkochtBedrag / 100 * 15);
                meerDan75000 ++;
            }
            System.out.println();
            System.out.println("Vertegenwoordigersnummer: " + vertegenwoordigernummer);
            System.out.println("Het verkochte bedrag is: " + verkochtBedrag);
            System.out.println("Loon is: " + loon);
            System.out.println();
            System.out.print("U vertegenwoordigernummer: ");
            vertegenwoordigernummer = scanner.next();
            eersteNummer = vertegenwoordigernummer.substring(0,1);
        }
        System.out.println();
        System.out.println("Percentage meer dan 75000: " + ((meerDan75000 / totaal) * 100));
        scanner.close();
    }
}
