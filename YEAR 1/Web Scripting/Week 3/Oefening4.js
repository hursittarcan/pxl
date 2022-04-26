class Account {
    constructor(landcode, banknummer, eersteTienPosities) {
        this._landcode = landcode;
        this._banknummer = banknummer;
        this._eersteTienPosities = eersteTienPosities;
        this._saldo = 0;
    }
    get saldo() {
        return this._saldo;
    }
    set saldo(saldo) {
        if (saldo < 0) {
            saldo = 0;
        }
        this._saldo = saldo;
    }
    stort(bedrag) {
        this.saldo = this.saldo + bedrag;
    }
    print() {
        let eersteTien = this._banknummer + this._eersteTienPosities.substring(0, 8);
        let restWaarde = parseInt(eersteTien) % 97;
        console.log(this._landcode + this._banknummer + this._eersteTienPosities + restWaarde)
    }
}

let acc = new Account("BE", "12", "1245788956");
acc.print();
acc.saldo = 1000;
console.log(acc.saldo);
acc.stort(-2000);
console.log(acc.saldo);