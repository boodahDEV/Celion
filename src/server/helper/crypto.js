const bcrypt = require("bcryptjs");

async function generateKeyPassImput(pass) {
    const password = pass;
    const saltRounds = 10;

    const hashedPassword = await new Promise((resolve, reject) => {
        bcrypt.hash(password, saltRounds, function(err, hash) {
            if (err) reject(err);
            resolve(hash);
        });
    });

    return hashedPassword;
} //end generateKeysOnPass

async function compareKeyPassImput(passIn, passDB) {
    const password = passIn;

    const validUser = await new Promise((resolve, reject) => {
        bcrypt.compare(password, passDB, function(err, ismatch) {
            if (err) reject(false);
            resolve(ismatch);
        });
    });

    return validUser;
} //end compareKeyPassImput

function generateKeyForSite(params) {}

exports.generateKeyPassImput = generateKeyPassImput;
exports.compareKeyPassImput = compareKeyPassImput;