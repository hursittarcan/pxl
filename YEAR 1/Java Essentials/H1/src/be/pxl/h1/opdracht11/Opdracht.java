//package be.pxl.h1.opdracht11;
//
//public class Opdracht {
//    public static void main(String[] args) {
//        for (int count = 0; count < 101; count ++) {
//            if (count % 10 == 0) {
//                System.out.println(count);
//            }
//        }
//    }
//}

package be.pxl.h1.opdracht11;

import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de grootte van de direhoek: ");
        int grootte = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Geef het start-karakter: ");
        char karakter = scanner.nextLine().charAt(0);
        for (int rij = 1; rij <= grootte; rij++) {
            for (int kolom = 1; kolom <= rij; kolom++) {
                System.out.print(karakter);
                karakter = (char) (karakter + 1);
                if (karakter > 'Z') {
                    karakter = 'A';
                }
            }
            System.out.println();
        }
    }
}