package OefeningAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Opdracht10 {
    public static void main(String[] args) {
        DateTimeFormatter inputFormat =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormat =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dagFormat =
                DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter monthFormat =
                DateTimeFormatter.ofPattern("MMMM");
        System.out.println("Geef een datum in formaat dd/mm/yyyy: ");
        Scanner scanner = new Scanner(System.in);
        String datumAsString = scanner.nextLine();
        LocalDate datum = LocalDate.parse(datumAsString, inputFormat);
        System.out.println(datum.format(outputFormat));
        System.out.println(outputFormat.format(datum));
        System.out.println(dagFormat.format(datum));
        System.out.println(monthFormat.format(datum));
    }
}
