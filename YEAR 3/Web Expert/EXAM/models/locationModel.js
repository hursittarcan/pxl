const mongoose = require("mongoose");

const locationSchema = new mongoose.Schema({
        locationName: {
            type: String,
            trim: true,
            uppercase: true,
            required: [true, "Name is required"]
        },
        scores : [ { type: mongoose.Schema.Types.ObjectId, ref: "Score" } ],
        userId: { type: mongoose.Schema.Types.ObjectId, ref: "User" }
    }
    ,
    { collection: "locations" }
);

module.exports = mongoose.model("Location", locationSchema );