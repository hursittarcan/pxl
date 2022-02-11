const Location = require("../models/locationModel");
const Score = require("../models/scoreModel");
const User = require("../models/userModel");
const jwt = require("jsonwebtoken");
const dotenv=require("dotenv");
const mongoose = require('mongoose');
const SECRET = process.env.SECRET;
const JWT_EXPIRATION = process.env.JWT_EXPIRATION;
const managerService = require("../services/managerService");
const ObjectId = mongoose.Types.ObjectId;

module.exports.login = async function(req, res, next) {
    try{
        const status = 200;
        const username = req.body.username;
        const password = req.body.password;
        let user = await managerService.findUserByCredentials(username, password);
        const token = jwt.sign(
            { _id : user._id, roles: user.roles }
            , SECRET
            , {expiresIn: JWT_EXPIRATION, algorithm: "HS256" }
        );
        user = {
            _id: user._id,
            username: user.username,
            roles: user.roles,
            locations: user.locationIds
        };
        res.status(status).json({user,token});
    }
    catch(err){
        next(err);
    }
};

module.exports.getAllLocationsOfManager = async function(req, res, next) {
    const status = 200;
    const id = req.params.managerId;
    const locations = await managerService.findLocationsOfManager(id);
    res.status(status).json(locations);
};

module.exports.getScoresFromLocation = async function(req, res, next) {
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

module.exports.getProblemLocations = async function(req, res, next) {
    const status = 200;
    const id = req.params.managerId;
    const locations = await Score.find({
        timestamp: {
            $gte: new Date(new Date() - 7 * 60 * 60 * 24 * 1000)
        }
    });

    let goodLocationsScores = [];
    let problemLocationsScores = [];
    for (let i = 0; i < locations.length; i++) {
        if (locations[i].score < 2) {
            problemLocationsScores.push(locations[i]);
        }
        else {
            goodLocationsScores.push(locations[i])
        }
    }

    let goodLocations = [];
    let problemLocations = [];
    for (let i = 0; i < problemLocationsScores.length; i++) {
        problemLocations.push(problemLocationsScores[i].locationId);
    }
    for (let i = 0; i < goodLocationsScores.length; i++) {
        goodLocations.push(goodLocationsScores[i].locationId);
    }

    res.status(status).json(problemLocations);
};



