const express = require("express");
const router = express.Router();
const locationController = require("../controllers/locationController");

router.get("/", locationController.getAllLocations);

router.get("/:locationId", locationController.findScoresOfLocation);

router.patch("/:locationId/scores", locationController.addScore)

module.exports = router;