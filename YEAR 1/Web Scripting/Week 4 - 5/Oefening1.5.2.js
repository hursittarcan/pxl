function funcbereken() {
    let num1, num2, result;
    num1 = Number(document.getElementById("text1").value);
    num2 = Number(document.getElementById("text2").value);
    result = num1 * num2;
    document.getElementById("output").innerText = result;
}