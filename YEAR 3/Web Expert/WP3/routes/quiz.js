const express = require('express');
const router = express.Router();

const quizController = require('../controllers/quiz')

router.get('/', quizController.quiz);

router.get('/:id([0-9]+)', quizController.quiz);

router.post('/:id([0-9]+)', quizController.checkPost);

module.exports = router;