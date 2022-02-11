const mongoose = require('mongoose');
const User = require('../models/userModel.js');
const Task = require('../models/taskModel.js');
const ObjectId = mongoose.Types.ObjectId;

module.exports.findUserByCredentials = async function(username, password) {
    const user = await User.findOneByCredentials(username, password);
    return user;
}

module.exports.findTasksOfUser = async function(id) {
    const user = await User.findById(new ObjectId(String(id)));
    if (user == null){
        return null;
    }
    const taskIds = user.taskIds;
    const tasks = await Task.find()
        .where("_id").in(taskIds)
        .exec();
    return tasks;
};

module.exports.getAllTasks = function() {
    return Task.find({});
}