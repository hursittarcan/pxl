package project21;

public class BordSpel extends Spel {
    private static final int SPELERS_NEGATIEF = 1;
    private static final int DUUR_NEGATIEF = 30;
    private int aantalSpelers;
    private int speelduur;

    public BordSpel(String naam, Uitgever uitgever) {
        super(naam, uitgever);
    }

    public int getAantalSpelers() {
        return aantalSpelers;
    }

    public void setAantalSpelers(int aantalSpelers) {
        if (aantalSpelers < 0) {
            aantalSpelers = SPELERS_NEGATIEF;
        }
        this.aantalSpelers = aantalSpelers;
    }

    public int getSpeelduur() {
        return speelduur;
    }

    public void setSpeelduur(int speelduur) {
        if (speelduur < 0) {
            speelduur = DUUR_NEGATIEF;
        }
        this.speelduur = speelduur;
    }

    @Override
    public String toString() {
        String tekst = "naam='" + getNaam() + "', minimumleeftijd=" + getMinimumLeeftijd()
                + ", uitgever=" ;
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BordSpel bordSpel = (BordSpel) o;

        if (aantalSpelers != bordSpel.aantalSpelers) return false;
        return speelduur == bordSpel.speelduur;
    }

    @Override
    public int hashCode() {
        int result = aantalSpelers;
        result = 31 * result + speelduur;
        return result;
    }
}
