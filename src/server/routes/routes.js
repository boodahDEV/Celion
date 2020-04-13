const { Router } = require("express");
const { check, validationResult } = require("express-validator");
const jwt = require("jsonwebtoken");

const router = new Router();
const signup = require("./auth/signup").signup;
const signin = require("./auth/signin").signin;

// router.get("/", (req, res) => redir ); //test Router



router.post(
  "/signup",
  [
    check("email").isEmail(),
    check("password").isLength({
      min: 8,
    }),
    check("firstname").notEmpty(),
    check("lastname").notEmpty(),
  ],
  async (req, res) => {
    // Finds the validation errors in this request and wraps them in an object with handy functions
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(422).json({
        errors: errors.array(),
      });
    }
    /**AQUI VA ALGO RESPECTO AL REGISTRO */
    signup(req, res);
  }
); //fin de la ruta /signup



router.post(
  "/signin",
  [
    check("email").isEmail(),
    check("password").isLength({
      min: 8,
    }),
  ],
  async (req, res) => {
    // Finds the validation errors in this request and wraps them in an object with handy functions
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(422).json({
        errors: errors.array(),
      });
    }
    /**AQUI VA ALGO RESPECTO AL LOGIN */
    signin(req, res);
  }
);//fin de /signup

router.get("/chest",(req, res)=>{
  
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
