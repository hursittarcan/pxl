package OefeningAPI;

public class Fiets {
    private int aantalOmwentelingen;
    private int snelheid;
    private int aantalVersnellingen;

    public Fiets(int aantalOmwentelingen, int snelheid, int aantalVersnellingen) {
        this.aantalOmwentelingen = aantalOmwentelingen;
        this.snelheid = snelheid;
        this.aantalVersnellingen = aantalVersnellingen;
    }

    public void wijzigSnelheid(int verschil) {
        this.snelheid += verschil;
    }

    @Override
    public String toString() {
        return aantalOmwentelingen + " - " + aantalVersnellingen + " - " + snelheid;
    }
}
