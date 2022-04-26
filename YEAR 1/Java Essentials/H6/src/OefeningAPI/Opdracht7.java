package OefeningAPI;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Opdracht7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef dag van de week: ");
        int dagNummer = scanner.nextInt();
        System.out.println("Geef een aantal dagen: ");
        int aantalDagen = scanner.nextInt();
        DayOfWeek dag = DayOfWeek.of(dagNummer);
        DayOfWeek later = dag.plus(aantalDagen);
        System.out.println(later);
        System.out.println(later.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()));
        scanner.close();
    }
}
