let aantalLijnen = 7;

for (let number = aantalLijnen; number >= 0; number --) {
    console.log(" ".repeat(number) + "#".repeat(aantalLijnen - number))
}