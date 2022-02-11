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
    score: Number,
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
    }
});

const studentSchema = new Schema({
        name: {
            type: String,
            minLength: 3,
            trim: true,
            lowercase: true,
            validate: {
                validator: (value) => /^[a-z ]+$/.test(value),
                message: (props) => `${props.value} is not a valid name!`
            },
            required: [true, "Name is required"]
        },
        studentId: Number,
        courses: [courseSchema]
    },
    {collection: "students"});

const Student = mongoose.model('Student', studentSchema);
module.exports = Student;