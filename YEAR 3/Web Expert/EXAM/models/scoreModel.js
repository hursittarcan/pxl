const mongoose = require("mongoose");

const scoreSchema = new mongoose.Schema({
        score: {
            type: Number,
            min: [0, "The minimum is 0"],
            max: [3, "The maximum is 3"],
            required: [true, "Score is required"]
        },
        locationId : { type: mongoose.Schema.Types.ObjectId, ref: "Location" }
    }
    ,
    { collection: "scores", timestamps: true },
);

module.exports = mongoose.model("Score", scoreSchema );