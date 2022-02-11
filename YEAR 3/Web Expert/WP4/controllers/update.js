const Student = require("../models/student");

exports.updatePage = function (req, res) {
    Student.find({}, {'name':1, 'courses.title':1, '_id':0})
        .then((result) => res.render("update", {
            list: result,
            url: req.originalUrl
        }))
        .catch((error) => console.log(error));
}

exports.updatePageCheck = function (req, res) {
    let inp = req.body.toUpdateInput;

    req.check('toUpdateInput')
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
    Student.findOneAndUpdate({name: new RegExp('^'+name+'$', "i")}, {'name': "Update"})
        .then((result) => res.render("updateCheck", {
            title: result.name,
            studentId: result.studentId,
            url: req.originalUrl
        }))
        .catch((error) => console.log(error));
}