package be.pxl.h6.Opdracht8;

public class Cirkel extends GrafischElement {
    private double straal;

    public Cirkel(int x, int y, double straal) {
        super(x, y);
        this.straal = straal;
    }

    @Override
    public double getOppervlakte() {
        return straal * straal * Math.PI;
    }

    @Override
    public double getOmtrek() {
        return 2 * straal * Math.PI;
    }

    @Override
    public String toString() {
        return "Cirkel{" + "straal= " + straal + '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cirkel cirkel = (Cirkel) o;

        return Double.compare(cirkel.straal, straal) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(straal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
