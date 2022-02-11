const jwt = require("jsonwebtoken");
const createError = require('http-errors');
const SECRET = process.env.SECRET;

module.exports.authenticate = async(req, res, next) => {
    try {
        const token = req.header("authorization").split(" ")[1];
        if ( !token ) {
            return next(createError(403, "A token is required for authentication."));
        }
        const decodedPayload = await jwt.verify(token, SECRET);
        req.decodedPayload = decodedPayload;
    } catch (err) {
        return next(createError(401, "Invalid authentication token."));
    }
    next();
};

module.exports.authorize = function(...permissions){
    let authorize = async (req, res, next) => {
        try {
            const decodedPayload = req.decodedPayload;
            const userRoles = decodedPayload.roles;
            let authorized = false;

            for (let permission of permissions){
                if( !decodedPayload.roles.includes(permission.role) ){
                    continue;
                }
                if( permission.owner && req.params.id != decodedPayload._id ){
                    continue;
                }
                authorized = true;
                break;
            }
            if ( !authorized ){
                return next( createError( 401, "Unauthorized." ) );
            }
        } catch (err) {
            return next(createError(401, "Invalid authentication token."));
        }
        next();
    }
    return authorize;
}

