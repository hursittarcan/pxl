function minimum(...getallen) {
    let kleinsteGetal = getallen[0];
    for (let i = 1; i <= getallen.length; i ++) {
        if (getallen[i] < kleinsteGetal) {
            kleinsteGetal = getallen[i];
        }
    }
    return kleinsteGetal;
}

console.log(minimum(75, 7, -5, -8000, 4, 1));