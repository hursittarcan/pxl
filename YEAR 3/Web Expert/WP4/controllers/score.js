const Student = require("../models/student");

exports.scorePage = function (req, res) {
    Student.find({}, {'name':1, 'courses.title':1, '_id':0})
        .then((result) => res.render("score", {
            list: result,
            url: req.originalUrl
        }))
        .catch((error) => console.log(error));
}

exports.scorePageStudent = function (req, res) {
    let inp = req.body.toSearchInput;

    req.check('toSearchInput')
        .isAlpha().withMessage('Input moet een naam zijn!')
        .notEmpty().withMessage("Input kan niet leeg blijven!");

    var errors = req.validationErrors();
    if (errors) {
        req.body.errors = errors;
        res.render('error', {
            errors: errors
        })
    }

    var name = inp.toString();
    Student.findOne({name: new RegExp('^'+name+'$', "i")})
        .then((result) => res.render("studentscore", {
            title: result.name,
            studentId: result.studentId,
            courses: result.courses,
            url: req.originalUrl
        }))
        .catch((error) => console.log(error));
}

exports.courseScore = function (req, res) {
    Student.find({}, {'courses.title':1, '_id':0})
        .then((result) => res.render("coursescore", {
            list: result,
            url: req.originalUrl
        }))
        .catch((error) => console.log(error));
}

exports.courseScorePage = function (req, res) {
    let inp = req.body.toSearchInputCourse;

    req.check('toSearchInputCourse')
        .isAlpha().withMessage('Input moet een vak zijn!')
        .notEmpty().withMessage("Input kan niet leeg blijven!");

    var errors = req.validationErrors();
    if (errors) {
        req.body.errors = errors;
        res.render('error', {
            errors: errors
        })
    }

    var name = inp.toString();
    Student.findOne({'courses.title': new RegExp('^'+name+'$', "i")})
        .then((result) => res.render("coursescores", {
            title: name,
            names: result,
            url: req.originalUrl
        }))
        .catch((error) => console.log(error));
}