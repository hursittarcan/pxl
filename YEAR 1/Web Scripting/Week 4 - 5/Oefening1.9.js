function splitEmail() {
    let email = document.getElementById("email").value;
    let punt = email.indexOf(".");
    let punt2 = email.lastIndexOf(".");
    let at = email.indexOf("@");
    let naam = email.substring(0, punt);
    let naam2 = email.substring(punt + 1, at);
    let subdomein = email.substring(at + 1, punt2);
    let domein = email.substring(punt2 + 1);
    document.getElementById("naam").value = naam;
    document.getElementById("naam2").value = naam2;
    document.getElementById("subdomein").value = subdomein;
    document.getElementById("domein").value = domein;
}