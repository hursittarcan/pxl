package oefenexamen;

public class Bestelling implements Berekenbaar {
    private Product[] bestelling = new Product[MAXBESTELLINGGROOTTE];
    private int productNummer = 1000;
    private static final int MAXBESTELLINGGROOTTE = 100;

    public Bestelling(){}



    public void getAantalProducten(){
        int teller = 0;
        for (Product product : bestelling) {
            if (product != null) {
                teller += 1;
            }
        }
        System.out.printf("Aantal producten in bestelling: %d", teller);
    }

    public void toonParfums(){
        for (Product product : bestelling) {
            if (product instanceof Parfum) {
                System.out.println(product.toString());
            }
        }
    }

    public void toonPerMerk(String merk){
        for (Product product : bestelling) {
            if (product != null && product.getMerk().equals(merk)) {
                System.out.println(product.toString());
            }
        }
    }

    public void toonLijst(){
        for (Product product : bestelling) {
            if (product != null) {
                System.out.println(product.toString());
            }
        }
    }

    private boolean zitAlInBestelling(Product product){
        for (Product product1 : bestelling) {
            if (product1 != null) {
                    return true;
                }
            }
        return false;
    }

    public void voegProductToe(Product product){
        if (productNummer - 1000 < MAXBESTELLINGGROOTTE){
            if (zitAlInBestelling(product)){
                product.setProductNummer(productNummer);
                bestelling[productNummer - 1000] = product;
                productNummer++;
            } else {
                System.out.println("Het product is reeds toegevoegd.");
            }
        } else {
            System.out.println("Bestelling te groot.");
        }
    }

    public void verwijderProduct(int productNummer){
        if (bestelling[productNummer - 1000] != null){
            bestelling[productNummer - 1000] = null;
            System.out.printf("Product met productnummer %d werd verwijderd.\n", productNummer);
        }
        else {
            System.out.println("Geen product met gegeven productnummer gevonden.");
        }
    }

    @Override
    public double totalePrijs() {
        int totaalPrijs = 0;
        for (Product product : bestelling) {
            if (product != null) {
                totaalPrijs += product.getPrijs();
            }
        }
        return totaalPrijs;
    }

    @Override
    public double totalePrijsExclBtw() {
        return totalePrijs() - (totalePrijs() / 100 * Berekenbaar.BTW);
    }
}
