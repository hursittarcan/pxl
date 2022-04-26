package be.pxl.h6.Oefening1;

public class Manager extends Werknemer {
    private double bonus;
    private static int aantal;

    {
        aantal++;
    }

    public Manager(String naam, String voornaam, String functie, double salaris, double bonus) {
        super(naam, voornaam, functie, salaris);
        setBonus(bonus);
    }

    public Manager(String naam, String voornaam, String functie, double salaris) {
        this(naam, voornaam, functie, salaris, 50);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalaris() {
        return super.getSalaris() + bonus;
    }
}
