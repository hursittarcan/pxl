const Location = require("../models/locationModel");
const Score = require("../models/scoreModel");

exports.addNewScoreToLocation = async function(location, score) {
    if (score < 0 || score > 3) {
        return "Score has to be minimum 0 and maximum 3!";
    }
    else {
        const newScore = new Score( {score: score, locationId: location });
        newScore.save();
        location.scores.push(newScore);
        location.save();
        return "Score added to location!";
    }
};

module.exports.getAllLocations = async function() {
    return Location.find({});
};

module.exports.getAllLocationsFilter = async function(filter) {
    return Location.find({locationName: {$regex: filter}});
};
