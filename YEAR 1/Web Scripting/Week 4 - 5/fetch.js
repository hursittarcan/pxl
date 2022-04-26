let url = "http://localhost:3000/persons";

fetch(url).then(function (response) {
        return response.json();
    },
    function (error) {
        alert(error)
    }
).then(
    function (persons) {
        let article = document.getElementById("users");
        for (let person of persons) {
            let par = document.createElement("p");
            par.textContent = person.id + " " + person.name;
            article.appendChild(par);
        }
    }
);

