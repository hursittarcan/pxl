package be.pxl.h2.opdracht1;

public class Rechthoek {
    private int hoogte;
    private int breedte;
    private int x;
    private int y;

    public Rechthoek(int hoogte, int breedte, int x, int y) {
        setHoogte(hoogte);
        setBreedte(breedte);
        setX(x);
        setY(y);
    }
    public Rechthoek() {
    }

//    public Rechthoek(int hoogte, int breedte) {
//        this(hoogte, breedte, 0, 0);
//    }

    public Rechthoek(int hoogte, int breedte) {
        setHoogte(hoogte);
        setBreedte(breedte);
    }

    public Rechthoek(Rechthoek rechthoek) {
        this(rechthoek.getHoogte(), rechthoek.getBreedte(), rechthoek.getX(), rechthoek.getY());
        /*setHoogte(rechthoek.getHoogte());
        setBreedte(rechthoek.getBreedte());
        setX(rechthoek.getX());
        setY(rechthoek.getY());*/
    }

    public int getOmtrek() {
        int resultaat = 2 * breedte + 2 * hoogte;
        return resultaat;
    }

    public void groei(int deltaHoogte, int deltaBreedte) {
        setBreedte(breedte += deltaBreedte);
        setHoogte(hoogte += deltaHoogte);
    }

    public void groei(int delta) {
        groei(delta, delta);
    }

    public int getOppervlakte() {
        int resultaat = breedte * hoogte;
        return resultaat;
    }

    public void setPositie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = Math.abs(hoogte);
    }

    public int getHoogte() {
        return hoogte; // -> Return this.hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        if (breedte < 0) {
            this.breedte = -breedte;
        }
        else {
            this.breedte = breedte;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
