const mongoose = require('mongoose');
const Location = require("../models/locationModel");
const Score = require("../models/scoreModel");
const User = require("../models/userModel");

async function run() {
    try{
        const dbURI = 'mongodb+srv://hursittarcan:Hursit1999+@tarcanhursitweb.jqg3w.mongodb.net/web-expert?retryWrites=true&w=majority';
        mongoose.connect(dbURI, { useNewUrlParser: true, useUnifiedTopology: true });
        await Location.deleteMany({});
        await User.deleteMany({});
        await Score.deleteMany({});
        await Location.init();
        await User.init();
        let location1 = new Location({locationName:"EB101", });
        location1 = await location1.save();
        let location2 = new Location({locationName:"EB205", });
        location2 = await location2.save();
        let location3 = new Location({locationName:"EB313", });
        location3 = await location3.save();

        let user1 = new User({username: "root", password:"root123321", roles:["admin"]});
        user1 = await user1.save();
        user1.locationIds.push(location1._id);
        user1.locationIds.push(location2._id);
        user1 = await user1.save();
        location1.userId=user1._id;
        location2.userId=user1._id;
        location1.save();
        location2.save();

        let score1 = new Score( {score: 1 });
        let score2 = new Score( {score: 2 });
        let score3 = new Score( {score: 3 });
        let score4 = new Score( {score: 0 });
        score1.save();
        score2.save();
        score3.save();
        score4.save();

        score1.locationId=location1._id;
        score2.locationId=location1._id;
        score3.locationId=location1._id;
        score4.locationId=location2._id;
        score1.save();
        score2.save();
        score3.save();
        score4.save();

        location1.scores.push(score1);
        location1.scores.push(score2);
        location1.scores.push(score3);
        location2.scores.push(score4);
        location1.save();
        location2.save();

        let users = await User.find({});
        console.log("users");
        console.log(users);
        let locations = await Location.find({});
        console.log("locations");
        console.log(locations);
    } catch(error){
        console.log(error.message);
    } finally {
        await mongoose.connection.close();
    }
}

run();