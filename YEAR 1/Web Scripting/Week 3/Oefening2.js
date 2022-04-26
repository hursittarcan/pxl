class Persoon {
    constructor(naam, voornaam, geboortedatum) {
        this._naam = naam;
        this._voornaam = voornaam;
        this._geboortedatum = geboortedatum;
    }

    set naam(naam) {
        this._naam = naam;  //Met underscore kan je in de code van de classe ook iets aanpassen door de setter aan te roepen.
    }

    get naam() {
        return this._naam;
    }

    set voornaam(voornaam) {
        this._voornaam = voornaam;
    }

    get voornaam() {
        return this._voornaam;
    }

    set geboortedatum(geboortedatum) {
        this._geboortedatum = geboortedatum;
    }

    get geboortedatum() {
        return this._geboortedatum;
    }

    berekenLeeftijd() {
        let datumNu = new Date();
        let datumGeboorte = new Date(this.geboortedatum);
        let extra = 0;
        if (datumNu.getMonth() < datumGeboorte.getMonth()) {
            extra = 1;
        }
        let leeftijd = datumNu.getFullYear() - datumGeboorte.getFullYear() - extra;
        return leeftijd;
    }
    print() {
        console.log(`Naam: ${this.naam}, Voornaam: ${this.voornaam}, Geboortedatum: ${this.geboortedatum}, Leeftijd: ${this.berekenLeeftijd()}`);
    }
}

let per = new Persoon("hursit", "tarcan", "December 15, 1999 00:00:00");
per.print();

