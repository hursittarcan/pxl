package be.pxl.h1.opdracht10;
import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int aantalMensen = 0;
        int snelsteRenner = 0;
        int tijdSnelsteRenner = 9999999;
        int mensenLangerDanEenUur = 0;
        System.out.println("Geef u inschrijvingsnummer: ");
        int inschrijvingsnummer = keyboard.nextInt();
        keyboard.nextLine();
        while (inschrijvingsnummer > -1) {
            aantalMensen ++;
            System.out.println("Geef u tijd in seconden: ");
            int tijd = keyboard.nextInt();
            if (tijd < tijdSnelsteRenner){
                tijdSnelsteRenner = tijd;
                snelsteRenner = inschrijvingsnummer;
            }
            if (tijd > 3600) {
                mensenLangerDanEenUur ++;
            }
            System.out.println("Geef u inschrijvingsnummer: ");
            inschrijvingsnummer = keyboard.nextInt();
            keyboard.nextLine();
        }
        double procentLangerDanEenUur = ((double)mensenLangerDanEenUur / aantalMensen) * 100;

        System.out.println("De snelste renner is: " + snelsteRenner + " , zijn tijd in seconden is: " + tijdSnelsteRenner);
        System.out.println("Procent van het aantal renners die er langer dan 1 uur over deden: " + procentLangerDanEenUur);
        keyboard.close();
    }
}
