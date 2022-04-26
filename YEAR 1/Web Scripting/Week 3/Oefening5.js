class inputException extends Error {}

class Vec {
    constructor(x, y) {
        if (typeof x !== 'number' || typeof y !== 'number') {
            throw new inputException("Parameters moeten getallen zijn!");  //Zie langere versie onderaan!
        }
        this._x = x;
        this._y = y;
    }
    plus(vec, vec2) {
        if (typeof vec !== 'object' || typeof vec2 !== 'object') {
            throw new inputException("Parameters moeten Vec-objecten zijn!");
        }
        let x, y;
        x = vec._x + vec2._x;
        y = vec._y + vec2._y;
        return new Vec(x, y);
    }
    minus(vec, vec2) {
        if (typeof vec !== 'object' || typeof vec2 !== 'object') {
            throw new inputException("Parameters moeten Vec-objecten zijn!");
        }
        let x, y;
        x = Math.abs(vec._x - vec2._x);
        y = Math.abs(vec._y - vec2._y);
        return new Vec(x, y);
    }
    get lenght() {
        let lengte = Math.sqrt(Math.pow(this._x, 2) + Math.pow(this._y, 2));
        return lengte;
    }
    toString() {
        console.log(`(${this._x},${this._y})`);
    }
}

try {
    let v = new Vec(1, 2);
    let c = new Vec(2, 1);
    console.log(v.plus(v, c));
    console.log(v.minus(v, c));
    console.log(v.lenght);
    v.toString();
}
catch (error) {
    console.log("Fout: " + error.message);
}


// LANGE VERSIE - MEER CODE --> VEEL DUIDELIJKER VOOR GEBRUIKER!

// if (typeof x !== 'number') {
//     throw new inputException("Parameter x moet een getal zijn!");
// }
// else if (typeof y !== 'number') {
//     throw new inputException("Parameter y moet een getal zijn!");
// }