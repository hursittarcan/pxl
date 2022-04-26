package be.pxl.h3.opdracht7;

public class Opdracht {
    public static void main(String[] args) {
        String tekst = "Halle mijn naam is x";
        System.out.println(tekst + ", het aantal letters: " + tekst.length());
        System.out.println();
        System.out.println(tekst.replace("a", "o"));
        System.out.println();
        int occurences = 0;
        int fromIndex = 0;
        while (tekst.indexOf('e', fromIndex) != -1) {
            occurences++;
            fromIndex = tekst.indexOf('e', fromIndex) + 1;
        }
        System.out.println(occurences);
        System.out.println();
        int aantal = tekst.length() - tekst.replace("e", "").length();
        String text = "abcdef";
        int from = text.length() / 2;
        int to = from + 1;
        if (text.length() % 2 == 0) {
            from -= 1;
        }
        text = text.substring(0, from) +
                text.substring(from, to).toUpperCase() +
                text.substring(to);
        System.out.println(text);
    }
}
