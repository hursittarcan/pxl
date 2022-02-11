const assert = require("assert");
const {Schema} = require("express-validator/src/middlewares/schema");
let token;

function getData() {
    let p = sessionStorage.getItem("token");
    console.log(p);
}

function login() {
    try {
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const errorP = document.getElementById('tokenPar');

        fetch('http://localhost:3000/user/login', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username: username, password: password})
        })
            .then((res) => {
                if (res.status === 200) {
                    errorP.innerHTML = "";
                    return res.json();
                }
                else if (res.status === 400) {
                    errorP.innerHTML = "Wrong Credentials";
                }
                else {
                    //TODO Wrong Credentials Error Message
                    console.log('Error');
                }
            })
            .then((res) => {
                sessionStorage.setItem("token", res.token);
                sessionStorage.setItem("userId", res.user._id);
                //console.log(res.user._id);
                let role = res.user.roles[0];
                if (role === "admin") {
                    window.location = "admin.html";
                }
                else {
                    window.location = "users.html";
                }
            })
    } catch (err) {
        console.log(err);
    }
}

function addNewUser() {
    const username = document.getElementById('usernameNewUser').value;
    const password = document.getElementById('passwordNewUser').value;
    const errorP = document.getElementById('tokenPar');

    const myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');
    myHeaders.append('Accept', 'application/json, text/plain, */*');
    myHeaders.append('Authorization', "Bearer " + sessionStorage.getItem("token"));

    fetch('http://localhost:3000/user/add', {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify({username: username, password: password})
    })
        .then((res) => {
            if (res.status === 200) {
                document.getElementById('usernameNewUser').value = "";
                document.getElementById('passwordNewUser').value = "";
                errorP.innerHTML = "User Succesfully Added";
                return res.json();
            }
            else if (res.status === 401) {
                errorP.innerHTML = "Unauthorized";
            }
            else {
                errorP.innerHTML = "Please Provide A New User";
            }
        })
        .then((res) => {
            console.log(res);
            //p.innerHTML = res;
            //sessionStorage.setItem("token", res.token);
            //sessionStorage.setItem("userId", res.user._id);
            //console.log(res.user._id);
            //window.location = "admin.html";
        })
}

function addTask() {
    const task = document.getElementById('taskName').value;
    const errorP = document.getElementById('tokenPar2');

    const myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');
    myHeaders.append('Accept', 'application/json, text/plain, */*');
    myHeaders.append('Authorization', "Bearer " + sessionStorage.getItem("token"));

    fetch('http://localhost:3000/user/add-task', {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify({todo: task})
    })
        .then((res) => {
            if (res.status === 200) {
                document.getElementById('taskName').value = "";
                errorP.innerHTML = "Task Succesfully Added";
                return res.json();
            }
            else if (res.status === 401) {
                errorP.innerHTML = "Unauthorized";
            }
            else {
                errorP.innerHTML = "Please Provide A New Task";
            }
        })
        .then((res) => {
            console.log(res);
        })
}

function getAllTasks() {
    const myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');
    myHeaders.append('Accept', 'application/json, text/plain, */*');
    myHeaders.append('Authorization', "Bearer " + sessionStorage.getItem("token"));

    fetch('http://localhost:3000/user/get-all', {
        method: 'PATCH',
        headers: myHeaders
    })
        .then((res) => {
            if (res.status === 200) {
                return res.json();
            }
            else {
                //TODO Wrong Credentials Error Message
                console.log('Error patch');
            }
        })
        .then((res) => {
            console.log(res);
            //sessionStorage.setItem("token", res.token);
            //sessionStorage.setItem("userId", res.user._id);
            //console.log(res.user._id);
            //window.location = "admin.html";
        })
}

function updateUserTasks() {
    let completedOrNot = [];
    var checkboxes = document.querySelectorAll("input[type=checkbox][name=todo]");
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked === true) {
            completedOrNot.push(true);
        }
        else {
            completedOrNot.push(false);
        }
    }

    let tasks = sessionStorage.getItem("taskIds").split(',');
    for (let i = 0; i < tasks.length; i++) {
        let url = 'http://localhost:3000/user/' + sessionStorage.getItem("userId") + "/task/" + tasks[i];

        const myHeaders = new Headers();

        myHeaders.append('Content-Type', 'application/json');
        myHeaders.append('Accept', 'application/json, text/plain, */*');
        myHeaders.append('Authorization', "Bearer " + sessionStorage.getItem("token"));

        fetch(url, {
            method: 'PATCH',
            headers: myHeaders,
            body: JSON.stringify({ completed: completedOrNot[i] })
        })
            .then((res) => {
                if (res.status === 200) {
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
}

function test() {
    var checkboxes = document.querySelectorAll("input[type=checkbox][name=todo]");

    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            updateUserTasks();
        })
    });
}

function getUsersTasks() {
    let url = 'http://localhost:3000/user/' + sessionStorage.getItem("userId") + "/task";
    document.getElementById("cboxes").innerHTML = "";
    const myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');
    myHeaders.append('Accept', 'application/json, text/plain, */*');
    myHeaders.append('Authorization', "Bearer " + sessionStorage.getItem("token"));

    fetch( url, {
        method: 'GET',
        headers: myHeaders
    })
        .then((res) => {
            if (res.status === 200) {
                return res.json();
            }
            else {
                //TODO Wrong Credentials Error Message
                console.log('Error patch');
            }
        })
        .then((res) => {
            let taskIds = [];
            var myDiv = document.getElementById("cboxes");

            for (var i = 0; i < res.length; i++) {
                taskIds.push(res[i]._id);
                var label = document.createElement("label");
                var checkBox = document.createElement("input");
                checkBox.type = "checkbox";
                checkBox.checked = res[i].completed;
                checkBox.value = res[i].completed;
                checkBox.name = "todo";
                checkBox.onchange = test();
                myDiv.appendChild(label);
                myDiv.appendChild(checkBox);
                myDiv.appendChild(document.createElement("br"));
                label.appendChild(document.createTextNode(res[i].todo));
            }
            sessionStorage.setItem("taskIds", taskIds);
        })
}

function updateAllTodos() {
    let todos = [];
    var inputs = document.querySelectorAll("input[class=todoInp]");
    for (let i = 0; i < inputs.length; i++) {
        todos.push(inputs[i].value)
    }

    let tasks = sessionStorage.getItem("taskIdsAdmin").split(',');
    for (let i = 0; i < tasks.length; i++) {
        let url = 'http://localhost:3000/user/get-all/' + tasks[i];

        const myHeaders = new Headers();

        myHeaders.append('Content-Type', 'application/json');
        myHeaders.append('Accept', 'application/json, text/plain, */*');
        myHeaders.append('Authorization', "Bearer " + sessionStorage.getItem("token"));

        fetch(url, {
            method: 'PATCH',
            headers: myHeaders,
            body: JSON.stringify({ todo: document.querySelectorAll("input[class=todoInp]")[i].value })
        })
            .then((res) => {
                if (res.status === 200) {
                    return res.json();
                }
                else {
                    //TODO Wrong Credentials Error Message
                    console.log('Error patch');
                }
            })
            .then((res) => {
                //console.log(res);
            })
    }
}

function getAllTodos() {
    let url = 'http://localhost:3000/user/get-all-un';
    document.getElementById("cboxes2").innerHTML = "";
    const myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');
    myHeaders.append('Accept', 'application/json, text/plain, */*');
    myHeaders.append('Authorization', "Bearer " + sessionStorage.getItem("token"));

    fetch( url, {
        method: 'GET',
        headers: myHeaders
    })
        .then((res) => {
            if (res.status === 200) {
                return res.json();
            }
            else {
                //TODO Wrong Credentials Error Message
                console.log('Error patch');
            }
        })
        .then((res) => {
            let taskIds = [];

            var myDiv = document.getElementById("cboxes2");
            for (var i = 0; i < res.length; i++) {
                taskIds.push(res[i]._id);
                var inp = document.createElement("input");
                inp.value = res[i].todo;
                inp.className = "todoInp"
                myDiv.appendChild(inp);
                myDiv.appendChild(document.createElement("br"));
            }
            sessionStorage.setItem("taskIdsAdmin", taskIds);
        })
}

const breakfastSchema = new Schema({
    eggs: {
        type: Number,
        min: [6, 'Too few eggs'],
        max: 12
    },
    bacon: {
        type: Number,
        required: [true, 'Why no bacon?']
    },
    drink: {
        type: String,
        enum: ['Coffee', 'Tea'],
        required: function() {
            return this.bacon > 3;
        }
    }
});
const Breakfast = db.model('Breakfast', breakfastSchema);

const badBreakfast = new Breakfast({
    eggs: 2,
    bacon: 0,
    drink: 'Milk'
});
let error = badBreakfast.validateSync();
assert.equal(error.errors['eggs'].message,
    'Too few eggs');
assert.ok(!error.errors['bacon']);
assert.equal(error.errors['drink'].message,
    '`Milk` is not a valid enum value for path `drink`.');