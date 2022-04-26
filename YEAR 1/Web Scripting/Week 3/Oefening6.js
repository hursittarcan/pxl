class inputException extends Error {}

class PolyLine {
    constructor(vecs) {
        this._vecs = [];
    }

    addVec(vec) {
        if (typeof vec !== 'object') {
            throw new inputException("Parameter moet vec-object zijn!");
        }
        this._vecs.push(vec);
    }

    toString() {
        let stringTotaal = "";
        for (let vec = 0; vec < this._vecs.length; vec ++) {
            stringTotaal += `(${this._vecs[vec]._x},${this._vecs[vec]._y})`;
        }
        return stringTotaal;
    }
}

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
    let p = new PolyLine();
    p.addVec(v);
    p.addVec(c);
    console.log("---------------");
    console.log(p.toString());
}
catch (error) {
    console.log("Fout: " + error.message);
}