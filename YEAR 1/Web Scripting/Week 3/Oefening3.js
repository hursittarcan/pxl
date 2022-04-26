class Account {
    constructor(landcode, banknummer, eersteTienPosities) {
        this._landcode = landcode;
        this._banknummer = banknummer;
        this._eersteTienPosities = eersteTienPosities;
        this._saldo = 0;
    }
    print() {
        let eersteTien = this._banknummer + this._eersteTienPosities.substring(0, 8);
        let restWaarde = parseInt(eersteTien) % 97;
        console.log(this._landcode + this._banknummer + this._eersteTienPosities + restWaarde)
    }
}

let acc = new Account("BE", "12", "1245788020");
acc.print();

//OPGAVE KLOPT NIET HELEMAAL!