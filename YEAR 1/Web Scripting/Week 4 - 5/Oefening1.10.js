function geefDag() {
    let ingave = document.getElementById("inp").value.toLowerCase();
    let dagNummer;
    switch (ingave) {
        case "maandag":
            dagNummer = "eerste";
            break;
        case "dinsdag":
            dagNummer = "tweede";
            break;
        case "woensdag":
            dagNummer = "derde";
            break;
        case "donderdag":
            dagNummer = "vierde";
            break;
        case "vrijdag":
            dagNummer = "vijfde";
            break;
        case "zaterdag":
            dagNummer = "zesde";
            break;
        case "zondag":
            dagNummer = "laatste";
            break;
        default:
            dagNummer = "onbestaande";
            break;
    }
    document.getElementById("output").innerHTML = "Vandaag is de " + dagNummer + " dag van de week.";
}