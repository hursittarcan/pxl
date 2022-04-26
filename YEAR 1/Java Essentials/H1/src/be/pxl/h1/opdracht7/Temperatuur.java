package be.pxl.h1.opdracht7;
import java.util.Scanner;

public class Temperatuur {
    public static void main(String[] args) {
        Scanner hursit = new Scanner(System.in);
        System.out.println("Geef de temperatuur in Celsius: ");
        double gradenC = hursit.nextDouble();
        double fahrenheit = (9 / 5.0) * gradenC + 32;
        fahrenheit = Math.round(fahrenheit * 10) / 10.0;
        System.out.println("De temperatuur in F is: " + " " + fahrenheit);
    }
}

