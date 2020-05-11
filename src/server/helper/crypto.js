const bcrypt = require("bcryptjs");
const crypto = require("crypto");
const secret = require("./../config/config").secret;

async function generateKeyPassImput(pass) {
  const password = pass;
  const saltRounds = 10;

  const hashedPassword = await new Promise((resolve, reject) => {
    bcrypt.hash(password, saltRounds, function (err, hash) {
      if (err) reject(err);
      resolve(hash);
    });
  });

  return hashedPassword;
} //end generateKeysOnPass

async function compareKeyPassImput(passIn, passDB) {
  const password = passIn;

  const validUser = await new Promise((resolve, reject) => {
    bcrypt.compare(password, passDB, function (err, ismatch) {
      if (err) reject(false);
      resolve(ismatch);
    });
  });

  return validUser;
} //end compareKeyPassImput

async function generateAccessKeyForChest(username) {
  var arr = generateSHA512ForChest(secret).match(/.{1,20}/g);
  var objects_to_ramdon = await new Promise((resolve, reject) => {
    var char_on_sha = new Array();
    var code = new Array();
    arr.forEach((i) => {
      var code_to = Math.round(Math.random() * i.length);
      var obj_random = i[code_to];
      if(obj_random != null && code_to != null || typeof obj_random != "undefined" && code_to != "undefined"){
          code.push(code_to);
          char_on_sha.push(obj_random);
      }
    });
    resolve("".concat(char_on_sha.join(""))+"-".concat(code.join(username[0])))
  });
  ping = objects_to_ramdon.toString().split("-")[0]
  char_code = objects_to_ramdon.toString().split("-")[1]
  key = username + ping +arr.join("")+"."+char_code
  console.log(key)
} //

function generateSHA512ForChest(key) {
  var hash = crypto.createHmac("sha512", key);
  var value = hash.digest("hex");
  return value;
}

function generateKeyForSite(params) {}

exports.generateKeyPassImput = generateKeyPassImput;
exports.compareKeyPassImput = compareKeyPassImput;
exports.generateAccessKeyForChest = generateAccessKeyForChest;
