let product = document.getElementById("product");
let aantal = document.getElementById("aantal");
let lijst = document.getElementById("lijst");

function voeProductToe() {
    let nieuwProduct = "Product: " + product.value + " Aantal: " + aantal.value;
    let lijstProduct = document.createElement("li");
    lijstProduct.innerHTML = nieuwProduct;
    lijst.appendChild(lijstProduct);
    product.value = "";
}

document.getElementById("submit").addEventListener("click", voeProductToe);
//Dit proberen te gebruiken! I.p.v. onclick in HTML!






