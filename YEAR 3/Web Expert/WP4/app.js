const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const expressValidator = require('express-validator');
const Student = require("./models/student");
const Course = require("./models/Course");
const path = require('path');

const app = express();
const port = 3000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({limit: '5000mb', extended: true, parameterLimit: 100000000000}));
app.use(expressValidator())

const dbURI = 'mongodb+srv://hursittarcan:Hursit1999+@tarcanhursitweb.jqg3w.mongodb.net/web-expert?retryWrites=true&w=majority';
mongoose.connect(dbURI, { useNewUrlParser: true, useUnifiedTopology: true })
    .then((result) => app.listen(port, () => {
        console.log('Connected to database...');
        console.log(`Example app listening at http://localhost:${port}`);
    }))
    .catch((error) => console.log("An error occured."));

app.set("views", path.join(__dirname, "views"));
app.set("view engine", "pug");

app.use(express.static(path.join(__dirname, "public")));

const homeRouter = require('./routes/home');
app.use('/', homeRouter);

const scoreRouter = require('./routes/score');
app.use('/score', scoreRouter);

const courseScoreRouter = require('./routes/coursescore');
app.use('/coursescore', courseScoreRouter);

const listRouter = require('./routes/list');
app.use('/list', listRouter);

const updateRouter = require('./routes/update');
app.use('/update', updateRouter);

app.use((req, res, next) => {
    if (!req.route) {
        res.render('unknown');
    }
    next();
});