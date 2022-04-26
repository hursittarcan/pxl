package OefeningAPI;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Opdracht8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate verjaardag = LocalDate.of(1980, Month.APRIL, 24); // je kan ook gwn cijfer van de maand zetten.
        System.out.println("Dag van het jaar: " + verjaardag.getDayOfYear());
        System.out.println("Dag: " + verjaardag.getDayOfWeek());
        System.out.println("SChrikkeljaar: " + verjaardag.isLeapYear());

        LocalDate vandaag = LocalDate.now();
        Period period = Period.between(verjaardag, LocalDate.now());
        System.out.println("Jaren: " + period.getYears());
        System.out.println("Maanden: " + period.getMonths());
        System.out.println("Dagen: " + period.getDays());

        long aantalDagen = ChronoUnit.DAYS.between(verjaardag, vandaag);
        long aantalMaanden = ChronoUnit.MONTHS.between(verjaardag, vandaag);
        long aantalJaren = ChronoUnit.YEARS.between(verjaardag, vandaag);
        System.out.println("Aantal dagen: " + aantalDagen);
        System.out.println("Aantal maanden: " + aantalMaanden);
        System.out.println("Aantal jaren: " + aantalJaren);
    }
}

//Slide 41 + 42 niet kennen!