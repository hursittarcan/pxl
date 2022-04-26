package be.pxl.h5.Opdracht.auteur;

public class Boek {
    private String isbn;
    private int bladzijden;
    private String titel;
    private Auteur auteur;

    public Boek(String titel, String isbn, int aantalBladzijden, Auteur auteur) {
        this.titel = titel;
        this.isbn = isbn;
        this.bladzijden = aantalBladzijden;
        this.auteur = auteur;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBladzijden() {
        return bladzijden;
    }

    public void setBladzijden(int bladzijden) {
        this.bladzijden = bladzijden;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void toonBoekGegevens() {
        StringBuilder builder = new StringBuilder();
        builder.append("Titel: ").append(titel).append("\n");
        builder.append("isbn: ").append(isbn).append("\n");
        builder.append("Bladzijden: ").append(bladzijden).append("\n");
        builder.append(auteur.toString());
        System.out.println(builder.toString());
    }


}
