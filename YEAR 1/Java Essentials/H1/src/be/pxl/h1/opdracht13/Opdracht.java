package be.pxl.h1.opdracht13;
import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        int [][] tabel = new int [4][6];
        for (int rij = 0; rij < tabel.length; rij ++ ) {
            for (int kol = 0; kol < tabel[rij].length; kol ++) {
                System.out.print(tabel[rij][kol] + "\t");
            }
            System.out.println();
        }
    }
}
