package be.pxl.h1.opdracht8;

public class Bankkaart {
    public static void main(String[] args) {
        long nummer = 539007547034L;
        nummer *= 1000000;
        nummer += 111400;
        int rest = (int) (nummer % 97);
        int controle = 98 - rest;
        System.out.println("Controlegetal: " + controle);
    }
}
