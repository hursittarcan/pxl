package be.pxl.h3.opdracht4;

import java.util.Random;

public class Opdracht {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Het eerste getal: " + rand.nextInt());
        System.out.println();
        System.out.println("De volgende getallen zijn: ");
        for (int x = 0; x < 20; x++) {
            System.out.print(rand.nextInt(11) + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("De getallen tussen 20 en 30: ");
        for (int x = 0; x < 10; x++) {
            System.out.print(rand.nextInt(11) + 20 + " ");
        }
        System.out.println();
        System.out.println("De kleine letter: ");
        char willekeurigeLetter = (char) (rand.nextInt(26) + 97);
        System.out.println(willekeurigeLetter);
    }
}
