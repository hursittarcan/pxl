package oefenexamen;

public class AfterShave extends Product {
    private DeoType soort;

    public AfterShave(int productNummer, String merk, String naam, int volume, double prijs, DeoType soort) {
        super(productNummer, merk, naam, volume, prijs);
        this.soort = soort;
    }

    @Override
    public String toString() {
        return super.toString() + soort;
    }
}
