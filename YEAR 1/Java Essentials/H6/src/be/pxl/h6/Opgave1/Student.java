package be.pxl.h6.Opgave1;

public class Student extends Persoon {
    public static final int MAX_LEERKREDIET = 140;
    public static final int MIN_LEERKREDIET = 0;
    private int leerkrediet;
    private String studentnummer;
    private String opleiding;
    private static int aantal = 0;

    {
        aantal++;
    }

    public Student(String naam, String voornaam, String studentnummer, String opleiding) {
        super(naam, voornaam);
        this.studentnummer = studentnummer;
        this.opleiding = opleiding;
        setLeerkrediet(MAX_LEERKREDIET);
    }

    public Student(String naam, String voornaam) {
        this(naam, voornaam, "15999999", "XXX");
    }

    public Student() {
        this("Onbekend", "Onbekend");
    }

    public Student(Student student) {
        this(student.getNaam(), student.getVoornaam(), student.getStudentnummer(), student.getOpleiding());
        setLeerkrediet(student.leerkrediet);
    }

    public int getLeerkrediet() {
        return leerkrediet;
    }

    public void setLeerkrediet(int leerkrediet) {
        if (leerkrediet > MAX_LEERKREDIET) {
            leerkrediet = MAX_LEERKREDIET;
        }
        if (leerkrediet < MIN_LEERKREDIET) {
            leerkrediet = MIN_LEERKREDIET;
        }
        this.leerkrediet = leerkrediet;
    }

    public void wijzigLeerkrediet(int verschil) {
        setLeerkrediet(leerkrediet + verschil);
    }

    public String getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(String studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    public static int getAantal() {
        return aantal;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Leerkrediet: " + leerkrediet);
        System.out.println("Studentennummer: " + studentnummer);
        System.out.println("Opleiding: " + opleiding);
    }
}
