package be.pxl.h6.h8;

import java.util.ArrayList;

public class Klas {
    public static void main(String args[]) {
        ArrayList<Student> lijstStudenten =
                new ArrayList<Student>();

        lijstStudenten.add(new Student(10, "Erik"));
        lijstStudenten.add(new Student(20, "Dirk"));
        lijstStudenten.add(new Student(30, "Anne"));

        System.out.println("\nOorspronkelijke klaslijst");
        for (Student student : lijstStudenten) {
            student.drukAf();
        }

        lijstStudenten.add(1, new Student(22, "Piet"));
        lijstStudenten.remove(3);
        lijstStudenten.set(0, new Student(11, "Ilse"));

        System.out.println("\nGewijzigde klaslijst");
        for (Student student : lijstStudenten) {
            student.drukAf();
        }

        int positie = lijstStudenten.indexOf(new Student("Ilse"));

        if (positie == -1) {
            System.out.println("Ilse komt niet voor in de arraylist");
        } else {
            Student gevonden = lijstStudenten.get(positie);
            System.out.println("Opzoeking in de arraylist levert op : ");
            gevonden.drukAf();
        }
    }
}
