const bcrypt = require("bcrypt");

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
}//end generateKeysOnPass

function generateKeyForSite(params) {}

exports.generateKeyPassImput = generateKeyPassImput;
