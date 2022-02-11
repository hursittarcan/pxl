const express = require('express');
const router = express.Router();

const scoreController = require('../controllers/score');

router.get('/', scoreController.scorePage);

router.post('/', scoreController.scorePageStudent);

module.exports = router;