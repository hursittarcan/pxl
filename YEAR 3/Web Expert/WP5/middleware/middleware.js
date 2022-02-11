const createError = require("http-errors");
const mongoose = require("mongoose");

function routeNotFound(req, res, next) {
    if(!req.route){
        return next(createError(501, 'Route not found'));
    }
    next();
}

function connectionLost(req, res, next) {
    if(mongoose.connection.readyState == 0){
        next(createError(500, 'connection lost'));
    }
    next();
}


module.exports = { routeNotFound,connectionLost };
