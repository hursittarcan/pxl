let aantalLijnen = 7;
teller = 0;

for (let number = 0; number < aantalLijnen; number ++) {
    let pyramide = "";
    for (let number2 = 1; number2 < aantalLijnen - number; number2 ++) {
        pyramide += " ";
    }
    for (let haakje = 1; haakje <= (2 * number + 1); haakje ++) {
        teller ++;
        if (teller % 5 === 1) {
            pyramide += "@"
        }
        else {
            pyramide += "#";
        }
    }
    console.log(pyramide);
}

