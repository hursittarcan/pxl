function berekenNaam() {
    let naam1, naam2, result;
    naam1 = document.getElementById("naam1").value;
    naam2 = document.getElementById("naam2").value;
    result = "Welkom, " + naam1 + " " + naam2 + ".";
    if (naam2 === "" || naam1 === "") {
        result = "Beide velden ingeven";
    }
    document.getElementById("result").value = result;
}