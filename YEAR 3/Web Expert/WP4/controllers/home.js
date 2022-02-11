exports.homepage = function (req, res) {
    res.render("home", {
        title: "Home Page From Controller"
    });
}