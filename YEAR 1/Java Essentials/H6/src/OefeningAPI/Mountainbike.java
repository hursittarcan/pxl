package OefeningAPI;

public final class Mountainbike extends Fiets {
    private int zadelHoogte;

    public Mountainbike(int zadelHoogte, int aantalOmwentelingen, int snelheid, int aantalVersnellingen) {
        super(aantalOmwentelingen, snelheid, aantalVersnellingen);
        this.zadelHoogte = zadelHoogte;
    }

    @Override
    public String toString() {
        return super.toString() + "* Mountainbike: " + zadelHoogte;
    }
}
