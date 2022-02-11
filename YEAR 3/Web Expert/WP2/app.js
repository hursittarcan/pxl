const fs = require('fs');
const configuredRoutes = require('./config.json');
const express = require('express');
const bodyParser = require('body-parser');
const createError = require('http-errors')
const app = express();
const port = 3000;

app.use(bodyParser.json());

app.listen(port, () => {
    console.log(`Listening at http://localhost:${port}`)
})

//Uitlezen van de config.json...
configuredRoutes.forEach(function (configuredRoute, index){
    let route = configuredRoute.route;
    let fields = configuredRoute.fields;
    let validation = configuredRoute.validation;
    let data = configuredRoute.data;

    //GET /route_i
    //Geeft een array van alle objecten voor route_i terug
    app.get(`${route}`, (req, res, next) => {
        res.status(200);
        res.json(data);
        next();
    })

    //GET /route_i/2
    //Geeft het object met id=2 voor route_i terug
    app.get(`${route}/:id([0-9]+)`, (req, res, next) => {
        let id = data[req.params.id - 1];
        res.status(200);
        res.json(id);
        next();
    })

    //DELETE /route_i/2
    //Verwijdert het element met id=2 uit route_i
    app.delete(`${route}/:id([0-9]+)`, (req, res, next) => {
        let ids = [];
        for (let i = 0; i < data.length; i++) {
            if (!ids.includes(data[i].id)) {
                ids.push((data[i].id));
            }
        }

        let id = req.params.id;
        if (ids.includes(parseInt(id))) {
            data.splice((id - 1), 1);
            res.status(200);
            res.json(`Object with id: ${id} has been removed.`);
            next();
        } else {
            res.status(400);
            res.send(`ERROR, id: ${id} does not exist!`);
            return next(createError('404', 'The given ID does not exist!'));
        }
    })

    //POST Request nog afwerken - Validatie Toevoegen!
    //Valideert alle velden die in de request-body staan en maakt een nieuw object aan voor route_i
    app.post(`${route}`, function (req, res, next) {
        let ids = [];
        for (let i = 0; i < data.length; i++) {
            if (!ids.includes(data[i].id)) {
                ids.push((data[i].id));
            }
        }
        let id = req.body.id;
        if (!ids.includes(parseInt(id))) {
            res.status(201);
            res.send(req.body);
            data.push(req.body);
            next();
        }
        else {
            res.status(400);
            res.send("ID already exists! Please pick a different ID and try again");
            return next(createError('400', 'The given ID already exists!'));
        }
    })

    //Errohandling bij onbekende routes, maar herkent /pet niet als route!
    app.use((req, res, next) => {
        if (!req.route) {
            res.status(404);
            res.send("This Page does not exist!");
            next(createError(404, 'Route not found'));
        }
        next();
    })
});

//Updaten van de gegevens in config.json...
process.on('SIGINT', function () {
    fs.writeFileSync('./config.json', JSON.stringify(configuredRoutes));
    console.log("Config.json updated!");
    process.exit();
})