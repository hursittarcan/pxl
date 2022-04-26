package be.pxl.h2.oefening2;

public class TijdApp {
    public static void main(String[] args) {
        Tijdstip tijd = new Tijdstip(10, 50, 40);
//        tijd.setUren(16);
//        tijd.setMinuten(60);
//        tijd.setSeconden(3599);
        tijd.voegMinutenToe(0);
        tijd.voegSecondenToe(1);
        tijd.voegUrenToe();
        tijd.voegUrenToe();
        System.out.println(tijd.getUren());
        System.out.println(tijd.getMinuten());
        System.out.println(tijd.getSeconden());
        System.out.println(tijd.toStringTijd(true));
    }
}
