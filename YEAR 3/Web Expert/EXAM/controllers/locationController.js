const Location = require("../models/locationModel");
const locationService = require("../services/locationService");
const Score = require("../models/scoreModel");
const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;

//Deze functie wordt gebruikt bij het krijgen van alle locaties door een anonieme gebruiker (+filter). (Examen deel 1.A)
module.exports.getAllLocations = async function(req, res, next) {
    try {
        const status = 200;
        let locations;
        if (Object.keys(req.query).length !== 0) {
            let toFind = req.query.search;
            locations = await locationService.getAllLocationsFilter(toFind);
            res.status(status).json(locations);
        }
        else {
            locations = await locationService.getAllLocations();
            res.status(status).json(locations);
        }
    }
    catch (err) {
        next(err);
    }
};

module.exports.findScoresOfLocation = async function(req, res, next) {
    const location = await Location.findById(new ObjectId(String(req.params.locationId)));
    if (location == null){
        return null;
    }
    const scoreIds = location.scores;
    const score = await Score.find()
        .where("_id").in(scoreIds)
        .exec();

    res.status(200).json(score);
};

//Deze functie wordt gebruikt om een nieuwe score toe te voegen aan een gekozen lokaal. (Examen deel 1.A)
module.exports.addScore = async function(req, res, next) {
    const location = await Location.findById(new ObjectId(String(req.params.locationId)));
    try{
        const status = 200;
        const score = req.body.score;
        let result = await locationService.addNewScoreToLocation(location, score);
        console.log(result);
        res.status(status).json(result);
    } catch(err){
        next(err);
    }
};
