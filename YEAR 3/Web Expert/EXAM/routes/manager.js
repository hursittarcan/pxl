const express = require("express");
const router = express.Router();
const managerController = require("../controllers/managerController");
const {authenticate, authorize} = require("../middleware/authentication");

router.post("/login", managerController.login);

router.get("/:managerId/locations",
    authenticate,
    authorize( {role:"admin"}),
    managerController.getAllLocationsOfManager);

router.get("/:managerId/locations/:locationId/scores",
    authenticate,
    authorize( {role:"admin"}),
    managerController.getScoresFromLocation);

router.get("/:managerId/locations/problems",
    authenticate,
    authorize( {role:"admin"}),
    managerController.getProblemLocations);

module.exports = router;