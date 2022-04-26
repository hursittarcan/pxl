package be.pxl.h6.Opgave1;

public class SchoolApp {
    public static void main(String[] args) {
        Persoon eenPersoon = new Persoon("Flater", "Guust");
        Student eenStudent = new Student();
        eenStudent.setVoornaam("Vince");
        System.out.println(eenStudent.getVoornaam());
        eenStudent.setLeerkrediet(120);
        eenStudent.wijzigLeerkrediet(25);
        System.out.println(eenStudent.getLeerkrediet());
        eenPersoon.print();
        eenStudent.print();

        Persoon polymorfObject = new Student();
        polymorfObject.setNaam("Anthonny");
        polymorfObject.setVoornaam("Riddick");
        ((Student) polymorfObject).setOpleiding("Informatica");
        polymorfObject.print();

        Lector hector = new Lector();
        hector.setVoornaam("Hector");
        hector.setSalaris(10000);
        hector.setAanstellingspercentage(100);
        hector.setAanstellingspercentage(50);
        System.out.println(hector.getSalaris());

        System.out.println("Aantal personen: " + Persoon.getAantal());
        System.out.println("Aantal studenten: " + Student.getAantal());
    }
}
