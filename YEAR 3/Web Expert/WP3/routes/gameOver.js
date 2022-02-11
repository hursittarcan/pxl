const express = require('express');
const router = express.Router();

const gameOverController = require('../controllers/gameOver')

router.get('/', gameOverController.gameOverPage);

module.exports = router;