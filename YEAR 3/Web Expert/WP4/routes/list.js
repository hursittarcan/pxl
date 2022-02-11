const express = require('express');
const router = express.Router();

const listController = require('../controllers/list');

router.get('/', listController.listPage);

router.post('/', listController.listPageCheck);

module.exports = router;