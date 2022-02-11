const Student = require("../models/student");

exports.listPage = function (req, res) {
    Student.find({}, {'name':1, 'courses.title':1, 'courses.score':1, '_id':0})
        .then((result) => res.render("list", {
            courses: result,
            url: req.originalUrl
        }))
        .catch((error) => console.log(error));
}

exports.listPageCheck = function (req, res) {
    let inp = req.body.toSearchInputList;

    req.check('toSearchInputList')
        .isNumeric().withMessage('Input moet een getal zijn!')
        .notEmpty().withMessage("Input kan niet leeg blijven!");

    var errors = req.validationErrors();
    if (errors) {
        req.body.errors = errors;
        res.render('error', {
            errors: errors
        })
    }

    Student.find({}, {'name':1, 'courses.title':1, 'courses.score':1, '_id':0})
        .then((result) => res.render("listfilter", {
            courses: result,
            url: req.originalUrl,
            maximumFail: parseInt(inp),
            title: 'List Page'
        }))
        .catch((error) => console.log(error));
}