const express = require('express');
const dotenv=require("dotenv");
dotenv.config();
const path = require("path");
const cors = require("cors");
const createError = require("http-errors");
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const Task = require("./models/taskModel");
const User = require("./models/userModel");
const expressValidator = require('express-validator');

const userRouter = require("./routes/user");
const { errorHandler } = require("./middleware/errorHandler");
const { routeNotFound, connectionLost } = require("./middleware/middleware");
// const corsOptions = {
//     origin: "http://localhost:8080"
// }

const app = express();
const port = 3000;

app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "http://localhost:63342");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
    res.header("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS, PUT, DELETE, PATCH")
    next();
});
//app.use("*", cors(corsOptions));
// app.use(cors({
//     origin: "*",
// }));
app.use(connectionLost)
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({limit: '5000mb', extended: true, parameterLimit: 100000000000}));
//app.use(expressValidator())
app.use("/user", userRouter);
app.use(routeNotFound);
app.use(errorHandler);

const dbURI = 'mongodb+srv://hursittarcan:Hursit1999+@tarcanhursitweb.jqg3w.mongodb.net/web-expert?retryWrites=true&w=majority';
mongoose.connect(dbURI, { useNewUrlParser: true, useUnifiedTopology: true })
    .then((result) => app.listen(port, () => {
        console.log('Connected to database...');
        console.log(`Example app listening at http://localhost:${port}`);
    }))
    .catch((error) => console.log("An error occured."));
