const createError = require("http-errors");
const mongoose = require("mongoose");
let {MongoServerError} = require("mongodb");

function errorHandler(err, req, res, next) {
    let status = err.status || 500;
    let message = err.message || "Something went wrong"
    if(mongoose.connection.readyState == 0){
        status = 500;
        message = "Cannot connect to database";  
    }
    else if(err instanceof mongoose.Error.ValidationError){
        status = 400;
        message = `Validation failed: ${err.message}`;
    }
    else if(err instanceof TypeError){
        status = 400;
        message = `${err.message}`;
    }
    else if(err instanceof MongoServerError){
        status = 409;
        message = `Duplicate key: ${err.message}`;
    }
    res.status(status).json( {"error":message} );
};

module.exports = { errorHandler };
