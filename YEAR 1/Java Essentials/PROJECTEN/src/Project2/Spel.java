package Project2;

public abstract class Spel {
    private static final int MINIMUMWAARDE_LEEFTIJD = 0;
    private static final int STANDAARDWAARDE_LEEFTIJD = 12;
    private String naam;
    private int minimumLeeftijd;
    private Uitgever uitgever; //Associatie nachecken!

    public Spel(String naam, Uitgever uitgever) {
        setNaam(naam);
        this.uitgever = uitgever;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getMinimumLeeftijd() {
        return minimumLeeftijd;
    }

    public void setMinimumLeeftijd(int minimumLeeftijd) {
        if (minimumLeeftijd < MINIMUMWAARDE_LEEFTIJD) {
            minimumLeeftijd = STANDAARDWAARDE_LEEFTIJD;
        }
        this.minimumLeeftijd = minimumLeeftijd;
    }

    public Uitgever getUitgever() {
        return uitgever;
    }

    @Override
    public String toString() {
        return String.format("{naam='%s', minimumLeefijd=%d, \n", naam, minimumLeeftijd) + uitgever.toString();
    }
}
