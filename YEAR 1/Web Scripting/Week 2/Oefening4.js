function telB(woord) {
    let aantalB = 0;
    for (let letter of woord) {
        if (letter === "B") {  //Enkel grote B!
            aantalB += 1;
        }
    }
    return aantalB;
}

console.log(telB("haBlloB"));

//--------------------------------------------------

function telChar(woord, symbool) {
    let aantalSymbool = 0;
    for (let symb of woord) {
        if (symb === symbool) {
            aantalSymbool += 1;
        }
    }
    return aantalSymbool;
}

console.log(telChar("Hu-rsit-", "-"));