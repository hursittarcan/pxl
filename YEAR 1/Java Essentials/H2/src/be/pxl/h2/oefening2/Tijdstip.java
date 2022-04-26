package be.pxl.h2.oefening2;

public class Tijdstip {
    private int uren;
    private int minuten;
    private int seconden;

    public Tijdstip(int uren, int minuten, int seconden) {
        setUren(uren);
        setMinuten(minuten);
        setSeconden(seconden);
    }

    public Tijdstip(int seconden) {
        setSeconden(seconden);
    }

    public Tijdstip(Tijdstip anderetijdstip) { //Copy constructor
        setUren(anderetijdstip.uren);
        setMinuten(anderetijdstip.minuten);
        setSeconden(anderetijdstip.seconden);
    }

    public int getUren() {
        return uren;
    }

    public void setUren(int uren) {
        if (uren > 23) {
            uren = uren % 24;
        }
        this.uren = uren;
    }

    public int getMinuten() {
        return minuten;
    }

    public void setMinuten(int minuten) {
        if (minuten > 59) {
            int extraUren = minuten / 60;
            setUren(uren + extraUren);
            minuten = minuten % 60;
        }
        this.minuten = minuten;
    }

    public int getSeconden() {
        return seconden;
    }

    public void setSeconden(int seconden) {
        if (seconden > 59) {
            int extraMinuten = seconden / 60;
            setMinuten(minuten + extraMinuten);
            seconden = seconden % 60;
        }
        this.seconden = seconden;
    }

    public void voegUrenToe(int extraUren) {
        setUren(uren + extraUren);
    }

    public void voegUrenToe() {this.voegUrenToe(1);}

    public void voegMinutenToe(int extraMinuten) {
        setMinuten(minuten + extraMinuten);
    }

    public void voegSecondenToe(int extraSeconden) {
        setSeconden(seconden + extraSeconden);
    }

    public String toStringTijd(boolean engels) {
        String tekst = "Tijd: " + uren + ":" + minuten + " u";
        if (engels) {
            if (uren < 12) {
                tekst = "Tijd: " + uren + ":" + minuten + " AM";
            }
            else {
                tekst = "Tijd: " + uren + ":" + minuten + " PM";
            }
        }
        return tekst;

    }
}
