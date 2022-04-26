package be.pxl.h6.Opdracht8;

import java.util.Objects;

public abstract class GrafischElement {
    private int x;
    private int y;
    private static int aantal = 0;

    //INITIALISATIEBLOK

    {
        aantal++;
    }

    public static int getAantal() {
        return aantal;
    }

    public GrafischElement (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPositie (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract double getOppervlakte();
    public abstract double getOmtrek();

    @Override
    public String toString() {
        return "GrafischElement{" + "x=" + x + "y=" + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrafischElement that = (GrafischElement) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}