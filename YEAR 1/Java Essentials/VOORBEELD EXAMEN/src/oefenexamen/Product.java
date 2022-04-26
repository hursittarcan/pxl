package oefenexamen;

public abstract class Product {
    private int productNummer;
    private String merk;
    private String naam;
    private int volume;
    private double prijs;

    public Product(int productNummer, String merk, String naam, int volume, double prijs) {
        this.productNummer = productNummer;
        this.merk = merk;
        this.naam = naam;
        this.volume = volume;
        this.prijs = prijs;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getProductCode() {
        String eersteDeel = merk.substring(0,3);
        String tweedeDeel = naam.substring(0, 3);
        String totaal = (eersteDeel + tweedeDeel + volume).toUpperCase();
        totaal = totaal.replace(" ", "_");
        return totaal;
    }

    @Override
    public String toString() {
        String totaal = String.format("%d Merk: %-20s Naam: %-20s Volume: %5dml Prijs: %7.2f Code: %s-10",
                productNummer, merk, naam, volume, prijs, getProductCode());
        return totaal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (volume != product.volume) return false;
        if (merk != null ? !merk.equals(product.merk) : product.merk != null) return false;
        return naam != null ? naam.equals(product.naam) : product.naam == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productNummer;
        result = 31 * result + (merk != null ? merk.hashCode() : 0);
        result = 31 * result + (naam != null ? naam.hashCode() : 0);
        result = 31 * result + volume;
        temp = Double.doubleToLongBits(prijs);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
