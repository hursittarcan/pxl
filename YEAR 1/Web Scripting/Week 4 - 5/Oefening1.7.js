function berekenOnevenGetallen() {
    let maxGetal = document.getElementById("getal1").value;
    let totaal = "";
    for (let i = 0; i <= maxGetal; i ++) {
        if (i % 2 === 1) {
            totaal += i + " ";
        }
        if (maxGetal > 50) {
            totaal = "Getal is te groot!";
        }
    }
    document.getElementById("result").value = totaal;
}


