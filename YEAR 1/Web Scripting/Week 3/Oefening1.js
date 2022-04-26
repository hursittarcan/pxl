let persoon = {
    naam : "Tarcan",
    voornaam : "Hursit",
    geboortedatum : new Date("December 15, 1999 01:00:00"), //Je moet 1 uur extra zetten, want het uur wordt omgezet!
    berekenLeeftijd : function() {
        let datumNu = new Date();
        let datumGeboorte = this.geboortedatum;
        let extra = 0;
        if (datumNu.getMonth() < datumGeboorte.getMonth()) {
            extra = 1;
        }
        let leeftijd = datumNu.getFullYear() - datumGeboorte.getFullYear() - extra;
        return leeftijd;
    },
    print : function() {
        console.log(`Naam: ${this.naam}, Voornaam: ${this.voornaam}, Geboortedatum: ${this.geboortedatum}, Leeftijd: ${this.berekenLeeftijd()}`)
    }
};

console.log(persoon.naam);
console.log(persoon.voornaam);
console.log(persoon.geboortedatum);
console.log(persoon.berekenLeeftijd());
persoon.print();
