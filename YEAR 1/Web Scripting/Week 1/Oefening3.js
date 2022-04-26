let grootte = 8;

for (let number = 1; number <= grootte; number ++) {
    if (number % 2 === 0) {
        if (grootte % 2 !== 0) {
            console.log(" #".repeat(grootte / 2) + " ")
        }
        else {
            console.log(" #".repeat(grootte / 2))
        }
    }
    else {
        if (grootte % 2 !== 0) {
            console.log("# ".repeat(grootte / 2) + "#")
        }
        else {
            console.log("# ".repeat(grootte / 2))
        }
    }
}