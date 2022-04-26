let aantalLijnen = 7;

for (let number = 1; number <= aantalLijnen; number ++) {
    let spaties = " ".repeat(aantalLijnen - number);
    let haakjes = "#".repeat(number * 2 - 1);
    console.log(spaties + haakjes)
}