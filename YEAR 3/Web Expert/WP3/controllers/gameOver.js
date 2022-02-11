exports.gameOverPage = function (req, res) {
    res.render("gameOver", {
        title: "Game Over Page From Controller"
    });
}