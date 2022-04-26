package be.pxl.h9.Opgave1;

import java.util.Objects;

public class Rechthoek extends GrafischElement {
    private int hoogte;
    private int breedte;

    public Rechthoek(int x, int y,
                     int hoogte, int breedte) {
        super(x, y);
        setHoogte(hoogte);
        setBreedte(breedte);
    }

    public Rechthoek() {
        this(0, 0, 0, 0);
    }

    public Rechthoek(int hoogte, int breedte) {
        this(0, 0, hoogte, breedte);
    }
//andere methoden


    public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        if (hoogte < 0) {
            this.hoogte = -hoogte;
        } else {
            this.hoogte = hoogte;
        }
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        if (breedte < 0) {
            this.breedte = -breedte;
        } else {
            this.breedte = breedte;
        }
    }

    public double getOppervlakte() {
        return breedte * hoogte;
    }

    public double getOmtrek() {
        return 2 * (breedte + hoogte);
    }

    @Override
    public String toString() {
        return String.format("Rechthoek met hoogte %d, breedte %d op positie (%d,%d)",
                hoogte, breedte, getX(), getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rechthoek)) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return getHoogte() == rechthoek.getHoogte() &&
                getBreedte() == rechthoek.getBreedte() &&
                getX() == rechthoek.getX() && getY() == rechthoek.getY();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getHoogte(), getBreedte());
    }

    @Override
    public void herschaal(int factor) {
        breedte = breedte * factor / 100;
        hoogte = hoogte * factor / 100;
    }
}
