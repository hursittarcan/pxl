//package be.pxl.h1.oefening6;
//
//import java.util.Scanner;
//
//public class Opdracht {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String band1 = "zbrogGBVLW";
//        System.out.print("Geef karakter 1: ");
//        String karakter1 = scanner.nextLine();
//        while (!band1.contains(karakter1)) {
//            System.out.print("Karakter niet gevonden, opnieuw ingeven: ");
//            karakter1 = scanner.nextLine();
//        }
//        System.out.print("Geef karakter 2: ");
//        String karakter2 = scanner.nextLine();
//        while (!band1.contains(karakter2)) {
//            System.out.print("Karakter niet gevonden, opnieuw ingeven: ");
//            karakter2 = scanner.nextLine();
//        }
//        System.out.print("Geef karakter 3: ");
//        String karakter3 = scanner.nextLine();
//        while (!band1.contains(karakter3)) {
//            System.out.print("Karakter niet gevonden, opnieuw ingeven: ");
//            karakter3 = scanner.nextLine();
//        }
//        double weerstand = (10 * band1.indexOf(karakter1) + band1.indexOf(karakter2)) * Math.pow(10, band1.indexOf(karakter3));
//        System.out.println("De weerstand is: " + weerstand);
//    }
//}
//
//public class Oefening6 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        char[] karakters = {'z', 'b', 'r', 'o', 'g', 'G', 'B', 'V', 'L',
//                'W'};
//        char[] code = new char[3];
//        int[] value = {-1, -1, -1};
//        System.out.println("Geef de eerte kleurcode");
//        code[0] = scanner.next().charAt(0);
//        System.out.println("Geef de tweede kleurcode");
//        code[1] = scanner.next().charAt(0);
//        System.out.println("Geef de derde kleurcode");
//        code[2] = scanner.next().charAt(0);
// /*for (int i = 0; i < karakters.length; i++) {
// for (int j = 0; j < code.length; j++) {
// if (value[j] == -1 && code[j] == karakters[i]) {
// value[j] = i;
// }
// }
// }*/
//        //alternatief  logischer
//        for (int i = 0; i < code.length; i++){
//            for (int j = 0; j < karakters.length; j++){
//                if (code[i] == karakters[j]){
//                    value[i] = j;
//                }
//            }
//        }
//        //testen of 1 van de 3 chars ongeldig is
//        boolean ongeldig = false;
//        for (int j = 0; j < code.length; j++) {
//            if (value[j] == -1) {
//                ongeldig = true;
//            }
//        }
//        if (!ongeldig) {
//            long macht = 1;
//            //10^c
//            for (int i = 0; i < value[2]; i++) {
//                macht = macht * 10;
//            }
//            long result = (value[0] * 10 + value[1]) * macht;
//            System.out.println("R = " + result + " ohm");
//        } else {
//            System.out.println("Ongeldige code");
//        }
//        scanner.close();
//    }