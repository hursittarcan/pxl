function maakRij(min, max) {
    let nummers = [];
    for (let x = min; x <= max; x ++) {
        if (x > -1) {
            nummers.push(x);
        }
    }
    return nummers;
}

console.log(maakRij(-4, 11));

//----------------------------------------

function maakRij2(min, max, optioneel = 1) {
    let nummers = [];
    for (let x = min; x <= max; x += Math.abs(optioneel)) {
        if (x > -1) {
            nummers.push(x);
        }
    }
    if (optioneel < 0) {
        nummers = nummers.reverse();
    }
    return nummers;
}

console.log(maakRij2(4, 11, -2));