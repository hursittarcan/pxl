package be.pxl.h1.oefening3;

public class Oefening3 {
    public static void main(String[] args) {
        System.out.printf("%20s %-20s %20s %20s %n", "1. gewoon", "2. links", "3. rechts (met nul)", "4. rechts met 3 dec");
        double getal = 0;
        for (int i = 1; i <= 9; i++) {
            getal = getal * 10 + i;
            System.out.printf("%20f %-20f %020f %17.3f %n", getal, getal,
                    getal, getal);
        }
        System.out.println();
        getal = 0;
        System.out.printf("%20s %-20s %20s %20s %n", "1. gewoon", "2. links", "3. rechts (met nul)", "4. rechts met 3 dec");
        //uitbreiding
        for (int i = 1; i <= 9; i++) {
            if (i <= 5) {
                getal = getal * 10 + i;
            } else {
                double dec = i;
                for (int j = 6; j <= i; j++) {
                    dec = dec / 10;
                }
                getal = getal + dec;
            }
            System.out.printf("%20f %-20f %020f %17.3f %n", getal, getal,
                    getal, getal);
        }
    }
}