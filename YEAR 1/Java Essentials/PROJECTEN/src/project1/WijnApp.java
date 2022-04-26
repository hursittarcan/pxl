package project1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class WijnApp {
    public static void main(String[] args) {
        Wijn wijn1 = new Wijn("Parra", "Spanje", "Wit", 2016, 11.5);
        wijn1.setOmschrijving("Licht, fris en strak");
        wijn1.setDruivenras("Sauvignon Blanc");
        wijn1.setRegio("La Mancha");
        wijn1.setServeertip("Visgerechten");

        Wijn wijn2 = new Wijn("Domaine de la Jardine", "Frankrijk", "Rood", 2016, 14);
        wijn2.setOmschrijving("Licht, soepel en fruitig");
        wijn2.setDruivenras("Merlot");
        wijn2.setRegio("Pays d'Oc");
        wijn2.setServeertip("Gevogelte");

        Wijn wijn3 = new Wijn("Montebello", "Italie", "Rood", 2016, 13);
        wijn3.setOmschrijving("Licht, soepel en fruitig");
        wijn3.setDruivenras("Negroamara");
        wijn3.setRegio("Puglia");
        wijn3.setServeertip("Gegrild vlees");

        Wijn wijn4 = new Wijn("Chateau Palmer 3eme Grand Cru", "Spanje", "Rood", 2002, 13.5);
        wijn4.setOmschrijving("Complex, krachtig en vol");
        wijn4.setDruivenras("Merlot");
        wijn4.setRegio("Bordeaux");

        ArrayList<Wijn> wijnen = new ArrayList<>(Arrays.asList(wijn1, wijn2, wijn3, wijn4));

        Wijn duursteWijn = wijnen.get(0);
        Wijn goedkoopsteWijn = wijnen.get(0);
        for (int i = 1; i < wijnen.size(); i++) {
            if (wijnen.get(i).getAdviesprijs() > duursteWijn.getAdviesprijs()) {
                duursteWijn = wijnen.get(i);
            }
        }
        for (int i = 1; i < wijnen.size(); i++) {
            if (wijnen.get(i).getAdviesprijs() < goedkoopsteWijn.getAdviesprijs()) {
                goedkoopsteWijn = wijnen.get(i);
            }
        }

        int aantalRodeWijnen = 0;
        for (int i = 0; i < wijnen.size(); i++) {
            if (wijnen.get(i).getKleur().equals("Rood")) {
                aantalRodeWijnen++;
            }
        }

        ArrayList<Wijn> gevogelteWijnen = new ArrayList<>(); //Niet helemaal juist --> Laat ook haakjes zien!
        for (int i = 0; i < wijnen.size(); i++) {
            if (wijnen.get(i).getServeertip() != null && wijnen.get(i).getServeertip().equals("Gevogelte")) {
                gevogelteWijnen.add(wijnen.get(i));
            }
        }

        System.out.println("Het label van de duurste wijn is: " + duursteWijn.getLabel());
        System.out.println("Het label van de goedkoopste wijn is: " + goedkoopsteWijn.getLabel());
        System.out.println("Het aantal rode wijnen is: " + aantalRodeWijnen);
        System.out.println("Wijnen die goed passen bij gevogelte: " );
        //for each gebruiken!
    }
}
