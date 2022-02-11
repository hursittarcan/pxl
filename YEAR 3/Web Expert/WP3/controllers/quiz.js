const quizQuestions = require('../config.json');

const questionsArray = [];
const answersArray = [];
const requiredAnswersArray = [];

quizQuestions.forEach(function (quizQuestion) {
    let question = quizQuestion.question;
    questionsArray.push(question);

    let answers = quizQuestion.answers;
    answersArray.push(answers);

    let requiredAnswer = quizQuestion.requiredAnswers;
    requiredAnswersArray.push(requiredAnswer);
})

function numberToArray(requiredAnswerArr) {
    let arrayToReturn = [];
    for (let step = 1; step <= requiredAnswerArr; step++) {
        arrayToReturn.push(step);
    }
    return arrayToReturn;
}

let totalScore = 0;

exports.quiz = function (req, res) {
    let id = (req.params.id) - 1;
    res.cookie('scorePreviousGame', totalScore);
    res.render("quiz", {
        question: questionsArray[id],
        answer: answersArray[id],
        requiredAnswer: numberToArray(requiredAnswersArray[id]),
        url: req.originalUrl
    });
}

exports.checkPost = function (req, res, next) {
    let id = (req.params.id) - 1;
    answers = answersArray[id];

    let score = 0;
    let totaal = requiredAnswersArray[id];

    if (requiredAnswersArray[id] === 1) {
        req.check('inp1')
            .isAlpha().withMessage('Input 1 moet een woord zijn!')
            .notEmpty().withMessage('Input 1 mag niet leeg blijven!');
    }
    else if (requiredAnswersArray[id] === 2) {
        req.check('inp1')
            .isAlpha().withMessage('Input 1 moet een woord zijn!')
            .notEmpty().withMessage('Input 1 mag niet leeg blijven!');

        req.check('inp2')
            .isAlpha().withMessage('Input 2 moet een woord zijn!')
            .notEmpty().withMessage('Input 2 mag niet leeg blijven!');
    }
    else {
        req.check('inp1')
            .isAlpha().withMessage('Input 1 moet een woord zijn!')
            .notEmpty().withMessage('Input 1 mag niet leeg blijven!');

        req.check('inp2')
            .isAlpha().withMessage('Input 2 moet een woord zijn!')
            .notEmpty().withMessage('Input 2 mag niet leeg blijven!');

        req.check('inp3')
            .isAlpha().withMessage('Input 3 moet een woord zijn!')
            .notEmpty().withMessage('Input 3 mag niet leeg blijven!');
    }

    var errors = req.validationErrors();
    if (errors) {
        req.body.errors = errors;
        res.render('error', {
            errors: errors
        })
    }
    let answerOneTrue = false;
    let answerTwoTrue = false;
    let answerThreeTrue = false;

    let answer = req.body.inp1;
    if (answers.includes(answer)) {
        answerOneTrue = true;
        score += 1;
    }
    let answerTwo = req.body.inp2;
    if (answers.includes(answerTwo)) {
        answerTwoTrue = true;
        score += 1;
    }
    let answerThree = req.body.inp3;
    if (answers.includes(answerThree)) {
        answerThreeTrue = true;
        score += 1;
    }

    if (score === totaal) {
        totalScore += 1;
    }

    let lastQuestion = false;
    if (id === questionsArray.length - 1) {
        lastQuestion = true;
    }

    res.render("answer", {
        answer: answer,
        answerTwo: answerTwo,
        answerThree: answerThree,
        extra: answers,
        answerOneRight: answerOneTrue,
        answerTwoRight: answerTwoTrue,
        answerThreeRight: answerThreeTrue,
        score: score,
        totaal: totaal,
        totalScore: totalScore,
        totalScoreMax: questionsArray.length,
        prevId: id,
        lastQuestion: lastQuestion
    });
}