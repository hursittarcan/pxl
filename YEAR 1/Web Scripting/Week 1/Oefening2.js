let minimum = 1;
let maximum = 100;

for (let getal = minimum; getal <= maximum; getal ++) {
    if ((getal % 3 === 0) && (getal % 5 !== 0)) {
        console.log("Fizz");
    }
    else if ((getal % 3 !== 0) && (getal % 5 === 0)) {
        console.log("Buzz");
    }
    else if ((getal % 3 === 0) && (getal % 5 === 0)) {
        console.log("FizzBuzz")
    }
    else {
        console.log(getal)
    }
}