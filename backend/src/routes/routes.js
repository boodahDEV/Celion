const { Router } = require("express");
const bcrypt = require("bcrypt");
const router = new Router();
const chest = require("../models/chest");
const user = require("../models/users");

const jwt = require("jsonwebtoken");

router.get("/", (req, res) => res.send("HEllo word"));
router.post("/signup", async (req, res) => {
  const { email, password, firstname, lastname, rootKeyChest } = req.body;

  await bcrypt.genSalt(10,async function(err, salt) {
    if (err) {
      throw res.status(401).send(err);
    } else {
    await bcrypt.hash(password, salt, async function(err, hash) {
        if (err) {
          throw res.status(401).send(err);
        } else {
          var chestNew = CreateNewChest(hash);
          await chestNew.save( async function(err) {
            if (err) throw err;
            console.log(
              "[\x1b[32mChest\x1b[0m] -> Make \x1b[33msuccessfully\x1b[0m saved."
            );
            //send to frontend that chest create successfully

            var usuarios = new user({
              email: email,
              mainPass: hash,
              name: {
                firstName: firstname,
                lastName: lastname
              },
              chestKey: chestNew._id
            });

            await usuarios.save(function(err) {
              if (err) throw err;
              console.log(
                "[\x1b[32mUser\x1b[0m]  -> \x1b[33mSuccessfully\x1b[0m saved."
              );
              //send user create successfully
            });
          }); //end save chest
          res.status(200).send("save!");
        }
      }); //end generate hash
    }
  });
}); //fin de la ruta /signup

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
    chest_Key: key
  });
}
