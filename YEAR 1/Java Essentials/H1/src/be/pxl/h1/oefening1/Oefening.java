package be.pxl.h1.oefening1;
import java.util.Scanner;

public class Oefening {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Geef de lengte van het zwembad: ");
        double lengte = keyboard.nextDouble();
        keyboard.nextLine();
        System.out.print("Geef de breedte van het zwembad: ");
        double breedte = keyboard.nextDouble();
        keyboard.nextLine();
        System.out.print("Geef de diepte van het zwembad: ");
        double diepte = keyboard.nextDouble();
        keyboard.close();
        double volumeZwembad = lengte * breedte * diepte;
        double aantalOntsmetting = volumeZwembad % 49;
        double totaalWater = volumeZwembad - aantalOntsmetting;
        System.out.println("Het totaal is: " + (int) volumeZwembad + " Het aantal water: " + (int) totaalWater + " Het aantal ontsmettingsmiddel: " + (int) aantalOntsmetting);
    }
}
