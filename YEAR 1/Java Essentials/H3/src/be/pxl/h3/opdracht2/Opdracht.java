package be.pxl.h3.opdracht2;

import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de oppervlakte: ");
        double oppervlakte = scanner.nextDouble();
        System.out.printf("De diameter is: %.2f", Math.sqrt(oppervlakte / Math.PI) * 2);
    }
}
