package Project2;

import java.time.LocalDate;

public class Uitgever {
    private String naam;
    private int jaarOprichting;
    private String hoofdkantoor;
    private String website;

    public Uitgever(String naam, String hoofdkantoor, int jaarOprichting) {
        this.naam = naam;
        this.hoofdkantoor = hoofdkantoor;
        this.jaarOprichting = jaarOprichting;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getJaarOprichting() {
        return jaarOprichting;
    }

    public void setJaarOprichting(int jaarOprichting) {
        if (jaarOprichting > LocalDate.now().getYear()) {
            jaarOprichting = 0;
        }
        this.jaarOprichting = jaarOprichting;
    }

    public String getHoofdkantoor() {
        return hoofdkantoor;
    }

    public void setHoofdkantoor(String hoofdkantoor) {
        this.hoofdkantoor = hoofdkantoor;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        String tekst;
        tekst = String.format("Uitgever{'%s', jaarOprichting=%s, \n" +
                "hoofdkantoor='%s', website='website'}", naam, getJaarOprichting(),
                hoofdkantoor, website);
        return tekst;
    }
}
