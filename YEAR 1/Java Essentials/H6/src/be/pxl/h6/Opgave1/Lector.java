package be.pxl.h6.Opgave1;

public class Lector extends Persoon {
    public static final int MIN_AANSTELLING = 0;
    public static final int MAX_AANSTELLING = 100;
    private String personeelsnummer;
    private int aanstellingspercentage;
    private double salaris;

    public String getPersoneelsnummer() {
        return personeelsnummer;
    }

    public void setPersoneelsnummer(String personeelsnummer) {
        this.personeelsnummer = personeelsnummer;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Personeelsnummer: " + personeelsnummer);
        System.out.println("Salaris: " + salaris);
        System.out.println("Aanstellingspercentage: " + aanstellingspercentage);
    }

    public int getAanstellingspercentage() {
        return aanstellingspercentage;
    }

   public Lector(String naam, String voornaam, int aanstellingspercentage, double salaris, String personeelsnummer) {
       super(naam, voornaam);
       setAanstellingspercentage(aanstellingspercentage);
       this.salaris = salaris;
       this.personeelsnummer = personeelsnummer;
   }

   public Lector(String naam, String voornaam, int aanstellingspercentage, double salaris) {
        this(naam, voornaam, aanstellingspercentage, salaris, "20009999");
   }

   public Lector() {
        this("Onbekend", "Onbekend", MAX_AANSTELLING, 2000);
   }



    public void setAanstellingspercentage(int aanstellingspercentage) {
        if (aanstellingspercentage < MIN_AANSTELLING) {
            aanstellingspercentage = MIN_AANSTELLING;
        }
        if (aanstellingspercentage > MAX_AANSTELLING) {
            aanstellingspercentage = MAX_AANSTELLING;
        }
        if (salaris != 0 && this.aanstellingspercentage != 0) {
            salaris = salaris / this.aanstellingspercentage * aanstellingspercentage;
        }
        this.aanstellingspercentage = aanstellingspercentage;
    }

    public double getSalaris() {
        return salaris;
    }

    public void setSalaris(double salaris) {
        this.salaris = salaris;
    }
}
