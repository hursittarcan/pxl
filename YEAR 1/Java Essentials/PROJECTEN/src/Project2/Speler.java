package Project2;

public class Speler {
    private String naam;
    private int geboortejaar;

    public Speler(String naam, int geboortejaar) {
        this.naam = naam;
        this.geboortejaar = geboortejaar;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }
}
