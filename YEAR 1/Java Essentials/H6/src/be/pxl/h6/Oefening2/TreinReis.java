package be.pxl.h6.Oefening2;

public class TreinReis extends Reis {
    private boolean nationaal;
    private String specificatie;

    public boolean isNationaal() {
        return nationaal;
    }

    public void setNationaal(boolean nationaal) {
        this.nationaal = nationaal;
    }

    public String getSpecificatie() {
        return specificatie;
    }

    public void setSpecificatie(String specificatie) {
        this.specificatie = specificatie;
    }
}
