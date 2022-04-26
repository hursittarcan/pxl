package be.pxl.h1.opdracht6;
import java.util.Scanner;

public class Begroeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //input kan ook een andere naam hebben!!
        System.out.println("Geef je voornaam: ");
        String naam = input.next();
        System.out.println("Geef je achternaam: ");
        String achternaam = input.next();
        String volledigenaam = naam + " " + achternaam;
        System.out.println("Hallo," + " " + volledigenaam);
        input.close();
    }
}


