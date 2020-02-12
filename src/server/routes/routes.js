const { Router } = require("express");
const { check, validationResult } = require("express-validator");
const jwt = require("jsonwebtoken");

const router = new Router();

const chest = require("../models/chest");
const user = require("../models/users");
const crypto = require("../helper/crypto");

router.get("/", (req, res) => res.send("HEllo word")); //test Router

router.post(
    "/signup", [
        check("email").isEmail(),
        check("password").isLength({ min: 8 }),
        check("firstname").notEmpty(),
        check("lastname").notEmpty()
    ],
    async(req, res) => {
        // Finds the validation errors in this request and wraps them in an object with handy functions
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(422).json({ errors: errors.array() });
        }

        const keyPass = await crypto.generateKeyPassImput(req.body.password);
        /**
         * 
         * En los inicio, el chest_Key sera el mismo que la contrasena de secion
         * ya que tengo planeado que tenga un baul publico (con la misma pass que el login) y 
         * el baul privado (con una key generada por el sistema de 6 digitos!)
         * 
         */

        var chestNew = CreateNewChest(keyPass);
        await chestNew.save(async function(err) {
            if (err) return res.status(401).json({ errors: err });
            console.log(
                "[\x1b[32mChest\x1b[0m] -> Make \x1b[33msuccessfully\x1b[0m saved."
            );
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

            await usuarios.save(function(err) {
                if (err) return res.status(401).json({ errors: err });
                console.log(
                    "[\x1b[32mUser\x1b[0m]  -> \x1b[33mSuccessfully\x1b[0m saved."
                );
                const token = jwt.sign({ _id: usuarios._id }, process.env.NODE_KEY_TOKEN)
                res.status(200).send({ token });
                //send user create successfully
            });
        }); //end save chest
    }
); //fin de la ruta /signup

router.post("/signin", [
        check("email").isEmail(),
        check("password").isLength({ min: 8 }),
    ],
    async(req, res) => {
        // Finds the validation errors in this request and wraps them in an object with handy functions
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(422).json({ errors: errors.array() });
        }
        const { email, password } = req.body
        const users = await user.findOne({ email: email })

        /** VALIDACIONES DE INGRESO */
        if (!users) return res.status(401).json({ errors: "Correo incorrecto!" });
        const validPass = await crypto.compareKeyPassImput(password, users.mainPass)
        if (!validPass) return res.status(401).json({ errors: "Contrasena incorrecta!" });
        /** VALIDACIONES DE INGRESO */

        const token = jwt.sign({ _id: users._id }, process.env.NODE_KEY_TOKEN)
        res.status(200).send({ token });
    }
);

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