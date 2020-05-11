const bcrypt = require("bcryptjs");
const crypto = require("crypto");
const secret = require("./../config/config").secret


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


async function generateAccessKeyForChest(username) {
    /**
     * access = username+
     *          ping+
     *          SHA - 512
     *          char of ping
     * 
     */

    var arr = generateSHA512ForChest(secret).match(/.{1,20}/g)
    var object_for_to_ramdon = await new Promise((resolve, reject) => {

        var arr_retunr_random = new Array(7)
        arr.forEach(i=>{
            var obj_random = i[Math.round(Math.random() * 21)]
            arr_retunr_random.push(obj_random)
            
            // console.log("Sending... -> "+i)
        })
        // resolve(i)  
    });
}//

function generateSHA512ForChest(key) {
    var hash = crypto.createHmac('sha512', key)
    var value = hash.digest('hex')
    return value;
}

function generateKeyForSite(params) {}

exports.generateKeyPassImput = generateKeyPassImput;
exports.compareKeyPassImput = compareKeyPassImput;
exports.generateAccessKeyForChest = generateAccessKeyForChest;