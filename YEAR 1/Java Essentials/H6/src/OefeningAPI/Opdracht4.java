package OefeningAPI;

import java.util.ArrayList;

public class Opdracht4 {
    public static void main(String[] args) {
        ArrayList <String> woorden = new ArrayList<>();
        woorden.add("voorbeeld1");
        woorden.add("voorbeeld2");
        woorden.add("voorbeeld3");
        woorden.add(1, "nieuwe waarde");
        woorden.set(1, "voorbeeld4");
        for (int i = 0; i < woorden.size(); i++) {
            System.out.println("Index " + i + " : " + woorden.get(i));
        }
        String verwijderElement = woorden.remove(1);
        for (String woord : woorden) {
            System.out.println(woord);
        }
        System.out.println(woorden.indexOf("voorbeeld2"));
        woorden.clear();
        System.out.println("Size: " + woorden.size());
    }
}

