const mongoose = require('mongoose');
const User = require('../models/userModel.js');
const Location = require('../models/locationModel')
const ObjectId = mongoose.Types.ObjectId;

module.exports.findUserByCredentials = async function(username, password) {
    return await User.findOneByCredentials(username, password);
}

module.exports.findLocationsOfManager = async function(id) {
    const user = await User.findById(new ObjectId(String(id)));
    if (user == null){
        return null;
    }

    let locations = user.locationIds;
    let locationsFull = [];
    for (let i = 0; i < locations.length; i++) {
        let loc = await Location.findById(new ObjectId(String(locations[i])))
        locationsFull.push(loc);
    }
    return locationsFull;
};

