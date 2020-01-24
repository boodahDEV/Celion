const { Router } = require("express");
const bcrypt = require("bcrypt");
const router = new Router();
const chest = require("../models/chest");
const user = require("../models/users");

const jwt = require("jsonwebtoken");

router.get("/", (req, res) => res.send("HEllo word"));
router.post("/signup", (req, res) => {
  const { email, password, firstname, lastname, rootKeyChest } = req.body;

  bcrypt.genSalt(10, function(err, salt) {
    if (err) {
      throw res.status(401).send(err);
    } else {
      bcrypt.hash(password, salt, function(err, hash) {
        if (err) {
          throw res.status(401).send(err);
        } else {
          res.status(200).send("save!");
        }
      });
    }
  });

  //   generateKeyPassImput(req.body.password).then(resp=>{
  //     console.log("--> ",resp)
  //   });
});

module.exports = router; // al final exporto las rutas al index principal

function verifyToken(req, res, next) {
  if (!req.headers.authorization) {
    return res.status(401).send("No esta autorizado para ver esto!");
  }

  const token = req.headers.authorization.split(" ")[1]; // separo el token del standar Bearer
  if (token === "null") {
    return res.status(401).send("No esta autorizado para ver esto!");
  }
  //optengo lo que hay dentro del token alv
  const payload = jwt.verify(token, "secretkey");
  // console.log(payload) // paso los datos a una variable que puedan acceder todas las rutas, ejemplo req
  req.userId = payload._id;
  next();
}

function CreateNewChest(key) {
  return new chest({
    chest_Key: chest
  });
}
