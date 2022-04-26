class Date {
    constructor(day, month, year) {
        this._day = day;
        this._month = month;
        this._year = year;
        //Date.xxx = {}; --> STATIC!
    }
    static MONTHS() {
        let MONTHS
        return ["1","2"];
    }
    set day(day) {
        this._day = day;
    }
    get day() {
        return this._day;
    }
    set month(month) {
        this._month = month;
    }
    get month() {
        return this._month;
    }
    set year(year) {
        this._year = year;
    }
    get year() {
        return this._year;
    }
    print() {
        console.log(`${this.day}/${this.month}/${this.year}`);
    }
    printMonth() {
        console.log(`${this.day}/${(this.month)}/${this.year}`);
    }
}

let d = new Date(15, 12, 1999);
d.print();
d.printMonth();
