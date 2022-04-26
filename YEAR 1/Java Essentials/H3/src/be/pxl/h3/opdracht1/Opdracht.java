package be.pxl.h3.opdracht1;

import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
       /* int x;
        double y;
        y = Math.sqrt(2);
        x = (int) Math.sqrt(4); //Of bovenaan de int veranderen in een double!
        System.out.println(y);
        System.out.println(x);*/

        /*int x;
        long y;
        x = (int) Math.pow(2, 3);
        y = Math.round(4.7);
        System.out.println(x); //Of casten naar een int.
        System.out.println(y);*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef een geheel getal: ");
        int getal = scanner.nextInt();
        System.out.println("Het getal tot de derde macht is: " + (int) Math.pow(getal, 3));
    }
}
