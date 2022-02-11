const express = require('express');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser')
const expressValidator = require('express-validator');
const path = require('path');

const app = express();
const port = 3000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({limit: '5000mb', extended: true, parameterLimit: 100000000000}));
app.use(expressValidator())
app.use(cookieParser())

app.set("views", path.join(__dirname, "views"));
app.set("view engine", "pug");

app.use(express.static(path.join(__dirname, "public")));

const homeRouter = require('./routes/home');
app.use('/', homeRouter);

const gameOverRouter = require('./routes/gameOver');
app.use('/gameOver', gameOverRouter);

const quizRouter = require('./routes/quiz');
app.use('/quiz', quizRouter);

app.use((req, res, next) => {
    if (!req.route) {
        res.render('unknown');
    }
    next();
})

app.get('/image', (req, res) => {
    res.send("<img src='/images/quiz.png'>");
});

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`);
});


