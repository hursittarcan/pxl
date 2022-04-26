package be.pxl.h6.Opdracht8;

public class Vierkant extends Rechthoek {
    public Vierkant(int x, int y, int h) {
        super(x, y, h, h);
    }

    public Vierkant(int h) {
        super();
        setHoogte(h);
        setBreedte(h);
    }
}
