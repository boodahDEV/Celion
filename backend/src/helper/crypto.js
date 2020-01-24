const bcrypt = require("bcrypt");
const saltRounds = 10

async function generateKeyPassImput(params) {
     
     bcrypt.genSalt(saltRounds, function (err, salt) {
      if (err) {
        throw err
      } else {
        bcrypt.hash(params, salt, function(err, hash) {
          if (err) {
            throw err
          } else {
            console.log(hash)
          }
        });
      }
    });
}

function generateKeyForSite(params) {}

exports.generateKeyPassImput = generateKeyPassImput;
