function berekenAfstand(punt1, punt2) {
    let afstand;
    afstand = Math.sqrt(((punt1.x - punt2.x) ** 2) + ((punt1.y - punt2.y) ** 2));
    return afstand;
}

let punt1 = {x: 1, y: 1};
let punt2 = {x: 2, y: 3};
let afstand = berekenAfstand(punt1, punt2);
console.log(afstand);