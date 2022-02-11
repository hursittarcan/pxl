let amountOfLocations;
let scoreToSend;

function getLocation(locationId, locationName) {
    sessionStorage.setItem("locationId", locationId);
    sessionStorage.setItem("locationName", locationName);
    window.location = "location.html";
}

function getAllLocations() {
    document.getElementById("cboxes").innerHTML = "";
    let url;
    let filterString = document.getElementById("findLocation");
    if (filterString.value.length > 0) {
        url = 'http://localhost:3000/location?search=' + filterString.value;
    }
    else {
        url = 'http://localhost:3000/location';
    }

    fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        }
    })
        .then((res) => {
            if (res.status === 200) {
                return res.json();
            } else {
                console.log('Error patch');
            }
        })
        .then((res) => {
            amountOfLocations = res.length;
            let locationIds = [];
            var myDiv = document.getElementById("cboxes");

            for (var i = 0; i < res.length; i++) {
                locationIds.push(res[i]._id);
                var button = document.createElement("button");
                button.value = res[i]._id;
                button.innerText = res[i].locationName;
                button.id = "button" + i;
                //button.onclick = getLocation;
                let locationId = res[i]._id;
                let locationName = res[i].locationName;
                button.addEventListener('click', function(){
                    getLocation(locationId, locationName);
                });
                myDiv.appendChild(button);
                myDiv.appendChild(document.createElement("br"));
            }
        })
}

function addNewScore(scoreToAdd) {
    let url = 'http://localhost:3000/location/' + sessionStorage.getItem("locationId") + '/scores';

    fetch(url, {
        method: 'PATCH',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ score: scoreToAdd })
    })
        .then((res) => {
            if (res.status === 200) {
                console.log("score added.")
                return res.json();
            }
            else {
                //TODO Wrong Credentials Error Message
                console.log('Error patch');
            }
        })
        .then((res) => {
            console.log(res);
        })
}

function reply_click(clicked_id)
{
    scoreToSend = parseInt(clicked_id);
    addNewScore(scoreToSend);
}