exports.homepage = function (req, res) {
    const { cookies } = req;
    res.render("home", {
        title: "Home Page From Controller",
        cookies: cookies.scorePreviousGame
    });
}