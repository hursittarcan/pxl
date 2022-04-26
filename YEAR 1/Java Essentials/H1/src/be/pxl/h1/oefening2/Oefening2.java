package be.pxl.h1.oefening2;
import java.util.Scanner;

public class Oefening2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Naam speler: ");
        String naamSpeler = scanner.nextLine();
        System.out.print("Prijs vorig seizoen: ");
        double prijsSpeler = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Leeftijd: ");
        int leeftijd = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Gemiddeld beoordelingscijfer: ");
        int beoordelingscijfer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type speler: ");
        String typeSpeler = scanner.next();
        scanner.nextLine();
        System.out.print("Aantal doelpunten: ");
        int doelpunten = scanner.nextInt();
        scanner.close();
        double prijsSpeler2 = prijsSpeler;
        if (leeftijd < 25) {
            prijsSpeler2 += prijsSpeler / 100 * 10;
        }
        else if (leeftijd > 30) {
            prijsSpeler2 += prijsSpeler / 100 * (-10);
        }
        if (typeSpeler.equals("Aanvaller")) {
            if (doelpunten < 6) {
                prijsSpeler2 += doelpunten * 10000;
            }
            else {
                prijsSpeler2 += doelpunten * 20000 - 50000;
            }
        }
        else {
            prijsSpeler2 += 10000 * beoordelingscijfer;
        }
        if (typeSpeler.equals("Doelman")) {
            if (doelpunten > 19) {
                prijsSpeler2 -= 9000;
            }
        }
        System.out.print("Naam speler: ");
        System.out.print(naamSpeler);
        System.out.println();
        System.out.print("Prijs vorig seizoen: ");
        System.out.println(prijsSpeler);
        System.out.print("Nieuwe prijs: ");
        System.out.println(prijsSpeler2);
    }
}
