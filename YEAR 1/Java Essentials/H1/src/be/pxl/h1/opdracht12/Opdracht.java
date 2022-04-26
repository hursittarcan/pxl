package be.pxl.h1.opdracht12;

public class Opdracht {
    public static void main(String[] args) {
        int[] numbers = new int [20];
        for (int i = 0; i < numbers.length; i ++) {
            numbers[i] = (i + 1) * 7;
        }
        for (int veelvoud : numbers) {
            System.out.print(veelvoud + " ");
        }
        System.out.println();
        int[] andereNumbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        for (int number : andereNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int i = andereNumbers.length - 1; i >= 0; i --) {
            System.out.print(andereNumbers[i] + " ");
        }
    }
}
