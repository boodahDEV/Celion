const chest = require("../../models/chest");
const user = require("../../models/users");
const crypto = require("../../helper/crypto");

const jwt = require("jsonwebtoken");
const secret = require("../../config/config").secret;

async function signin(req, res) {
  const keyPass = await crypto.generateKeyPassImput(req.body.password);
  /**
   *
   * En los inicio, el chest_Key sera el mismo que la contrasena de secion
   * ya que tengo planeado que tenga un baul publico (con la misma pass que el login) y
   * el baul privado (con una key generada por el sistema de 6 digitos!)
   *
   */

  var chestNew = CreateNewChest(keyPass);
  await chestNew.save(async function (err) {
    if (err) return res.status(401).json({
      errors: err
    });
    console.log("[\x1b[32mChest\x1b[0m] -> Make \x1b[33msuccessfully\x1b[0m saved.");
    //send to frontend that chest create successfully

    var usuarios = new user({
      email: req.body.email,
      mainPass: keyPass,
      name: {
        firstName: req.body.firstname,
        lastName: req.body.lastname
      },
      chestKey: chestNew._id
    });

    await usuarios.save(function (err) {
      if (err) return res.status(401).json({
        errors: err
      });
      console.log("[\x1b[32mUser\x1b[0m]  -> \x1b[33mSuccessfully\x1b[0m saved.");
      const token = jwt.sign({
        _id: usuarios._id
      }, secret);
      res.status(200).send({
        token
      });
      //send user create successfully
    });
  }); //end save chest
}

function CreateNewChest(key) {
  return new chest({
    chest_Key: key
  });
}

exports.signup = signin;
