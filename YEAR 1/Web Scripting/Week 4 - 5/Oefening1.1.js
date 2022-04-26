let MOUNTAINS = [
    {name: "Naam", height: "Hoogte", place: "Plaats"},
    {name: "Kilimanjaro", height: 5895, place: "Tanzania"},
    {name: "Everest", height: 8848, place: "Nepal"},
    {name: "Mount Fuji", height: 3776, place: "Japan"},
    {name: "Vaalserberg", height: 323, place: "Netherlands"},
    {name: "Denali", height: 6168, place: "United States"},
    {name: "Popocatepetl", height: 5465, place: "Mexico"},
    {name: "Mont Blanc", height: 4808, place: "Italy/France"}
];

let table = document.createElement('table');
document.body.appendChild(table);
for (let h = 0; h < 3; h ++) {
    let head = document.createElement('th');
    table.appendChild(head);
    let keys0 = Object.keys(MOUNTAINS[0]);
    let titel = document.createTextNode(MOUNTAINS[0][keys0[h]]);
    head.append(titel);
}

for (let i = 1; i < MOUNTAINS.length; i ++) {
    let row = document.createElement('tr');
    table.appendChild(row);
    table.style.border = "solid black";

    for (let j = 0; j < 3; j ++) {
        let cell = document.createElement('td');
        row.appendChild(cell);

        let keys = Object.keys(MOUNTAINS[i]);
        let text = document.createTextNode(MOUNTAINS[i][keys[j]]);
        cell.append(text);
        cell.style.border = "solid black";

        if (keys[j] === 'height') {
            cell.style.textAlign = "right";
        }
    }
}

