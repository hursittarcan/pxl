function tekenPyramide() {
    let aantalLijnen = document.getElementById("get1").value;
    let totaalString = "";
    for (let number = 0; number <= aantalLijnen; number ++) {
        totaalString += "*".repeat(number) + "\n";
        document.getElementById("output").innerText = totaalString;
    }
}

