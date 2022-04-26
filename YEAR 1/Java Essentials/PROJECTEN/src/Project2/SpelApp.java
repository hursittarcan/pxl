package Project2;

public class SpelApp {
    public static void main(String[] args) {
        Uitgever uitgever = new Uitgever("riot games", "LA", 1980);
        BordSpel tiktak = new BordSpel("tiktak", uitgever);
        tiktak.setAantalSpelers(4);
        tiktak.setSpeelDuur(30);
        System.out.println(tiktak.toString());
        System.out.println();
        OnlineSpel lol = new OnlineSpel("lol", uitgever);
        System.out.println(lol.toString());
    }
}
