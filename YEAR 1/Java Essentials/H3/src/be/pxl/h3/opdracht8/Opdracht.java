package be.pxl.h3.opdracht8;

import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Geef de artikelcode: ");
//        String artikelCode = scanner.nextLine();
//        if (artikelCode.substring(0, 1) == (String)String());

        String artikelCode = "rT89";
        boolean isGeldig = Character.isLetter(artikelCode.charAt(0)) &&
                Character.isLetter(artikelCode.charAt(1)) &&
                Character.isLetter(artikelCode.charAt(2)) &&
                Character.isLetter(artikelCode.charAt(3));
        if (!isGeldig) {
            System.out.println("De code is niet geldig!");
        } else {
//            artikelCode = Character.toUpperCase(artikelCode.charAt(0)) +
//                    artikelCode.substring(1);
//            System.out.println(artikelCode);
                StringBuilder builder = new StringBuilder();
        builder.append(Character.toUpperCase(artikelCode.charAt(0)));
        builder.append(artikelCode.substring(1));
        artikelCode = builder.toString();
            System.out.println(artikelCode);
        }

    }
}
