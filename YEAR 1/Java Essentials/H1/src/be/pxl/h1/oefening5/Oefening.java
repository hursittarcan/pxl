package be.pxl.h1.oefening5;

import java.util.Scanner;

public class Oefening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aantal volwassenen: ");
        int aantalVolwassenen = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Aantal kinderen: ");
        int aantalKinderen = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Hotelcode: ");
        String hotelCode = scanner.nextLine();

        while (!"/".equals(hotelCode)) {
            System.out.print("Aantal sterren: ");
            int aantalSterren = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Kindercode: ");
            char kinderCode = scanner.nextLine().charAt(0);
            while (kinderCode < 'A' || kinderCode > 'Z') {
                System.out.print("Kindercode tussen A en Z a.u.b: ");
                System.out.println("Kindercode opnieuw: ");
                kinderCode = scanner.nextLine().charAt(0);
            }
            int prijsPerNacht;
            int prijsVoorKind;
            if (aantalSterren < 3) {
                prijsPerNacht = 48;
                prijsVoorKind = 24;
                if (kinderCode == 'A') {
                    prijsVoorKind = 0;
                }
            } else if (aantalSterren < 4) {
                if (hotelCode.equals("BR") || hotelCode.equals("AN")) {
                    prijsPerNacht = 60;
                    prijsVoorKind = 30;
                }
                else {
                    prijsPerNacht = 56;
                    prijsVoorKind = 28;
                }
            }
            else {
                prijsPerNacht = 60;
                prijsVoorKind = 30;
            }
            if (hotelCode.equals("HI")) {
                prijsPerNacht = 70;
                prijsVoorKind = 35;
            }
            if (hotelCode.equals("HA")) {
                prijsVoorKind = 0;
            }
            String ster = ("*").repeat(aantalSterren);
            System.out.println(hotelCode + " " + ster + " " + prijsPerNacht + prijsVoorKind);
            System.out.println();
            System.out.print("Aantal volwassenen: ");
            aantalVolwassenen = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Aantal kinderen: ");
            aantalKinderen = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Hotelcode: ");
            hotelCode = scanner.nextLine();
        }
    }
}
