const mongoose = require('mongoose');
const Task = require("../models/taskModel");
const User = require("../models/userModel");

async function run() {
    try{
        await Task.deleteMany({});
        await User.deleteMany({});
        await Task.init();
        await User.init();
        let task1 = new Task({todo:"clean your room", });
        task1 = await task1.save();
        let task2 = new Task({todo:"homework", });
        task2 = await task2.save();
        let task3 = new Task({todo:"wash the car", });
        task3 = await task3.save();

        let user1 = new User({username: "root", password:"root123321", roles:["admin"]});
        user1 = await user1.save();
        let user2 = new User({username: "tim", password:"tim123321", roles:[ "user"]});
        user2.taskIds.push(task1._id);
        user2.taskIds.push(task2._id);
        user2 = await user2.save();
        task1.userId=user2._id;
        task2.userId=user2._id;
        task1=task1.save();
        task2=task2.save();

        let users = await User.find({});
        console.log("users");
        console.log(users);
        let tasks = await Task.find({});
        console.log("tasks");
        console.log(tasks);
    } catch(error){
        console.log(error.message);
    } finally {
        await mongoose.connection.close();
    }
}

run();