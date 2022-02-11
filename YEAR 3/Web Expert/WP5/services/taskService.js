const mongoose = require("mongoose");
const Task = require("../models/taskModel.js");
const User = require("../models/userModel.js");
const  ObjectId = mongoose.Types.ObjectId;

exports.update = async function(taskId, { completed, userId} ) {
    let task = await Task.findById( new ObjectId( String(taskId) ) );
    if ( typeof completed != "undefined"){
        task.completed = completed;
    }
    if ( typeof userId != "undefined"){
        throw new Error("Not yet implemented");
    }
    await task.save();
    return task;
};

exports.updateTodo = async function(taskId, todo) {
    let task = await Task.findById( new ObjectId( String(taskId) ) );
    task.todo = todo;
    await task.save();
    return task;
};