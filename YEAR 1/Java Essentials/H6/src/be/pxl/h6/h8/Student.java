package be.pxl.h6.h8;

public class Student {
    private int nr;
    private String naam;

    public Student(int nr, String naam) {
        this.nr = nr;
        this.naam = naam;
    }

    public Student(String naam) {
        this.naam = naam;
    }

    public Student(int nr) {
        this.nr = nr;
    }

    public void drukAf() {
        System.out.println("Student  " + naam + " heeft nummer " + nr);
    }


}
