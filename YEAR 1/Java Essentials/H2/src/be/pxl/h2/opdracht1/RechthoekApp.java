package be.pxl.h2.opdracht1;

public class RechthoekApp {
    public static void main(String[] args) {
        System.out.println("Dit programma maalt een rechthoek.");
        Rechthoek rechthoek = new Rechthoek();
        System.out.println(rechthoek.getX());
        System.out.println(rechthoek.getY());
        System.out.println(rechthoek.getBreedte());
        System.out.println(rechthoek.getHoogte());
        rechthoek.setX(15);
        rechthoek.setY(110);
        rechthoek.setBreedte(120);
        rechthoek.setHoogte(70);
        System.out.println(rechthoek.getX());
        System.out.println(rechthoek.getY());
        System.out.println(rechthoek.getBreedte());
        System.out.println(rechthoek.getHoogte());
        Rechthoek rechthoek2 = new Rechthoek();
        rechthoek2.setBreedte(250);
        rechthoek2.setHoogte(120);
        rechthoek2.groei(20,10);
        System.out.println(rechthoek2.getBreedte());
        System.out.println(rechthoek2.getHoogte());
        int omtrkRechthoek2 = rechthoek2.getOmtrek();
        int oppervlakterechthoek2 = rechthoek2.getOppervlakte();
        System.out.println("Omtrek: " + omtrkRechthoek2);
        System.out.println("Oppervlakte: " + oppervlakterechthoek2);
        // OF ("Oppervlakte: " + rechthoek2.getOppervlakte())
        rechthoek2.setHoogte(-70);
        System.out.println(rechthoek2.getHoogte());
        rechthoek2.groei(0, -300);
        System.out.println("Breedte na groei -300: " + rechthoek2.getBreedte());
        rechthoek2.groei(100);
        System.out.println(rechthoek2.getHoogte() + " x " + rechthoek2.getBreedte());
        Rechthoek rechtzoek3 = new Rechthoek(15, 30);
        Rechthoek rechthoek4 = new Rechthoek(20, 50, 8, 64);
        Rechthoek rechthoek5 = new Rechthoek(rechthoek4);

    }
}
