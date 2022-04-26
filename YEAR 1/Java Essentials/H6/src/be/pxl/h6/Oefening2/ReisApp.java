package be.pxl.h6.Oefening2;

public class ReisApp {
    public static void main(String[] args) {
        Reis reis = new Reis("2Belgie");
        System.out.println(reis.getBestemming());
        reis.setPrijs(6.245);
        reis.print();
    }
}
