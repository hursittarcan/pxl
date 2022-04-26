package be.pxl.h5.Opdracht.auteur;

public class BoekApp {
    public static void main(String[] args) {
        Auteur auteur = new Auteur("Hursit", "Tarcan");
        Boek boek = new Boek("ABCD", "213654651-546", 536, auteur);
        System.out.println(boek.getAuteur().getNaam());
        boek.toonBoekGegevens();
    }
}
