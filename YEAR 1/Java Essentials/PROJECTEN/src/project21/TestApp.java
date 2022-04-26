package project21;

public class TestApp {
    public static void main(String[] args) {
        Uitgever uitgever = new Uitgever("riotgames", "LA", 2010);
        uitgever.setWebsite("www.riotgames.be");
        System.out.println(uitgever.toString());
        BordSpel spel = new BordSpel("schaken", uitgever);
        System.out.println(spel.toString());
    }
}
