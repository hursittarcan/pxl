function funcbereken() {
    let num1, num2, result;
    num1 = Number(document.getElementById("text1").value);
    num2 = Number(document.getElementById("text2").value);
    result = num1 * num2;
    if (isNaN(result)) {
        result = "Geen geldige getallen!"
    }
    document.getElementById("result_form").value = result;
}

// let button = document.getElementById("calcbutton");
// button.addEventListener("click", bereken);
//
// function bereken() {};

