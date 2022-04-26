package be.pxl.h6.VoorH7;

public enum Dag {
    MAANDAG("Weekdag"),
    DINSDAG("Weekdag"),
    WOENSDAG("Weekdag"),
    DONDERDAG("Weekdag"),
    VRIJDAG("Weekdag"),
    ZATERDAG("weekenddag"),
    ZONDAG("weekenddag");

    private String type;

    private Dag(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
