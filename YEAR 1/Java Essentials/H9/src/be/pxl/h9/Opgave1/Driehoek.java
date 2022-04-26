package be.pxl.h9.Opgave1;

public class Driehoek extends GrafischElement {
    private double hoogte;
    private double basis;
    private double plaatsLoodlijn;
    // x, y positie van het hoekpunt vanwaar plaatsloodlijn bepaald wordt

    public Driehoek(int x, int y, double h, double b, double lood) {
        super(x, y);
        basis = b;
        hoogte = h;
        plaatsLoodlijn = lood;
    }

    public Driehoek() {
        this(0, 0, 0, 0, 0);

    }

    public Driehoek(Driehoek driehoek) {
        this(driehoek.getX(), driehoek.getY(), driehoek.hoogte, driehoek.basis, driehoek.plaatsLoodlijn);
    }

    @Override
    public double getOppervlakte() {
        return basis * hoogte / 2;
    }

    @Override
    public double getOmtrek() {
        double zijde1 = Math.sqrt(plaatsLoodlijn * plaatsLoodlijn + hoogte * hoogte);
        double zijde2 = Math.sqrt((basis - plaatsLoodlijn) * (basis - plaatsLoodlijn) + hoogte * hoogte);
        return zijde1 + zijde2 + basis;

    }

    public double getHoogte() {
        return hoogte;
    }

    public void setHoogte(double hoogte) {
        if (hoogte < 0) {
            this.hoogte = -hoogte;
        } else {
            this.hoogte = hoogte;
        }
    }

    public double getBasis() {
        return basis;
    }

    public void setBasis(double basis) {
        if (basis < 0) {
            this.basis = -basis;
        } else {
            this.basis = basis;
        }
    }

    public double getPlaatsLoodlijn() {
        return plaatsLoodlijn;
    }

    public void setPlaatsLoodlijn(double plaatsLoodlijn) {
        this.plaatsLoodlijn = plaatsLoodlijn;
    }

    @Override
    public String toString() {
        return String.format("Driehoek met hoogte %.1f, breedte %.1f , plaats van de loodlijn  %.1f op positie (%d,%d)",
                hoogte, basis, plaatsLoodlijn, getX(), getY());
    }

    @Override
    public void herschaal(int factor) {
        basis = basis * factor / 100;
        hoogte = hoogte * factor / 100;
    }
}
