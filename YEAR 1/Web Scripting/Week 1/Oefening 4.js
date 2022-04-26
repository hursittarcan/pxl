let ondergrens = 1;
let bovengrens = 100;
let som = 0;

for (let getal = ondergrens; getal <= bovengrens; getal ++) {
    if (getal % 3 === 0) {
        som += getal;
    }
}
console.log(som);