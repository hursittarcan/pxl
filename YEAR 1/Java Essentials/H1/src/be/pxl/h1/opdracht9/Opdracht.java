package be.pxl.h1.opdracht9;

import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        double basisbedrag = 100.0;
        Scanner piep = new Scanner(System.in);
        System.out.println("Give me your age mofo: ");
        int age = piep.nextInt();
        piep.nextLine();
        System.out.println("Give me the aansluitongsjaar: ");
        int aansluitingsjaar = piep.nextInt();
        int jarenaangesloten = 2019 - aansluitingsjaar;
        if (age < 21 || age > 60) {
            basisbedrag -= 14.5;
        }
        basisbedrag = basisbedrag - (2.5 * jarenaangesloten);
        if (basisbedrag < 62.5) {
            basisbedrag = 62.5;
        }
        System.out.println("Het bedrag dat u moet betalen is " + basisbedrag + " Euro.");
        piep.close();
    }
}


