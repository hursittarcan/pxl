package OefeningAPI;

import java.util.Scanner;

public class Oefening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef een waarde: ");
        String waarde = scanner.nextLine();
        Integer intWaarde = Integer.valueOf(waarde);
        intWaarde += 120;
        System.out.println(intWaarde);
        System.out.println("Bits: " + Integer.SIZE);
        System.out.println("Bytes: " + Integer.BYTES);
        scanner.close();
    }
}
