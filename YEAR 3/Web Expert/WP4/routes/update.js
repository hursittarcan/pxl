const express = require('express');
const router = express.Router();

const updateController = require('../controllers/update');

router.get('/', updateController.updatePage);

router.post('/', updateController.updatePageCheck);

module.exports = router;