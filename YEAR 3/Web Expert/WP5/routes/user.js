const express = require("express");
const router = express.Router();
const userController = require("../controllers/userController");
const {authenticate, authorize} = require("../middleware/authentication");

router.get("/test", userController.test);

router.post("/login", userController.login);

router.get("/:id/task",
    authenticate,
    authorize( {role:"admin"}, {role:"user", owner: true}),
    userController.getTasksOfUser);

router.post("/add",
    authenticate,
    authorize({role:"admin"}),
    userController.addUser);

router.post("/add-task",
    authenticate,
    authorize({role:"admin"}),
    userController.addTask);

router.patch("/get-all/:taskId",
    authenticate,
    authorize( {role:"admin"}),
    userController.updateAllTasks);

router.get("/get-all-un",
    authenticate,
    authorize( {role:"admin"}),
    userController.getAllTasks);

router.patch("/:id/task/:taskId",
    authenticate,
    authorize( {role:"admin"}, {role:"user", owner: true}),
    userController.updateTaskOfUser);


module.exports = router;