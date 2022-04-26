package be.pxl.h2.oefening1;

public class PerssonApp2 {
    public static void main(String[] args) {
        Persoon persoon = new Persoon();
        Persoon persoon1 = new Persoon("Bart", "Simpson");
        Persoon persoon2 = new Persoon(persoon);
        Persoon persoon3 = new Persoon(persoon);
        Persoon persoon4 = new Persoon();
        Persoon persoon5 = new Persoon("Bart", "Simpson");
        Persoon persoon6 = new Persoon(persoon);
        Persoon persoon7 = new Persoon(persoon);
        Persoon persoon8 = new Persoon();
        Persoon persoon9 = new Persoon("Bart", "Simpson");
        Persoon persoon10 = new Persoon(persoon);
        Persoon persoon11  = new Persoon(persoon);
        Persoon persoon88 = new Persoon();
        Persoon persoon100 = new Persoon("Bart", "Simpson");
        System.out.println(Persoon.getTeller());
    }
}
