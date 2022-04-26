//NIET VOLLEDIG OK!

function wijzigBord1(kol, rij) {
    if (speelBord[kol - 2]) {
        if (speelBord[kol[rij - 2] - 1][rij - 1] === "X") {
            speelBord[kol - 1][rij - 1] = "1";
        }
    }
}

function wijzigBord2(kol, rij) {
    if (speelBord[kol - 2][rij - 2] !== "X") {
        if (speelBord[kol - 1][rij - 1] === "X") {
            speelBord[kol - 1][rij - 1] = "2";
        }
    }
}

let speelBord = [];
    for (let kol = 0; kol < 7; kol ++) {
        speelBord.push([]);
        for (let rij = 0; rij < 6; rij ++) {
            speelBord[kol].push("X");
    }
}

wijzigBord1(3, 4);
wijzigBord2(1, 1);
wijzigBord1(1, 2);
wijzigBord2(2, 5);

console.log(speelBord.reverse());

