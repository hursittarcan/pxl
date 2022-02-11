const mongoose = require("mongoose");
const bcrypt = require('bcryptjs');

const userSchema = new mongoose.Schema({
        username: {
            type: String,
            required: true,
            unique: true,
            trim: true,
            lowercase: true,
            minLength:2,
            maxLength:20,
            validate: {
                validator: function(value) {
                    return /^[a-z0-9_]+$/.test(value);
                },
                message: (props) => `${props.value} is not a valid username.`
            }
        },
        roles: {
            type: [ String ],
            default: [ "admin" ]
        },
        hashedPassword: {
            type: String,
            required: true
        },
        taskIds : [ { type: mongoose.Schema.Types.ObjectId, ref: "Task" } ]
    },
    { collection: "users" }
);

userSchema
    .virtual("password")
    .set(function (password) {
        password=password.trim();
        if( password.length <= 6){
            this.invalidate("password", "must be at least 6 characters.");
        }
        if( password.length >= 20){
            this.invalidate("password", "must be shorter than 20 characters.");
        }
        const hashedPassword = bcrypt.hashSync(password, 8);
        this.hashedPassword = hashedPassword;
    });

userSchema.statics.findOneByCredentials = async function (username, password){
    const user = await this.findOne({ username });
    if( !user ){
        return null;
    }
    let passwordIsCorrect = await bcrypt.compare(password, user.hashedPassword);
    if( !passwordIsCorrect ){
        return null;
    }
    return user
}

module.exports = mongoose.model("User", userSchema );

