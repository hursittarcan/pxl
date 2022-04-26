package Project2;

public class BordSpel extends Spel {
    private static final int MIN_SPELERS = 1;
    private static final int MIN_SPEELDUUR = 30;
    private int aantalSpelers;
    private int speelDuur;

    public BordSpel(String naam, Uitgever uitgever) {
        super(naam, uitgever);
    }

    public int getAantalSpelers() {
        return aantalSpelers;
    }

    public void setAantalSpelers(int aantalSpelers) {
        if (aantalSpelers < 0) {
            aantalSpelers = MIN_SPELERS;
        }
        this.aantalSpelers = aantalSpelers;
    }

    public int getSpeelDuur() {
        return speelDuur;
    }

    public void setSpeelDuur(int speelDuur) {
        if (speelDuur < 0) {
            speelDuur = MIN_SPEELDUUR;
        }
        this.speelDuur = speelDuur;
    }

    @Override
    public String toString() {
        return  "Bordspel" + super.toString() +
                String.format(", aantalSpelers=%d, speelduur=%d}", getAantalSpelers(), getSpeelDuur());
    }
}
