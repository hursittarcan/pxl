package OefeningAPI;

import java.sql.Time;
import java.time.Instant;
import java.util.Scanner;

public class Opdracht6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Instant start = Instant.now(); //Als je scanner wilt meerekenen zet je het onder instant.
        System.out.println("Geef je naam: ");
        String naam = scanner.nextLine();
        Instant stop = Instant.now();
        System.out.println(stop.getEpochSecond() - start.getEpochSecond());
    }
}