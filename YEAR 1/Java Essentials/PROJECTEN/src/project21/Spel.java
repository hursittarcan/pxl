package project21;

public abstract class Spel {
    private static final int MINIMUM_LEEFTIJD = 12;
    private String naam;
    private int minimumLeeftijd;
    private Uitgever uitgever; //Associaties nachecken!

    public Spel(String naam, Uitgever uitgever) {
        setNaam(naam);
        setUitgever(uitgever);
    }

    public int getMinimumLeeftijd() {
        return minimumLeeftijd;
    }

    public void setMinimumLeeftijd(int minimumLeeftijd) {
        if (minimumLeeftijd < 0) {
            minimumLeeftijd = MINIMUM_LEEFTIJD;
        }
        this.minimumLeeftijd = minimumLeeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Uitgever getUitgever() {
        return uitgever;
    }

    public void setUitgever(Uitgever uitgever) {
        this.uitgever = uitgever;
    }

    @Override
    public String toString() {
        String tekst = "{naam='" + naam + "', minimumLeeftijd=" + minimumLeeftijd + "uitgever=" + uitgever;
        return tekst;
    }
}
