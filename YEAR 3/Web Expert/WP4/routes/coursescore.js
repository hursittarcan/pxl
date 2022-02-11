const express = require('express');
const router = express.Router();

const scoreController = require('../controllers/score');

router.get('/', scoreController.courseScore);

router.post('/', scoreController.courseScorePage);

module.exports = router;