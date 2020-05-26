const user = require("../../models/users");
const crypto = require("../../helper/crypto");

const jwt = require("jsonwebtoken");
const secret = require("../../config/config").secret;

async function signin(req, res) {
  const {
    email,
    password
  } = req.body;
  const users = await user.findOne({
    email: email
  });

  /** VALIDACIONES DE INGRESO */
  if (!users)
    return res.status(401).json({
      errors: "Correo incorrecto!"
    });
  const validPass = await crypto.compareKeyPassImput(password, users.mainPass);
  if (!validPass)
    return res.status(401).json({
      errors: "Contrasena incorrecta!"
    });
  /** VALIDACIONES DE INGRESO */

  // if(jwt.verify("check", secret)){
  //   console.log("check!");
  // }
  
  const token = jwt.sign({
      _id: users._id,
      check:  true
    },
    secret
  );
  console.log(`[\x1b[32mUser\x1b[0m]  -> \x1b[44m ${users._id} \x1b[0m -> \x1b[33mSuccessfully\x1b[0m connected.`);
  res.status(200).send({
    token
  });
} //end signin

exports.signin = signin;
