package be.pxl.h1.oefening7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aantal deelnemers: ");
        int aantalDeelnemers = scanner.nextInt();
        String[] lijstDeelnemers = new String[aantalDeelnemers + 1];
        for (int i = 1; i < lijstDeelnemers.length; i++) {
            System.out.println("Naam deelnemer " + i + ": ");
            lijstDeelnemers[i] = scanner.next();
        }
        scanner.close();
    }
}
