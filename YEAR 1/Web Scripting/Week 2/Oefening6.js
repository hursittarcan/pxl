function reverseArray(array) {
    let reverseGetallen = [];
    for (let getal = array.length - 1; getal >= 0; getal --) {
        reverseGetallen.push(array[getal])
    }
    return reverseGetallen;
}

let a = [1, 2, 8];
let b = reverseArray(a);
console.log(b);
