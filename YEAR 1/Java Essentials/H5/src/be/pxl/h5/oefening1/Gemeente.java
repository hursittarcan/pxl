package be.pxl.h5.oefening1;

public class Gemeente {
    private int postcode;
    private String gemeenteNaam;

    public Gemeente(int postcode, String gemeenteNaam) {
        setPostcode(postcode);
        setGemeenteNaam(gemeenteNaam);
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        while (postcode > 9999) {
            postcode /= 10;
        }
        while (postcode < 1000) {
            postcode *= 10;
        }
        this.postcode = postcode;
    }

    public String getGemeenteNaam() {
        return gemeenteNaam;
    }

    public void setGemeenteNaam(String gemeenteNaam) {
        //deel 1 cijfers verwijderen!
        String resultaat = "";
        for (int i = 0; i < gemeenteNaam.length(); i ++) {
            if (!Character.isDigit(gemeenteNaam.charAt(i))) {
                resultaat += gemeenteNaam.substring(i, i + 1);
            }
        }
        //deel 2: eerste letter hoofdletter, rest kleine letter!
        //behalve na - en spatie
        StringBuilder deel2 = new StringBuilder(Character.toUpperCase(resultaat.charAt(0)));
        deel2.append(Character.toUpperCase(resultaat.charAt(0)));
        for (int i = 1; i < resultaat.length(); i++) {
            char vorigeKarakter = resultaat.charAt(i - 1);
            if (vorigeKarakter == '-' || vorigeKarakter == ' ') {
                deel2.append(resultaat.charAt(i));
            }
            else {
                deel2.append(Character.toLowerCase(resultaat.charAt(i)));
            }
        }
        this.gemeenteNaam = deel2.toString();
    }

    @Override
    public String toString() {
        return postcode + " " + gemeenteNaam;
    }

    /*
    * Klasse -> Starten met hoofdletter
    * 2. Eigenschappen
    * 3. Getters en Setters
    * 4. Constructors
    * 5. to String
    * */
}
