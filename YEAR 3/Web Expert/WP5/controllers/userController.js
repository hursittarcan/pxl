const userService = require("../services/userService");
const taskService = require("../services/taskService");
const User = require("../models/userModel");
const Task = require("../models/taskModel");
const jwt = require("jsonwebtoken");
const dotenv=require("dotenv");
const mongoose = require('mongoose');
const SECRET = process.env.SECRET;
const JWT_EXPIRATION = process.env.JWT_EXPIRATION;

module.exports.login = async function(req, res, next) {
    try{
        const status = 200;
        const username = req.body.username;
        const password = req.body.password;
        let user = await userService.findUserByCredentials(username, password);
        const token = jwt.sign(
            { _id : user._id, roles: user.roles }
            , SECRET
            , {expiresIn: JWT_EXPIRATION, algorithm: "HS256" }
        );
        user = {
            _id: user._id,
            username: user.username,
            roles: user.roles
        };
        res.status(status).json({user,token});
    }
    catch(err){
        next(err);
    }
};

module.exports.getTasksOfUser = async function(req, res, next) {
    try{
        const status = 200;
        const id = req.params.id;
        const tasks=await userService.findTasksOfUser(id);
        res.status(status).json(tasks);
    } catch(err){
        next(err);
    }
};

module.exports.test = async function(req, res, next) {
    res.status(200).json("Hello World");
}

module.exports.getAllTasks = async function(req, res, next) {
    try{
        const status = 200;
        const tasks= await userService.getAllTasks();
        res.status(status).json(tasks);
        res.setHeader('Access-Control-Allow-Origin', 'http://localhost:63342');
    } catch(err){
        next(err);
    }
};

module.exports.updateAllTasks = async function(req, res, next) {
    try{
        const status = 200;
        const taskId = req.params.taskId;
        const todo = req.body.todo;
        const task = await taskService.updateTodo(taskId, todo);
        res.status(status).json(task);
        res.setHeader('Access-Control-Allow-Origin', 'http://localhost:63342');
    } catch(err){
        next(err);
    }
};

module.exports.updateTaskOfUser = async function(req, res, next) {
    try{
        const status = 200;
        const taskId = req.params.taskId;
        const completed = req.body.completed;
        const task = await taskService.update(taskId, {completed});
        res.status(status).json(task);
        res.setHeader('Access-Control-Allow-Origin', 'http://localhost:63342');
    } catch(err){
        next(err);
    }
};

module.exports.addUser = async function(req, res, next) {
    try {
        const status = 200;
        const userName = req.body.username;
        const passWord = req.body.password;

        let newUser = new User({username: userName, password: passWord, roles:["user"]});
        await newUser.save();
        res.status(status).json({newUser});
    } catch (err) {
        next(err);
    }
};

module.exports.addTask = async function(req, res, next) {
    try {
        const status = 200;
        const todoDesc = req.body.todo;

        let newTask = new Task({todo: todoDesc, completed: false, });
        await newTask.save();
        res.status(status).json({newTask});
    } catch (err) {
        next(err);
    }
};