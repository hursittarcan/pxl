const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const courseSchema = new Schema({
        title: {
            type: String,
            minLength: 3,
            trim: true,
            lowercase: true,
            validate: {
                validator: (value) => /^[a-z ]+$/.test(value),
                message: (props) => `${props.value} is not a valid course title`
            },
            required: [true, "Course title is required"]
        },
        teacher: {
            type: String,
            minLength: 3,
            trim: true,
            lowercase: true,
            validate: {
                validator: (value) => /^[a-z ]+$/.test(value),
                message: (props) => `${props.value} is not a valid teacher name`
            },
            required: [true, "teacher is required"]
        },
        //student: {type: mongoose.Schema.Types.ObjectId, ref: "Student"},
        score: Number
    },
    {collection: "courses"});

const Course = mongoose.model('Course', courseSchema);
module.exports = Course;